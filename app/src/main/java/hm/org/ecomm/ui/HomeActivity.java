package hm.org.ecomm.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import hm.org.ecomm.adapter.RecyclerAdapter;
import hm.org.ecomm.listener.RecyclerViewClickInterface;
import hm.org.ecomm.R;
import hm.org.ecomm.model.CategoryObject;

public class HomeActivity extends AppCompatActivity implements RecyclerViewClickInterface<CategoryObject> {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView)findViewById(R.id.categories);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        RecyclerAdapter<CategoryObject> adapter = new RecyclerAdapter<>(this,testData(),R.layout.category_item,this);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<CategoryObject> testData() {
        ArrayList<CategoryObject> categoryList = new ArrayList<>();
        categoryList.add(new CategoryObject("One", R.mipmap.ic_launcher));
        categoryList.add(new CategoryObject("Two", R.mipmap.ic_launcher));
        categoryList.add(new CategoryObject("Three", R.mipmap.ic_launcher));
        categoryList.add(new CategoryObject("Four", R.mipmap.ic_launcher));
        categoryList.add(new CategoryObject("One", R.mipmap.ic_launcher));
        categoryList.add(new CategoryObject("Two", R.mipmap.ic_launcher));
        categoryList.add(new CategoryObject("Three", R.mipmap.ic_launcher));
        categoryList.add(new CategoryObject("Four", R.mipmap.ic_launcher));
        return categoryList;
    }


    @Override
    public void onClickWidget(CategoryObject object) {

        finish();
    }
}
