package com.giao.ordersystem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends Activity{
    private Menu_Event event;
    private static Spinner categorySpinner;
    private static Button homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        event= new Menu_Event(this.getApplicationContext());
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        event.categoryListView_OnLoad(categorySpinner);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                TextView SelectecItemtextView=(TextView)findViewById(R.id.SelectecItemtextView);
                SelectecItemtextView.setText(categorySpinner.getSelectedItem().toString());
                // your code here
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        homeButton=(Button)findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.homButton_OnClick();
            }
        });
    }
}