package com.giao.ordersystem;

/**
 * Created by Long on 2/13/2016.
 */
public class OrderDetailsBO {
    private int orderDetailID;
    private int orderID;
    private int dishID;
    private int price;
    private String note;
    private int done;
    private int paid;
    public OrderDetailsBO()
    {

    }
    public OrderDetailsBO(int orderDetailID, int orderID, int dishID,int price, String note,int done, int paid)
    {
        this.orderDetailID=orderDetailID;
        this.orderID=orderID;
        this.dishID=dishID;
        this.price=price;
        this.note=note;
        this.done=done;
        this.paid=paid;
    }
    public int getOrderDetailID() {return this.orderDetailID; }
    public void setOrderDetailID(int orderDetailID) {this.orderDetailID = orderDetailID;}
    public int getOrderID() {return orderID;}
    public void setOrderID(int orderID) {this.orderID = orderID;}
    public int getDishID(){return this.dishID;}
    public void setDishID(int note){this.dishID=dishID;}
    public int getPrice(){return this.price;}
    public void setPrice(int price){this.price=price;}
    public String getNote(){return this.note;}
    public void setNote(String note){this.note=note;}
    public int getDone() {        return done;    }
    public void setDone(int done) {        this.done = done;    }
    public int getPaid() {        return paid;    }
    public void setPaid(int paid) {        this.paid = paid;    }
}
