package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

/**
 * Created by Long on 2/8/2016.
 */
public class Setting_Event extends Activity {
    private final Context context;
    private TableDAO tableDAO;
    private CategoryDAO categoryDAO;
    public Setting_Event(Context _context) {
        context = _context;
    }
    public void addTableButton_Click(String tableName)
    {
        tableDAO.create(tableName);
    }
    public void addCategoryButton_Click(String categoryName)
    {
        categoryDAO.create(categoryName);
    }
    public void saveButton_Click()
    {

    }
    public void homeButton_Click()
    {
        System.exit(1);
        finish();
    }
}
