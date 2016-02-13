package com.giao.ordersystem;

import java.util.ArrayList;

/**
 * Created by Long on 2/13/2016.
 */
public class OrderBO {
    private int orderID;
    private int tableID;
    private String orderDate;
    private int numberOfCustomer;
    private String orderNote;
    private int orderPaid;
    private ArrayList<OrderDetailsDAO> orderDetails= new ArrayList<OrderDetailsDAO>();
    public OrderBO()
    {}
    public OrderBO(int orderID, int tableID,String orderDate,int numberOfCustomer, String orderNote,int orderPaid, ArrayList<OrderDetailsDAO> orderDetails)
    {
        this.orderID=orderID;
        this.tableID=tableID;
        this.orderDate=orderDate;
        this.numberOfCustomer=numberOfCustomer;
        this.orderNote=orderNote;
        this.orderPaid=orderPaid;
        this.orderDetails.addAll(orderDetails);
    }
    public int getOrderID(){return this.orderID;}
    public void setOrderID(int orderID){this.orderID=orderID;}
    public int getTableID(){return this.tableID;}
    public void setTableID(int tableID){this.tableID=tableID;}
    public String getOrderDate (){return this.orderDate;}
    public void setOrderDate(String orderDate){this.orderDate=orderDate;}
    public int getNumberOfCustomer(){return this.numberOfCustomer;}
    public void setNumberOfCustomer(int numberOfCustomer){this.numberOfCustomer=numberOfCustomer;}
    public String getOrderNote(){return this.orderNote;}
    public void setOrderNote(String orderNote){this.orderNote=orderNote;}
    public int getOrderPaid(){return this.orderPaid;}
    public void setOrderPaid(int orderPaid){this.orderPaid=orderPaid;}
    public ArrayList<OrderDetailsDAO> getOrderDetails(){return this.orderDetails;}
    public void setOrderDetails(ArrayList<OrderDetailsDAO> orderDetails){this.getOrderDetails().addAll(orderDetails);}
}
