package com.giao.ordersystem;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
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
    private DishDAO dishDAO;
    public Menu_Event()
    {}
    public Menu_Event(Context context)
    {
        this.context=context;
        categoryDAO = new CategoryDAO(context);
        dishDAO=new DishDAO(context);
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
        categoryAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);
    }
    public void DishListView_OnLoad(ListView dishListView, String categoryName)
    {
        dishDAO.open();
        DishAdapter tableAdapter = new DishAdapter(context, dishDAO.list(categoryName));
        dishListView.setAdapter(tableAdapter);
        dishDAO.close();
        tableAdapter.notifyDataSetChanged();

    }
    public void addDishButton_Onclick()
    {
        Intent addDishIntent = new Intent("com.giao.ordersystem.AddDish");
        addDishIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(addDishIntent);
    }
    public void homButton_OnClick()
    {
        System.exit(1);
        finish();
    }
}
