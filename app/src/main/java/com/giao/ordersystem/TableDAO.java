package com.giao.ordersystem;

/**
 * Created by Long on 2/10/2016.
 */
public class TableDAO {
    private int tableID;
    private String tableName;
    public TableDAO(int tableID,String tableName)
    {
        this.tableID=tableID;
        this.tableName=tableName;
    }
    public TableDAO()
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
