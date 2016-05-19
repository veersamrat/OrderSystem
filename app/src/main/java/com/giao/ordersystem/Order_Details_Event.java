package com.giao.ordersystem;

import android.content.Context;

/**
 * Created by Long on 5/14/2016.
 */
public class Order_Details_Event {
    Context context;
    public Order_Details_Event(Context _context)
    {
        context=_context;
    }
    public DishBO DishInfo_OnLoad(String dishID)
    {
        DishDAO dishDAO= new DishDAO(context);
        dishDAO.open();
        DishBO record=dishDAO.itemDish(dishID);
        dishDAO.close();
        return record;
    }
}
