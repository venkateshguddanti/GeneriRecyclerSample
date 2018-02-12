package hm.org.ecomm.handler;

import hm.org.ecomm.model.CategoryObject;
import hm.org.ecomm.listener.RecyclerViewClickInterface;

/**
 * Created by Venkatesh.Guddanti on 2/8/2018.
 */

public class EventHandler {

    RecyclerViewClickInterface mEventHandlerInterface;

    public void onItemclick(CategoryObject value)
    {
        mEventHandlerInterface.onClickWidget(value);
    }
}
