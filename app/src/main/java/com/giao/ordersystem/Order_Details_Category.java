package com.giao.ordersystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Long on 5/14/2016.
 */
public class Order_Details_Category extends Activity{
    Order_Details_Category_Event event;
    Button homeButton;
    ListView dishCategoryListView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details_category);
        event= new Order_Details_Category_Event(this.getBaseContext());
        //Declare controls
        dishCategoryListView=(ListView)findViewById(R.id.dishCategoryListView);
        homeButton=(Button)findViewById(R.id.homeButton);
        //Load data to ListView
        event.categoryListView_OnLoad(dishCategoryListView);
        //homeButton event
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
