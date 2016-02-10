package com.giao.ordersystem;

/**
 * Created by Long on 2/10/2016.
 */
public class DishCategoryDAO {
    private int dishID;
    private String dishName;
    public DishCategoryDAO()
    {

    }
    public DishCategoryDAO(int dishID, String dishName)
    {
        this.dishID=dishID;
        this.dishName=dishName;
    }
    public int getDishID() { return this.dishID;  }
    public void setDishID(int dishID)
    {
        this.dishID=dishID;
    }
    public String getDishName()
    {
        return this.dishName;
    }
    public void setDishName(String dishName)
    {
        this.dishName=dishName;
    }
}
