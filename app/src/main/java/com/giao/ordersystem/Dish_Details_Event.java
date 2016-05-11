package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Long on 5/11/2016.
 */
public class Dish_Details_Event extends Activity {
    private Context context;
    private CategoryDAO categoryDAO;
    private DishDAO dishDAO;
    public Dish_Details_Event()
    {}
    public Dish_Details_Event(Context context)
    {
        this.context=context;
        categoryDAO = new CategoryDAO(context);
        dishDAO=new DishDAO(context);
    }
    public void categorySpinner_OnLoad(Spinner categorySpinner)
    {
        categoryDAO.open();
        ArrayList<String> categoryList = new ArrayList<String>();
        for(int i=0;i<categoryDAO.list().size();i++)
        {
            categoryList.add(categoryDAO.list().get(i).getCategoryName());
        }
        categoryDAO.close();
        ArrayAdapter<String> categoryAdapter =  new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,categoryList);
        categoryAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
    }
}
