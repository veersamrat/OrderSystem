package com.giao.ordersystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Long on 5/9/2016.
 */
public class Table_Order_Adatper  extends BaseAdapter {
    private Context context;
    private ArrayList<TableBO> data;
    private static LayoutInflater inflater = null;

    private Button tableButton;

    public Table_Order_Adatper(Context context, ArrayList<TableBO> data) {
        // TODO Auto-generated constructor stub

        this.context = context;
        this.data= new ArrayList<TableBO>(data);

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
        View vi = convertView;
        if (vi == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.table_order, null, true);
        }
        TableBO temp = (TableBO) data.get(position);
        tableButton=(Button)vi.findViewById(R.id.Table_OrderButton);
        tableButton.setText(temp.getTableName());
        tableButton.setTag(position);
        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (Integer) v.getTag();
                TableBO table = data.get(index);
            }
        });

        return vi;
    }

}
