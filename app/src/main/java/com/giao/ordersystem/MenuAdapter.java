package com.giao.ordersystem;

/**
 * Created by Long on 2/12/2016.
 */
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<DishBO> data;
    private static LayoutInflater inflater = null;
    private TextView mText;
    private Button mButton;
    public MenuAdapter(Context context, ArrayList<DishBO> data) {
        // TODO Auto-generated constructor stub

        View focusTarget = null;
        this.context = context;
        this.data= new ArrayList<DishBO>(data);

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
        // TODO Auto-generated method stub
        View vi;
        vi=convertView;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.listview_layout2, null, true);
        }
        mText=(TextView) vi.findViewById(R.id.EditCategoryEditText);
        mButton = (Button) vi.findViewById(R.id.DeleteCategoryButton);
        DishBO temp = (DishBO) data.get(position);
        mText.setText(temp.getDishName());
        mButton.setTag(temp);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (Integer) v.getTag();
                DishBO dish = data.get(index);
                data.remove(dish);
                notifyDataSetChanged();

            }});
        return vi;
    }

}
