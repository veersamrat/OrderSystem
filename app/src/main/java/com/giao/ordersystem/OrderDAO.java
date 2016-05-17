package com.giao.ordersystem;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by Long on 2/13/2016.
 */
public class OrderDAO {
    public static final String KEY_ROWID="OrderID";
    private static final String TABLE_NAME = "TableName";
    private static final String ORDER_DATE = "OrderDate";
    private static final String NUMBER_OF_CUSTOMER = "NumberOfCustomer";
    private static final String ORDER_NOTE = "OrderNote";
    private static final String ORDER_PAID="OrderPaid";
    private static final String DATABASE_TABLE="Orders";
    private final Context context;
    private SQLiteDatabase database;
    private static DatabaseHelper databaseHelper;
    public OrderDAO(Context context) {
        this.context = context;
        databaseHelper= new DatabaseHelper(context);
    }
    public OrderDAO open () throws SQLException
    {
        database=databaseHelper.getReadableDatabase();
        return this;
    }
    public void close() throws SQLException
    {
        databaseHelper.close();
    }
    public long create(String tableName, String orderDate,  int numberOfcustomer, String orderNote,float orderPaid)
    {
        ContentValues cv= new ContentValues();
        //optimize input data
        if (tableName != null)
            cv.put(TABLE_NAME,tableName);
        if (orderDate != null)
            cv.put(ORDER_DATE, orderDate);
        if (Integer.toString(numberOfcustomer) != null)
            cv.put(NUMBER_OF_CUSTOMER,Integer.toString(numberOfcustomer));
        if (orderNote != null)
            cv.put(ORDER_NOTE, orderNote);
        if(Float.toString(orderPaid)!=null)
            cv.put(ORDER_NOTE,orderNote);
        //put data
        cv.put(TABLE_NAME, tableName);
        cv.put(ORDER_DATE,orderDate);
        cv.put(NUMBER_OF_CUSTOMER,numberOfcustomer);
        cv.put(ORDER_NOTE,orderNote);
        cv.put(ORDER_PAID, orderPaid);
        return database.insert(DATABASE_TABLE, null, cv);
    }
    public String checkTableAvailable(String tableName)
    {
        String query = "SELECT orderID FROM Orders WHERE tableName= '"+tableName+"'";
        query+=" and OrderID NOT IN(SELECT OrderID from OrderDetail)";
        Cursor cur = database.rawQuery(query, null);
        String record="";
        for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
            record = cur.getString(0);
            cur.close();
        }
        cur.close();
        return record;
    }
    public boolean remove(int orderID) throws SQLException {
        return database.delete(DATABASE_TABLE, KEY_ROWID + "=" + orderID, null) > 0;
    }

    public boolean removeAll() {
        return database.delete(DATABASE_TABLE, null, null) > 0;
    }

    public long update(String orderID,String tableName, String orderDate,  int numberOfcustomer, String orderNote,float orderPaid) throws SQLException
    {
        ContentValues cv = new ContentValues();
        if (tableName != null)
            cv.put(TABLE_NAME,tableName);
        if (orderDate != null)
            cv.put(ORDER_DATE, orderDate);
        if (Integer.toString(numberOfcustomer) != null)
            cv.put(NUMBER_OF_CUSTOMER,Integer.toString(numberOfcustomer));
        if (orderNote != null)
            cv.put(ORDER_NOTE, orderNote);
        if(Float.toString(orderPaid)!=null)
            cv.put(ORDER_NOTE,orderNote);
        return database.update(DATABASE_TABLE, cv, KEY_ROWID + "=?", new String[]{orderID});
    }
    public OrderBO itemOrder(String orderID) throws SQLException {
        String query = "SELECT TableName,OrderDate,NumberofCustomer,OrderNote,OrderPaid FROM Orders WHERE orderID='" + orderID + "'";
        Cursor cur = database.rawQuery(query, null);
        List<OrderBO> list = new ArrayList<OrderBO>();
        OrderBO record = new OrderBO();
        for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
           String tableName=cur.getString(0).toString();
            String orderDate=cur.getString(1).toString();
            int NoCustomer=Integer.parseInt(cur.getString(2).toString());
            String orderNote=cur.getString(3).toString();
            Float orderPaid=Float.parseFloat(cur.getString(4).toString());
            record = new OrderBO(Integer.parseInt(orderID),tableName,orderDate,NoCustomer,orderNote,orderPaid);
            break;
        }
        cur.close();
        return record;
    }
 /*   public ArrayList<DishBO> list() throws SQLException {
        String query = "SELECT * FROM Menu";
        Cursor cur = database.rawQuery(query, null);
        ArrayList<DishBO> list = new ArrayList<DishBO>();
        int iRow = cur.getColumnIndex(KEY_ROWID);
        for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
            int dishID;
            Float dishprice;
            int availability;
            try{dishID=Integer.parseInt(cur.getString(0));}catch (Exception e){dishID=0;}
            try{dishprice=Float.parseFloat(cur.getString(3));}catch (Exception e){dishprice=Float.parseFloat("0");}
            try{availability=Integer.parseInt(cur.getString(5));}catch (Exception e){availability=0;}
            DishBO record = new DishBO(dishID, cur.getString(1), cur.getString(2),dishprice , cur.getString(4),availability);
            list.add(record);
        }
        cur.close();
        return list;
    }
    public ArrayList<DishBO> list(String categoryName) throws SQLException {
        String query = "SELECT * FROM Menu WHERE CategoryName='"+categoryName+"'";
        Cursor cur = database.rawQuery(query, null);
        ArrayList<DishBO> list = new ArrayList<DishBO>();
        int iRow = cur.getColumnIndex(KEY_ROWID);
        for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
            int dishID;
            Float dishprice;
            int availability;
            try{dishID=Integer.parseInt(cur.getString(0));}catch (Exception e){dishID=0;}
            try{dishprice=Float.parseFloat(cur.getString(3));}catch (Exception e){dishprice=Float.parseFloat("0");}
            try{availability=Integer.parseInt(cur.getString(5));}catch (Exception e){availability=0;}
            DishBO record = new DishBO(dishID, cur.getString(1), cur.getString(2),dishprice , cur.getString(4),availability);
            list.add(record);
        }
        cur.close();
        return list;
    }
    public DishBO itemDish(String dishID) throws SQLException {

        String query = "SELECT * FROM Menu WHERE DishID= "+dishID;
        Cursor cur = database.rawQuery(query, null);
        List<DishBO> list = new ArrayList<DishBO>();
        int iRow = cur.getColumnIndex(KEY_ROWID);
        DishBO record= new DishBO();
        for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
            Float dishprice;
            int availability;
            try{dishprice=Float.parseFloat(cur.getString(3));}catch (Exception e){dishprice=Float.parseFloat("0");}
            try{availability=Integer.parseInt(cur.getString(5));}catch (Exception e){availability=0;}
            record = new DishBO(Integer.parseInt(dishID), cur.getString(1), cur.getString(2),dishprice , cur.getString(4),availability);
            cur.close();
        }
        cur.close();
        return record;
    }*/
}
class OrderDetailDAO{
    public OrderDetailDAO(){}
}
