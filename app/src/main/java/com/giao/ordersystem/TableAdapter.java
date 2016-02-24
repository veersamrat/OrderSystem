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

public class TableAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<TableBO> data;
    private static LayoutInflater inflater = null;

    public TableAdapter(Context context, ArrayList<TableBO> data) {
        // TODO Auto-generated constructor stub
     //   super(context,R.id.tableListView,data);
        this.context = context;
        this.data= new ArrayList<TableBO>(data);
      //  this.this.data=data;

        notifyDataSetChanged();
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
        Holder holder= new Holder();
        View vi;
        if(convertView == null) {
            vi = inflater.inflate(R.layout.listview_layout, null);
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        else
            vi=convertView;
        holder.edittext=(EditText)vi.findViewById(R.id.EditTableEditText);
        holder.button=(Button)vi.findViewById(R.id.DeleteTableButton);
        TableBO temp=(TableBO)data.get(position);
        holder.edittext.setText(temp.getTableName());
        holder.button.setTag(temp.getTableName());
        vi.setTag(holder);
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + data.get(position).getTableName(), Toast.LENGTH_LONG).show();
            }
        });

        return vi;
    }
    public class Holder{EditText edittext; Button button;}

}
