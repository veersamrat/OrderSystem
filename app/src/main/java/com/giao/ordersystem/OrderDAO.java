package com.giao.ordersystem;
import android.support.annotation.NonNull;

import java.util.*;

/**
 * Created by Long on 2/10/2016.
 */
public class OrderDAO{
    private int orderID;
    private int tableID;
    private String orderDate;
    private int numberOfCustomer;
    private String orderNote;
    private ArrayList<OrderDetailsDAO> orderDetails= new ArrayList<OrderDetailsDAO>();
    public OrderDAO()
    {}
    public OrderDAO(int orderID, int tableID,String orderDate,int numberOfCustomer, String orderNote, ArrayList<OrderDetailsDAO> orderDetails)
    {
        this.orderID=orderID;
        this.tableID=tableID;
        this.orderDate=orderDate;
        this.numberOfCustomer=numberOfCustomer;
        this.orderNote=orderNote;
        this.orderDetails.addAll(orderDetails);
    }
    public int getOrderID(){return this.orderID;}
    public void setOrderID(int orderID){this.orderID=orderID;}
    public int getTableID(){return this.tableID;}
    public void setTableID(int tableID){this.tableID=tableID;}


}
