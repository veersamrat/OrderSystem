package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 2/8/2016.
 */
public class Setting_Event extends Activity {
    private final Context context;
    private TableDAO tableDAO;
    private CategoryDAO categoryDAO;
    public Setting_Event(Context _context) {
        context = _context;
        tableDAO= new TableDAO(context);
        categoryDAO= new CategoryDAO(context);
    }
    public void tableListView_OnLoad(ListView list){

        tableDAO.open();
        TableAdapter tableAdapter = new TableAdapter(context, tableDAO.list());
        list.setAdapter(tableAdapter);
        tableDAO.close();
      //  tableAdapter.notifyDataSetChanged();
    }
    public void categoryListView_OnLoad(ListView list){
        categoryDAO.open();
        CategoryAdapter categoryAdapter = new CategoryAdapter(context, categoryDAO.list());
        list.setAdapter(categoryAdapter);
        categoryDAO.close();
     //   categoryAdapter.notifyDataSetChanged();
    }
    public void addTableButton_Click(String tableName,ListView list)
    {
        try {
            tableDAO.open();
            tableDAO.create(tableName);
            Toast.makeText(context, "Table inserted successful",Toast.LENGTH_LONG ).show();
            TableAdapter tableAdapter = new TableAdapter(context, tableDAO.list());
            list.setAdapter(tableAdapter);
            tableDAO.close();
        }
        catch (Exception e) {
            Toast.makeText(context, "Failed. Please try again",Toast.LENGTH_LONG ).show();
            tableDAO.close();
        }
    }
    public void addCategoryButton_Click(String categoryName, ListView list)
    {
        try {
            categoryDAO.open();
            categoryDAO.create(categoryName);
            Toast.makeText(context, "Food Category inserted successful",Toast.LENGTH_LONG ).show();
            CategoryAdapter categoryAdapter = new CategoryAdapter(context, categoryDAO.list());
            list.setAdapter(categoryAdapter);
            categoryDAO.close();
        }
        catch (Exception e) {
            Toast.makeText(context, "Failed. Please try again", Toast.LENGTH_LONG).show();
            categoryDAO.close();
        }
    }
    public void saveButton_Click(ArrayList<TableBO> tableCollection, ArrayList<CategoryBO> categoryCollection)
    {
        //remove all
        tableDAO.removeAll();
        categoryDAO.removeAll();
        //then insert all
        for(TableBO tb:tableCollection)
        {
            //Insert each row
        }
        for(CategoryBO ct:categoryCollection)
        {
            //Insert each row
        }
    }
    public void homeButton_Click() {
        System.exit(1);
        finish();
    }
}
