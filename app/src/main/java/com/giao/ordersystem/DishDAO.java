package com.giao.ordersystem;

/**
 * Created by Long on 2/10/2016.
 */
public class DishDAO {
    private int dishID;
    private int dishCategoryID;
    private String dishName;
    private int dishPrice;
    private String dishDescription;
    public DishDAO(){}
    public DishDAO(int dishId, int dishCategoryID, String dishName,int dishPrice, String dishDescription)
    {
        this.dishID=dishId;
        this.dishCategoryID=dishCategoryID;
        this.dishName=dishName;
        this.dishPrice=dishPrice;
        this.dishDescription=dishDescription;
    }
    public int getDishID()    {return this.dishID;}
    public void setDishID(int dishID)    {this.dishID=dishID;}
    public int getDishCategoryID()    {return this.dishCategoryID;}
    public void setDishCategoryID(int dishCategoryID)    {this.dishCategoryID=dishCategoryID;}
    public String getDishName()    {return this.dishName;}
    public void setDishName(String dishName)    {this.dishName=dishName;}
    public int getDishPrice()    {return this.dishPrice;}
    public void setDishPrice(int dishPrice)    {this.dishPrice=dishPrice;}
    public String getDishDescription()    {return this.dishDescription;}
    public void setDishDescription(String dishDescription)    {this.dishDescription=dishDescription;}

}
