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
    private Context context;
    public OrderDAO(Context context) {
        this.context = context;
    }
}
