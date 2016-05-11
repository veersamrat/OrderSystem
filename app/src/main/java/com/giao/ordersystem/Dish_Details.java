package com.giao.ordersystem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Long on 5/11/2016.
 */
public class Dish_Details extends Activity {

    private Button addDishButtonOK;
    private Button homeButton;
    private Spinner categorySpinner;
    private EditText dishNameEditText;
    private EditText priceEditText;
    private EditText desciptionEditText;
    private EditText availabilityEditText;
    private String dishID;
    private Dish_Details_Event event;
    private DishDAO dishDAO;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_details);
        //Declare controls
        //Declare new Controls
        categorySpinner=(Spinner)findViewById(R.id.categorySpinner);
        dishNameEditText=(EditText)findViewById(R.id.dishNameEditText);
        priceEditText=(EditText)findViewById(R.id.priceEditText);
        desciptionEditText=(EditText)findViewById(R.id.descriptionEditText);
        availabilityEditText=(EditText)findViewById(R.id.availabilityEditText);
        //get categoryName
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            dishID = extras.getString("dishID");
        }
        //Load categorySpinner
        event.categorySpinner_OnLoad(categorySpinner);

        //Load selected dish information
        DishBO dishBO= dishDAO.itemDish(dishID);
        categorySpinner.setSelection();


    }
}
