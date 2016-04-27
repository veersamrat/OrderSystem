package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Long on 2/8/2016.
 */
public class Order_Event extends Activity {
    private Context context;
    private OrderDAO orderDAO;
    public Order_Event()
    {}
    public Order_Event(Context context)
    {
        this.context=context;
        orderDAO= new OrderDAO(context);
    }
    public void homButton_OnClick()
    {
        System.exit(1);
        finish();
    }
}
