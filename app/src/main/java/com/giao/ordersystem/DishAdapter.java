package com.giao.ordersystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Long on 5/5/2016.
 */
public class DishAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DishBO> data;
    private static LayoutInflater inflater = null;
    private TextView mText;
    private Button mButton;
    private Button mButton2;
    public DishAdapter(Context context, ArrayList<DishBO> data) {
        // TODO Auto-generated constructor stub
        View focusTarget = null;
        this.context = context;
        this.data = new ArrayList<DishBO>(data);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public DishBO getItem(int position) {
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
        View vi = convertView;
        if (vi == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.dish_layout, null, true);
        }
        DishBO temp = (DishBO) data.get(position);
        mText = (TextView) vi.findViewById(R.id.EditDishEditText);
        mButton = (Button) vi.findViewById(R.id.DetailDishButton);
        mButton2 = (Button) vi.findViewById(R.id.DeleteDishButton);
        mText.setText(temp.getDishName());
        mButton.setTag(position);
        mButton2.setTag(temp.getDishID());
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (Integer) v.getTag();
                DishBO dish = data.get(index);
                data.remove(dish);
                notifyDataSetChanged();
            }
        });
        return vi;
    }
}
