package hm.org.ecomm.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Venkatesh.Guddanti on 2/8/2018.
 */

public class BindingViewHolder extends RecyclerView.ViewHolder{
    private ViewDataBinding bindings;

    public BindingViewHolder(View itemView) {
        super(itemView);
        bindings = DataBindingUtil.bind(itemView);
    }
    public ViewDataBinding getBindings()
    {
        return bindings;
    }
}
