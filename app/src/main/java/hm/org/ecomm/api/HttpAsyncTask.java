package hm.org.ecomm.api;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import hm.org.ecomm.listener.HttpResponseListener;

/**
 * Created by Venkatesh.Guddanti on 2/9/2018.
 */

public class HttpAsyncTask extends AsyncTask<Void,Void,Void> {

    private String mUrl;
    private String reqType;
    private HttpResponseListener mListener;
    private String successResponse;
    private String failureResponse;

    public HttpAsyncTask(Context mContext, String mUrl, String reqType, HttpResponseListener mListener)
    {
        this.mUrl = mUrl;
        this.reqType = reqType;
        this.mListener = mListener;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Void doInBackground(Void... voids) {
        HttpsURLConnection con = null;

        try {
            URL url = new URL(mUrl);
            con = (HttpsURLConnection)url.openConnection();
            con.setRequestMethod(reqType);
            con.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
           successResponse = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                   failureResponse = ex.getLocalizedMessage();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(successResponse != null)
        {
            mListener.onHttpResponseSuccess(successResponse);
        }
        if(failureResponse != null)
        {
            mListener.onHttpResponseFailure(failureResponse);
        }
    }

}
