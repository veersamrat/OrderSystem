package com.giao.ordersystem;

/**
 * Created by Long on 2/12/2016.
 */
public class TableBO {

    private int tableID;
    private String tableName;
    public TableBO(int tableID,String tableName)
    {
        this.tableID=tableID;
        this.tableName=tableName;
    }
    public TableBO()
    {

    }
    public int getTableID()
    {
        return this.tableID;
    }
    public void setTableID(int tableID)
    {
        this.tableID=tableID;
    }
    public String getTableName()
    {
        return this.tableName;
    }
    public void setTableID(String tableName)
    {
        this.tableName=tableName;
    }

}
