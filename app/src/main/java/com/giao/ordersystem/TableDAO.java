package com.giao.ordersystem;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
/**
 * Created by Long on 2/12/2016.
 */
public class TableDAO  extends SQLiteOpenHelper {
    public static final String KEY_ROWID="TableID";
    public static final String KEY_TableName="TableName";
    private static final String DATABASE_NAME="OrderSystem";
    private static final String DATABASE_TABLE="Tables";
    private static final int DATABASE_VERSION=1;
    //
    private final Context context;
    private SQLiteDatabase database;
    public TableDAO(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        String createQuery=" CREATE TABLE Tables(TableID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "TableName TEXT NOT NULL)";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        Log.w(TableDAO.class.getName(), "Upgrading database from old to new version...");
        db.execSQL("DROP TABLE IF EXIST " + DATABASE_TABLE);
        onCreate(db);

    }
    public TableDAO open() throws SQLException
    {
        database=getReadableDatabase();
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
    public List<TableBO> list()
    {
        String query="SELECT * FROM Tables";
        Cursor cur=database.rawQuery(query,null);
        List<TableBO> list = new ArrayList<TableBO>();
        int iRow= cur.getColumnIndex(KEY_ROWID);
        for(cur.moveToFirst();!cur.isAfterLast();cur.moveToNext()) {
            TableBO record = new TableBO(Integer.parseInt(cur.getString(0)), cur.getString(1));
            list.add(record);        }
        cur.close();
        return list;
    }
    public boolean remove(int tableID)
    {
        return database.delete(DATABASE_TABLE, KEY_ROWID + "=" + tableID, null) > 0;
    }
    public boolean removeAll()
    {
        return database.delete(DATABASE_TABLE, null, null) > 0;
    }

}
