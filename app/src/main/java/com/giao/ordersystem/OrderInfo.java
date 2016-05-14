package com.giao.ordersystem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Long on 5/13/2016.
 */
public class OrderInfo extends Activity{
    private TextView tableNameTextView;
    private EditText dateEditText;
    private EditText customerQuantityEditText;
    private EditText noteEditText;
    private EditText totalEditText;
    private String tableName;
    private Button homeButton;
    private Button orderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_info);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tableName = extras.getString("tableName");
        }
        tableNameTextView=(TextView)findViewById(R.id.tableNameTextView);
        tableNameTextView.setText(tableName);
    }
}
