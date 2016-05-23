package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Long on 2/8/2016.
 */
public class Order_Event extends Activity {
    private Context context;
    private OrderDAO orderDAO;
    private TableDAO tableDAO;
    private OrderDetailsDAO orderDetailsDAO;
    public Order_Event()
    {}
    public Order_Event(Context context)
    {
        this.context=context;
        orderDAO= new OrderDAO(context);
        tableDAO= new TableDAO(context);
        orderDetailsDAO= new OrderDetailsDAO(context);
    }
    public void tableSpinner_OnLoad(Spinner tableSpinner)
    {
        tableDAO.open();
        ArrayList<String> tableList = new ArrayList<String>();
        for(int i=0;i<tableDAO.list().size();i++)
        {
            tableList.add(tableDAO.list().get(i).getTableName());
        }
        tableDAO.close();
        ArrayAdapter<String> tableAdapter =  new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,tableList);
        tableAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        tableSpinner.setAdapter(tableAdapter);
        tableDAO.close();
    }
    public void orderButton_OnClick(String tableName)
    {
        Intent intent = new Intent(context,OrderInfo.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("tableName", tableName);
        context.startActivity(intent);
        finish();

    }
    public void saveButton_OnClick(ArrayList<Order_View> order_viewArrayList,int orderID)
    {
        try {
            //remove all orderdetails where contains OrderID
            if (order_viewArrayList.size() != 0 )
            {
                orderDAO.open();
                orderDAO.removeOrderDetails(orderID);
                orderDAO.close();
                //Add all order_view_ArrayList
                orderDetailsDAO.open();
                for(int i=0;i<order_viewArrayList.size();i++)
                {
                    Order_View temp= (Order_View)order_viewArrayList.get(i);
                    int dishID=temp.getDishID();
                    int quantity=temp.getQuantity();
                    Float price= temp.getSubtotal()/temp.getQuantity();
                    String note=temp.getNote();
                    orderDetailsDAO.create(orderID,dishID,quantity,price,note);
                }
                orderDetailsDAO.close();
            }
        }

        catch (Exception e)
        {
            Toast.makeText(context, "Failed to save and send order", Toast.LENGTH_LONG).show();
            orderDAO.close();
            orderDetailsDAO.close();
        }
    }


}
