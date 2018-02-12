package hm.org.ecomm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hm.org.ecomm.BR;
import hm.org.ecomm.listener.RecyclerViewClickInterface;
import hm.org.ecomm.model.CategoryObject;
import hm.org.ecomm.R;
import hm.org.ecomm.viewholder.BindingViewHolder;

/**
 * Created by Venkatesh.Guddanti on 2/8/2018.
 */

public class RecyclerAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {

    private Context mContext;
    private ArrayList<T> items;
    private int layoutID;
    private RecyclerViewClickInterface<T> mClickInterface;

    public RecyclerAdapter(Context mContext,ArrayList<T> items,int layoutID)
    {
        this.mContext = mContext;
        this.items = items;
        this.layoutID = layoutID;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(layoutID,parent,false);
        return new BindingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {

        final T item = items.get(position);
        holder.getBindings().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mClickInterface.onClickWidget(item);
            }
        });
        holder.getBindings().setVariable(BR.category,item);
        holder.getBindings().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
