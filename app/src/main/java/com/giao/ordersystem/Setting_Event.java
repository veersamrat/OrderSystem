package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
/**
 * Created by Long on 2/8/2016.
 */
public class Setting_Event extends Activity {
    private final Context context;
    public Setting_Event(Context _context) {
        context = _context;
    }
    public void addTableButton_Click()
    {

    }
    public void addCategoryButton_Click()
    {

    }
    public void saveButton_Click()
    {}
    public void homeButton_Click()
    {
       // Intent intent = new Intent(context, MainActivity.class);
      //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      //  startActivity(intent);
        System.exit(1);
        finish();
    }
}
