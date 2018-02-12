package hm.org.ecomm.listener;

/**
 * Created by Venkatesh.Guddanti on 2/9/2018.
 */

public interface HttpResponseListener {

    void onHttpResponseSuccess(String result);
    void onHttpResponseFailure(String result);
}
