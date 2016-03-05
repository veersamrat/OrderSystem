package com.giao.ordersystem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.Button;
import android.widget.Spinner;

public class Menu extends Activity{
    private Menu_Event event;
    private Spinner categorySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        event= new Menu_Event(this.getApplicationContext());
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        event.categoryListView_OnLoad(categorySpinner);
    }
}