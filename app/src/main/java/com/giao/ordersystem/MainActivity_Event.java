package com.giao.ordersystem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Long on 2/7/2016.
 */
public class MainActivity_Event extends Activity{
    public void orderButton_Click()
    {
        Intent orderIntent=new Intent("com.giao.ordersystem.Order");
        startActivity(orderIntent);
        Toast.makeText(MainActivity_Event.this, "Order", Toast.LENGTH_SHORT).show();
        finish();
    }
    public  void menuButton_Click()
    {
        Intent orderIntent=new Intent("com.giao.ordersyste.Mmenu");
        startActivity(orderIntent);
        Toast.makeText(MainActivity_Event.this, "Menu", Toast.LENGTH_SHORT).show();
    }
    public  void tableButton_Click()
    {
        Intent orderIntent=new Intent("com.giao.ordersystem.Table");
        startActivity(orderIntent);
        Toast.makeText(MainActivity_Event.this, "Table", Toast.LENGTH_SHORT).show();
    }
    public  void exitButton_Click()
    {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
