package com.giao.ordersystem;

        import android.app.Activity;
        import android.content.Context;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Spinner;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Long on 2/8/2016.
 */
public class Menu_Event extends Activity {
    private Context context;
    private CategoryDAO categoryDAO;
    public Menu_Event()
    {}
    public Menu_Event(Context context)
    {
        this.context=context;
        categoryDAO = new CategoryDAO(context);
    }
    public void categoryListView_OnLoad(Spinner categorySpinner)
    {
        categoryDAO.open();
        ArrayList<String> categoryList = new ArrayList<String>();
        for(int i=0;i<categoryDAO.list().size();i++)
        {
            categoryList.add(categoryDAO.list().get(i).getCategoryName());
        }
        categoryDAO.close();
        ArrayAdapter<String> categoryAdapter =  new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,categoryList);
        categorySpinner.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }
    public void homButton_OnClick()
    {
        System.exit(1);
        finish();
    }
}
