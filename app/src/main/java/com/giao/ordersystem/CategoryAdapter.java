package com.giao.ordersystem;

/**
 * Created by Long on 2/12/2016.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter{
    //  private Context context;
    private ArrayList<CategoryBO> data;
    private static LayoutInflater inflater = null;

    public CategoryAdapter(Context context, ArrayList<CategoryBO> data) {
        // TODO Auto-generated constructor stub
        //     this.context = context;
        this.data= new ArrayList<CategoryBO>(data);
        //  this.this.data=data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public CategoryBO getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.listview_layout2,null);
        EditText categoryEditText=(EditText)vi.findViewById(R.id.EditCategoryEditText);
        //      Button tableButton=(Button)vi.findViewById(R.id.DeleteTableButton);
        CategoryBO temp=(CategoryBO)data.get(position);
        categoryEditText.setText(temp.getCategoryName());
        //tableButton.set
        return vi;
        //return null;
    }

}
