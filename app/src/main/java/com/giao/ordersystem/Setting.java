package com.giao.ordersystem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Setting extends Activity{
    private Button addTableButton;
    private Button addCategoryButton;
    private Button saveButton;
    private Button homeButton;
    private EditText tableEditText;
    private EditText categoryEditText;
    private ListView tableListView;
    private ListView catetoryListView;
    private Setting_Event event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        event=new Setting_Event(this.getApplicationContext());
        Init();
    }
    private void Init()
    {
        // addTableButton, OclickListener
        addTableButton = (Button)findViewById(R.id.addTableButton);
        addTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.addTableButton_Click();
            }
        });
        //addCategoryButton, OnClickListener
        addCategoryButton =(Button)findViewById(R.id.addCategoryButton);
        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {event.addCategoryButton_Click();      }
        });
        //SaveButton, OnClickListener
        saveButton=(Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.saveButton_Click();
            }
        });
        //HomeButton, OnClickListener
        homeButton=(Button)findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.homeButton_Click();
            }
        });
    }
}