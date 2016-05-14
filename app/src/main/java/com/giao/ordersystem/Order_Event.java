package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Long on 2/8/2016.
 */
public class Order_Event extends Activity {
    private Context context;
    private OrderDAO orderDAO;
    private TableDAO tableDAO;
    public Order_Event()
    {}
    public Order_Event(Context context)
    {
        this.context=context;
        orderDAO= new OrderDAO(context);
        tableDAO= new TableDAO(context);
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
        intent.putExtra("tableName",tableName);
        context.startActivity(intent);

        finish();

    }


}
