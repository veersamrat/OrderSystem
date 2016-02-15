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
    private TableDAO tableDAO;
    private CategoryDAO categoryDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        event=new Setting_Event(this.getApplicationContext());
        Init();
        tableDAO = new TableDAO(this.getApplicationContext());
        categoryDAO= new CategoryDAO(this.getApplicationContext());
    }
    private void Init()
    {
        //tableName EditText
        tableEditText=(EditText)findViewById(R.id.tableNameEditText);
        //CategoryName EditText
        categoryEditText=(EditText)findViewById(R.id.categoryEditText);
        // addTableButton, OclickListener
        addTableButton = (Button)findViewById(R.id.addTableButton);
        addTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName=tableEditText.getText().toString();
                event.addTableButton_Click(tableName);
            }
        });
        //addCategoryButton, OnClickListener
        addCategoryButton =(Button)findViewById(R.id.addCategoryButton);
        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryName=categoryEditText.getText().toString();
                event.addCategoryButton_Click(categoryName);      }
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