package com.giao.ordersystem;

/**
 * Created by Long on 2/10/2016.
 */
public class OrderDetailsDAO {
    private int dishID;
    private int price;
    private String note;
    public OrderDetailsDAO()
    {

    }
    public OrderDetailsDAO(int dishID,int price, String note)
    {
        this.dishID=dishID;
        this.price=price;
        this.note=note;
    }
    public int getDishID(){return this.dishID;}
    public void setDishID(int note){this.dishID=dishID;}
    public int getPrice(){return this.price;}
    public void setPrice(int price){this.price=price;}
    public String getNote(){return this.note;}
    public void setNote(String note){this.note=note;}

}
