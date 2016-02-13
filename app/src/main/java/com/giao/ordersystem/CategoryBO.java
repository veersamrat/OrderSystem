package com.giao.ordersystem;

/**
 * Created by Long on 2/13/2016.
 */
public class CategoryBO {
    private int categoryID;
    private String categoryName;
    public CategoryBO()
    {

    }
    public CategoryBO(int categoryID, String categoryName)
    {
        this.categoryID=categoryID;
        this.categoryName=categoryName;
    }
    public int getCategoryID() { return this.categoryID;  }
    public void setCategoryID(int categoryID)
    {
        this.categoryID=categoryID;
    }
    public String getCategoryName()
    {
        return this.categoryName;
    }
    public void setCategoryName(String categoryName)
    {
        this.categoryName=categoryName;
    }
}
