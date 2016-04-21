package com.giao.ordersystem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.Button;
import android.widget.ListView;


public class Tables extends Activity{
    private Tables_Event event;
    private static Button homeButton;
    private static ListView tableLitView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tables);
     //   event= new Tables_Event(this.getApplicationContext());
        tableLitView = (ListView) findViewById(R.id.tableListView);
        event.tableListView_OnLoad(tableLitView);

    }
}