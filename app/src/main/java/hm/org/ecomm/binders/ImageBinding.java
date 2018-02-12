package hm.org.ecomm.binders;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by Venkatesh.Guddanti on 2/8/2018.
 */

public class ImageBinding  {
    @BindingAdapter({"android:src"})
    public static void setImageView(ImageView imageView,int imageUrl)
    {
        imageView.setBackgroundResource(imageUrl);
    }
}
