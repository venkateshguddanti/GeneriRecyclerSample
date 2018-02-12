package hm.org.ecomm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.Observable;

/**
 * Created by Venkatesh.Guddanti on 2/8/2018.
 */

public class CategoryObject extends BaseObservable{
    private String name;

    private int imageUrl;
    public CategoryObject(String name, int imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public int getImageUrl() {
        return imageUrl;
    }

}
