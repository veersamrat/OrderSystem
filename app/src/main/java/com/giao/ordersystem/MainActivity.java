package com.giao.ordersystem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.R.*;
import android.widget.Button;

public class MainActivity extends Activity{

    private Button menuButton;
    private Button orderButton;
    private Button tableButton;
    private Button exitButton;
    private MainActivity_Event event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        event=new MainActivity_Event();
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
