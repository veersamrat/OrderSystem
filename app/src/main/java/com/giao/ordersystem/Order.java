package com.giao.ordersystem;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Order extends Activity{
   // private Tables_Event table_event;
    private Order_Event event;
    private Order_Details_Event orderDetails_event;
    private OrderInfo_Event orderInfo_event;
    private static Button homeButton;
    private static Button orderButton;
    private static ListView orderListView;
    private static Spinner tableSpinner;
    private static Button saveButton;
    private String selectedTable;
    private int orderID;
    @Override
    protected void onResume()
    {
        super.onResume();
        orderDetails_event.orderListView_OnLoad(orderListView,selectedTable);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        //tables_event= new Tables_Event(this.getApplicationContext());
      //  table_event= new Tables_Event(this.getBaseContext());
        event= new Order_Event(this.getBaseContext());
        orderDetails_event= new Order_Details_Event(this.getBaseContext(),this);
        orderInfo_event= new OrderInfo_Event(this.getBaseContext());
        //Declare Controls
        tableSpinner= (Spinner)findViewById(R.id.tableSpinner);
        orderListView=(ListView)findViewById(R.id.orderListView);
        orderButton=(Button)findViewById(R.id.saveButton);
        homeButton=(Button)findViewById(R.id.homeButton);
        saveButton=(Button)findViewById(R.id.saveButton);
        //Load tableSpinner data
        event.tableSpinner_OnLoad(tableSpinner);
        //Load Dish to ListView
        selectedTable=tableSpinner.getItemAtPosition(0).toString();
        orderID=orderInfo_event.getOrderbyTable(selectedTable);
        orderDetails_event.orderListView_OnLoad(orderListView, selectedTable);
        //tableSpinner event
        tableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //Set the selected catogory into Red
                ((TextView)parentView.getChildAt(0)).setTextColor(Color.rgb(255, 000, 000));
                //Load Dish to ListView
                selectedTable=tableSpinner.getItemAtPosition(position).toString();
                orderID=orderInfo_event.getOrderbyTable(selectedTable);
                orderDetails_event.orderListView_OnLoad(orderListView, selectedTable);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        //OrderListView event
        orderListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                   int position, long id) {
            TextView SelectecItemtextView = (TextView) findViewById(R.id.SelectecItemtextView);
            SelectecItemtextView.setText(orderListView.getSelectedItem().toString());
            // your code here
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {            // your code here
        }
                                                }

        );
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                event.orderButton_OnClick(selectedTable);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get orderID
                //get current orderDetails in ListView
                ArrayList<Order_View> orderDetailCollection = new ArrayList<Order_View>();
                ListAdapter orderList= orderListView.getAdapter();
                for(int i=0;i<orderList.getCount();i++)
                {
                    orderDetailCollection.add((Order_View) orderList.getItem(i));
                }
                event.saveButton_OnClick(orderDetailCollection,orderID);
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
