package com.giao.ordersystem;

/**
 * Created by Long on 2/12/2016.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.System.currentTimeMillis;

public class TableAdapter extends BaseAdapter implements View.OnFocusChangeListener{
    private Context context;
    private ArrayList<TableBO> data;
    private static LayoutInflater inflater = null;
    private EditText mText;
    private final int minDelta;           // threshold in ms
    private long focusTime;                 // time of last touch
    private View focusTarget;
    public TableAdapter(Context context, ArrayList<TableBO> data) {
        // TODO Auto-generated constructor stub
        minDelta = 300;           // threshold in ms
        focusTime = 0;                 // time of last touch
        View focusTarget = null;
        this.context = context;
        this.data= new ArrayList<TableBO>(data);
      //  this.this.data=data;
  //      inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  //      notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public TableBO getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder= new Holder();
        final long mTextLostFocusTimestamp = -1;
        View vi;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.listview_layout, null, true);
        }
        else {

            vi = convertView;
            holder.edittext = (EditText) vi.findViewById(R.id.EditTableEditText);
            mText=(EditText) vi.findViewById(R.id.EditTableEditText);
            holder.button = (Button) vi.findViewById(R.id.DeleteTableButton);
            TableBO temp = (TableBO) data.get(position);
            holder.edittext.setText(temp.getTableName());

            holder.button.setTag(temp.getTableName());
            holder.button.setTag(position);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = (Integer) v.getTag();
                    TableBO table = data.get(index);
                    data.remove(table);
                    notifyDataSetChanged();
                }
            });
            holder.edittext.setOnFocusChangeListener(this);
            vi.setTag(holder);
        }
        return vi;
    }
    public class Holder{EditText edittext; Button button;}

    //This Listener used to keep enable the edit mode of EditText
    /*If focus was on a different view, then that view loses focus
    2. the target gains focus
    3. soft keyboard pops up.
            4. this causes the target to lose focus
    5. the code detects this situation and calls target.requestFocus()
    6. the leftmost, topmost view gains focus, due to Android nonsense
    7. the leftmost view loses focus, due to requestFocus being called
    8. target finally gains focus*/
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        long t = System.currentTimeMillis();
        long delta = t - focusTime;
        if (hasFocus) {     // gained focus
            if (delta > minDelta) {
                focusTime = t;
                focusTarget = v;
            }
        }
        else {              // lost focus
            if (delta <= minDelta  &&  v == focusTarget) {
                focusTarget.post(new Runnable() {   // reset focus to target
                    public void run() {
                        focusTarget.requestFocus();
                    }
                });
            }
        }
    }}
