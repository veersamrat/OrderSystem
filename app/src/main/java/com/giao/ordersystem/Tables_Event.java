package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

/**
 * Created by Long on 2/8/2016.
 */
public class Tables_Event extends Activity {
    private Context context;
    private TableDAO tableDAO;
    public Tables_Event()
    {}
    public Tables_Event(Context context)
    {
        this.context=context;
        tableDAO= new TableDAO(context);
    }
    public void tableListView_OnLoad(ListView tableListView)
    {
        tableDAO.open();
        TableAdapter tableAdapter = new TableAdapter(context, tableDAO.list());
        tableListView.setAdapter(tableAdapter);
        tableDAO.close();
    }
    public void homButton_OnClick()
    {
        System.exit(1);
        finish();
    }

}
