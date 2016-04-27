package com.giao.ordersystem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Order extends Activity{
    private Tables_Event tables_event;
    private Order_Event event;
    private static Button homeButton;
    private static ListView tableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        tables_event= new Tables_Event(this.getApplicationContext());
        event= new Order_Event(this.getApplicationContext());
        tableListView = (ListView) findViewById(R.id.tableListView2);
        tableListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                       int position, long id) {
                TextView SelectecItemtextView = (TextView) findViewById(R.id.SelectecItemtextView);
                SelectecItemtextView.setText(tableListView.getSelectedItem().toString());
                // your code here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        }

        );
        tables_event.tableListView_OnLoad(tableListView);
        homeButton=(Button)findViewById(R.id.homeButton2);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.homButton_OnClick();
            }
        });
    }
}
