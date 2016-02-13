package com.giao.ordersystem;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Long on 2/13/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="OrderSystem";
    private static final String TABLE_TABLES="Tables";
    private static final String TABLE_CATEGORY="Category";
    private static final String TABLE_ORDER="Order";
    private static final String TABLE_ORDERDETAIL="OrderDetail";
    private static final String TABLE_MENU="Menu";
    //Tables Table columns
    public static final String TableID="TableID";
    public static final String TableName="TableName";
    //Category Table columns
    public static final String CategoryID="CategoryId";
    public static final String CategoryName="CategoryName";
    //Order Table columns
    public static final String OrderID="OrderID";
    public static final String Order_TableID="TableID";
    public static final String OrderDate="OrderDate";
    public static final String NumberOfCustomer="NumberOfCustomer";
    public static final String OrderNote="OrderNote";
    public static final String OrderPaid="OrderPaid";
    //OrderDetails Table columns
    public static final String OrderDetailID="OrderDetailID";
    public static final String OrderDetail_OrderID="OrderID";
    public static final String OrderDetail_DishID="DishID";
    public static final String Price="Price";
    public static final String Note="Note";
    //Menu Table columns
    public static final String DishID="DishID";
    public static final String Dish_CategoryID="CategoryID";
    public static final String DishName="DishName";
    public static final String DishPrice="DishPrice";
    public static final String DishDescription="DishDescription";
    private static final int DATABASE_VERSION=1;
    public DatabaseHelper(Context context)
    {super(context,DATABASE_NAME,null,DATABASE_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String CreateTABLE_TABLES="CREATE TABLE "+TABLE_TABLES+" ("+TableID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TableName+ "TEXT NOT NULL "
                +")";
        String CreateTABLE_CATEGORY="CREATE TABLE "+TABLE_CATEGORY+" ("+CategoryID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CategoryName+ "TEXT NOT NULL, "
                +")";
        String CreateTABLE_ORDER="CREATE TABLE "+TABLE_ORDER+" ("+OrderID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Order_TableID+ "INTEGER NOT NULL, "
                + OrderDate+ "DATETIME NOT NULL, "
                + NumberOfCustomer+ "INTEGER, "
                + OrderNote+ "TEXT, "
                + OrderPaid+ "REAL "
                +")";
        String CreateTABLE_MENU="CREATE TABLE "+TABLE_MENU+" ("+DishID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Dish_CategoryID+ "INTEGER NOT NULL, "
                + DishName+ "TEXT NOT NULL, "
                + DishPrice+ "REAL, "
                + DishDescription+ "TEXT, "
                +")";
        String CreateTABLE_ORDERDETAIL="CREATE TABLE "+TABLE_ORDERDETAIL+" ("+OrderDetailID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OrderDetail_OrderID+ "TEXT NOT NULL, "
                + OrderDetail_DishID+ "TEXT NOT NULL, "
                + Price+ "TEXT NOT NULL, "
                + Note+ "TEXT NOT NULL, "
                +")";
        db.execSQL(CreateTABLE_TABLES);
        db.execSQL(CreateTABLE_CATEGORY);
        db.execSQL(CreateTABLE_ORDER);
        db.execSQL(CreateTABLE_MENU);
        db.execSQL(CreateTABLE_ORDERDETAIL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.w(TableDAO.class.getName(), "Upgrading database from old to new version...");
        db.execSQL("DROP TABLE IF EXIST " + TABLE_TABLES);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_MENU);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_ORDER);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_ORDERDETAIL);
        onCreate(db);
    }
}
