package com.giao.ordersystem;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 2/8/2016.
 */
public class Tables_Event {
    private Context context;
    private CategoryDAO categoryDAO;
    public Tables_Event()
    {}
    public Tables_Event(Context context)
    {
        this.context=context;
        TableDAO tableDAO= new TableDAO(context);
    }
    public void tableListView_OnLoad(ListView tableListView)
    {
        categoryDAO.open();
        List<String> categoryList = new ArrayList<String>();
        for(int i=0;i<categoryDAO.list().size();i++)
        {
            categoryList.add(categoryDAO.list().get(i).getCategoryName());
        }
        categoryDAO.close();
        ArrayAdapter<String> categoryAdapter =  new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,categoryList);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tableListView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }

}
