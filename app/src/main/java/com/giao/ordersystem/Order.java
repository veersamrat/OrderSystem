package com.giao.ordersystem;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Order extends Activity{
   // private Tables_Event table_event;
    private Order_Event event;
    private static Button homeButton;
    private static Button orderButton;
    private static ListView orderListView;
    private static Spinner tableSpinner;
    private String selectedTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        //tables_event= new Tables_Event(this.getApplicationContext());
      //  table_event= new Tables_Event(this.getBaseContext());
        event= new Order_Event(this.getBaseContext());
        //Declare Controls
        tableSpinner= (Spinner)findViewById(R.id.tableSpinner);
        orderListView=(ListView)findViewById(R.id.orderListView);
        orderButton=(Button)findViewById(R.id.orderButton);
        homeButton=(Button)findViewById(R.id.homeButton);
        //Load tableSpinner data
        event.tableSpinner_OnLoad(tableSpinner);
  //      selectedTable=tableSpinner.getItemAtPosition(0).toString();
        //tableSpinner event
        tableSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(255, 000, 000));
                selectedTable=parent.getItemAtPosition(position).toString();
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
        public void onNothingSelected(AdapterView<?> parentView) {
            // your code here
        }
    }

        );
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.orderButton_OnClick(selectedTable);
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
