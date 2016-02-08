package com.giao.ordersystem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{

    private Button menuButton;
    private Button orderButton;
    private Button tableButton;
    private Button settingButton;
    private Button exitButton;

    private MainActivity_Event event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        event=new MainActivity_Event(getApplicationContext());
        Init_Control();
    }
    protected void Init_Control()
    {
        //Order Button
        orderButton=(Button)findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.orderButton_Click();
            }
        });
        //Menu Button
        menuButton=(Button)findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.menuButton_Click();
            }
        });
        //Table Button
        tableButton=(Button)findViewById(R.id.tableButton);
        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.tableButton_Click();
            }
        });
        settingButton=(Button)findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.settingButton_Click();
            }
        });
        //Exit Button
        exitButton=(Button)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.exitButton_Click();
            }
        });
    }


}
