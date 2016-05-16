package com.giao.ordersystem;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Long on 5/13/2016.
 */
public class OrderInfo_Event {
    OrderDAO orderDAO;
    Context context;
    public OrderInfo_Event(Context _context)
    {
        context=_context;
        orderDAO= new OrderDAO(context);
    }
    public void orderInfoOK_OnClick(String tableName, String orderDate,  int numberOfcustomer, String orderNote,float orderPaid)
    {
        try {
            orderDAO.open();
            orderDAO.create(tableName,orderDate,numberOfcustomer,orderNote,orderPaid);
            Toast.makeText(context, "Insert new dish succesfully", Toast.LENGTH_LONG).show();
            orderDAO.close();
        }
        catch (Exception e) {
            Toast.makeText(context, "Failed to insert Dish", Toast.LENGTH_LONG).show();
            orderDAO.close();
        }}
}
