package com.giao.ordersystem;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Long on 6/2/2016.
 */
public class PrinterSetting extends Activity {
    // will show the statuses like bluetooth open, close or data sent
    TextView myLabel;
    // will enable user to enter any text to be printed
    EditText myTextbox;
    Button openButton ;
    Button sendButton;
    Button closeButton;
    Button homeButton;
    PrinterSetting_Event event;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.printer_setting);
        try {
            // text label and input box
            myLabel = (TextView) findViewById(R.id.label);
            myTextbox = (EditText) findViewById(R.id.entry);
            event= new PrinterSetting_Event(myLabel,myTextbox);
            // we are going to have three buttons for specific functions
            openButton = (Button) findViewById(R.id.open);
            sendButton = (Button) findViewById(R.id.send);
            closeButton = (Button) findViewById(R.id.close);
            homeButton=(Button) findViewById(R.id.homeButton);
            // open bluetooth connection
            openButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        event.findBT();
                        event.openBT();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            // send data typed by the user to be printed
            sendButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        event.sendData("", null,null);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            // close bluetooth connection
            closeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    try {
                        event.closeBT();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            // home button
            homeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });


        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
