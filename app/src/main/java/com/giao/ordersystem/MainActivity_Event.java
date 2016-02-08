package com.giao.ordersystem;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.os.Process;
import android.widget.Toast;
import android.content.*;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Long on 2/7/2016.
 */
public class MainActivity_Event extends Activity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private final Context context;
    public MainActivity_Event(Context _context) {
        context=_context;
    }

    public void orderButton_Click() {
        Intent orderIntent = new Intent("com.giao.ordersystem.Order");
        orderIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(orderIntent);

     //   finish();
    }

    public void menuButton_Click() {
        Intent orderIntent = new Intent("com.giao.ordersyste.Menu");
        orderIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(orderIntent);
    }

    public void tableButton_Click() {
        Intent orderIntent = new Intent("com.giao.ordersystem.Tables");
        orderIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(orderIntent);
    }
    public void settingButton_Click() {
        Intent orderIntent = new Intent("com.giao.ordersystem.Setting");
        orderIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(orderIntent);
    }

    public void exitButton_Click() {
        android.os.Process.killProcess(Process.myPid());
        System.exit(1);
        finish();
    }


}
