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
public class DishDAO {
    private static final String KEY_ROWID = "dishID";
    private static final String CATEGORYID = "categoryID";
    private static final String DISH_NAME = "dishName";
    private static final String DISH_PRICE = "dishPrice";
    private static final String DISH_DESCRIPTION = "dishDescription";
    private static final String DATABASE_TABLE = "Menu";
    private static DatabaseHelper databaseHelper;
    //
    public final Context context;
    private SQLiteDatabase database;

    public DishDAO(Context context) {
        this.context = context;
        // TODO Auto-generated constructor stub
    }

    public DishDAO open() throws SQLException {
        database = databaseHelper.getReadableDatabase();
        return this;
    }

    public void close() throws SQLException {
        this.close();
    }

    public long create(String categoryID, String dishName, String dishPrice, String dishDecription) throws SQLException {
        ContentValues cv = new ContentValues();
        cv.put(CATEGORYID, categoryID);
        cv.put(DISH_NAME, dishName);
        cv.put(DISH_PRICE, dishPrice);
        cv.put(DISH_DESCRIPTION, dishDecription);
        return database.insert(DATABASE_TABLE, null, cv);
    }

    public List<DishBO> list() throws SQLException {
        String query = "SELECT * FROM Tables";
        Cursor cur = database.rawQuery(query, null);
        List<DishBO> list = new ArrayList<DishBO>();
        int iRow = cur.getColumnIndex(KEY_ROWID);
        for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
            DishBO record = new DishBO(Integer.parseInt(cur.getString(0)), Integer.parseInt(cur.getString(1)), cur.getString(2)
                    , Integer.parseInt(cur.getString(3)), cur.getString(4));
            list.add(record);
        }
        cur.close();
        return list;
    }

    public boolean remove(int dishID) throws SQLException {
        return database.delete(DATABASE_TABLE, KEY_ROWID + "=" + dishID, null) > 0;
    }

    public boolean removeAll() {
        return database.delete(DATABASE_TABLE, null, null) > 0;
    }

    public long update(String dishID, String categoryID, String dishName, String dishPrice, String dishDecription) throws SQLException
    {
        ContentValues cv = new ContentValues();
        if (categoryID != null)
            cv.put(CATEGORYID, categoryID);
        if (dishName != null)
            cv.put(DISH_NAME, dishName);
        if (dishPrice != null)
            cv.put(DISH_PRICE, dishPrice);
        if (dishDecription != null)
            cv.put(DISH_DESCRIPTION, dishDecription);
        return database.update(DATABASE_TABLE, cv, KEY_ROWID + "=?", new String[]{dishID});
    }
}

