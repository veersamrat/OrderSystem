package com.giao.ordersystem;

/**
 * Created by Long on 5/21/2016.
 */
public class Order_View {
    private int quantity;
    private String dishName;
    private Float subtotal;
    private String note;
    public Order_View(int quantity,String dishName,Float subtotal,String note)
    {
        this.quantity=quantity;
        this.dishName=dishName;
        this.subtotal=subtotal;
        this.note=note;
    }
    public void setQuantity(int quantity){this.quantity=quantity;}
    public int getQuantity(){return this.quantity;}
    public void setdishName(String dishName){this.dishName=dishName;}
    public String getdishName(){return this.dishName;}
    public void setSubtotal(Float subtotal){this.subtotal=subtotal;}
    public Float getSubtotal(){return this.subtotal;}
    public void setNote(String note){this.note=note;}
    public String getNote(){return this.note;}
}
