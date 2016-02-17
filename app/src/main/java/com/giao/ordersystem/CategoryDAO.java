package com.giao.ordersystem;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by Long on 2/12/2016.
 */
public class CategoryDAO{
    public static final String KEY_TableName="CategoryName";
    private static final String DATABASE_TABLE="Category";
    private static DatabaseHelper databaseHelper;
    //
    public final Context context;
    private SQLiteDatabase database;
    public CategoryDAO(Context context) {
        this.context=context;
        // TODO Auto-generated constructor stub
    }
    public CategoryDAO open() throws SQLException
    {
        database=databaseHelper.getReadableDatabase();
        return this;
    }
    public void close() throws SQLException
    {
        this.close();
    }
    public long create(String tableName) throws SQLException
    {
        ContentValues cv= new ContentValues();
        cv.put(KEY_TableName, tableName);
        return database.insert(DATABASE_TABLE,null ,cv);
    }
    public List<CategoryBO> list()
    {
        String query="SELECT * FROM Category";
        Cursor cur=database.rawQuery(query,null);
        List<CategoryBO> list = new ArrayList<CategoryBO>();
        int iRow= cur.getColumnIndex(KEY_TableName);
        for(cur.moveToFirst();!cur.isAfterLast();cur.moveToNext()) {
            CategoryBO record = new CategoryBO(cur.getString(0));
            list.add(record);        }
        cur.close();
        return list;
    }
    public boolean remove(int categoryID)
    {
        return database.delete(DATABASE_TABLE, KEY_TableName + "=" + categoryID, null) > 0;
    }
    public boolean removeAll()
    {
        return database.delete(DATABASE_TABLE, null, null) > 0;
    }

}