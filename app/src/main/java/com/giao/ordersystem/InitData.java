package com.giao.ordersystem;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Long on 5/26/2016.
 */
public class InitData extends Activity{
    Context context;
    public InitData(Context context)
    {
        this.context=context;
    }
    public void InitData()
    {
        TableDAO tableDAO= new TableDAO(context);
        CategoryDAO categoryDAO= new CategoryDAO(context);
        DishDAO dishDAO= new DishDAO(context);
        //Insert default Table
        String []tableArr= {"Table 1","Table 2","Table 3","Table 4","Table 5","Table 6","Table 7","Table 8",
                "Table 9","Table 10","Table 11","Table 12","Table 13","Table 14","Table 15","Table 16","Table 17",
                "Table 18","Table 19","Table 20","Table 21","Table 22","Table 23","Table 24","Table 25"};
        for(int i=0;i<25;i++)
        {
            tableDAO.open();
            tableDAO.create(tableArr[i]);
            tableDAO.close();
        }
        //Insert default Category
        String []categoryArr={"Entrée","Soup","Noodle/Rice","Vegetable/Salad","Chicken","Pork","Beef","Prawn","Seafood","Red wine","White Wine",
                "Beer/Soft Drink","Spirit/Cocktails","Coffee/Dessert","Banquet","Special Request"};
        for(int i =0;i<14;i++)
        {
            categoryDAO.open();
            categoryDAO.create(categoryArr[i]);
            categoryDAO.close();
        }
        String []categoryName={"Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée","Entrée"};
        String []dishName={"Crispy Pancake","Vegetarian Crispy Pancake","Spring Rolls",
                "Vegan Spring Rolls","Fresh Prawn Roll","Vegetarian Fresh Roll",
                "Little Rice Cakes","Stuffed Mussels","Stuffed mushroom" ,
                "Grilled Pork Balls Entreé",
                "Grilled Pork Skewerd Entrée","Grilled Beef Roll Entreé","Tender Beef Cubes",
                "Stuffed Chicken Wing Entreé", "Duck cumquat and ginger sauce",
                "Crispy Quail", "Soft Shell Crab"};
        String []dishPrice={"14.5","13.0","9.6","9.0","9.6","9.0","13.5","14.5","14","14.5","14.5","14.5","14.5","17.5","18","11.5","11.5"};
        String []dishDecription={
                "Authentic specialty pancake filled with prawns, pork, bean sprouts and served with salad, pickles and fish sauce. The light and crispy pancake makes this a repeat favourite",
                "Authentic specialty pancake filled with vegetables and bean sprouts and served with salad, pickles and fish sauce. The light and crispy pancake makes this a repeat favourite",
                "Acclaimed, unique Bay Tinh creation, containing quality meat freshly minced, a special mix of black fungus and ingredients, encased in light, crispy pastry.",
                "Acclaimed, unique Bay Tinh creation, containing quality mixed vegetables, black fungus and ingredients, encased in light, crispy pastry.",
                "Lectuce, mint, pork and prawn wrapped between rice paper.",
                "Vegetables, tofu and basil wrapped between rice paper",
                "This traditional Southern dish is rarely served in Australia. It required a skilful technique to create the velvety texture and creamy taste. ",
                "Large mussels stuffed with prawns in oyster sauce, or sweet & sour sauce with chilli.",
                "Steamed dried Shiitake mushrooms stuffed with prawn paste, served with Asian cabbage and oyster sauce.",
                "Chef’s specialty. Marinated pork balls wrapped in lettuce with special rice noodle cakes, pickles, mint and Bay Tinh’s special sauce.",
                "Marinated pork belly wrapped in lettuce with special rice noodle cakes, pickles, mint and Bay Tinh’s special sauce",
                "Fish cake stick wrapped by beef skewed with sliced onion.",
                "Selected yearling beef, marinated with the Chef’s special recipe and flash seared in high flame to seal in the flavour and juices; served with classic pepper, salt and lemon juice.",
                "De-boned wing, stuffed with quality minced pork, black fungus and vermicelli. Twice cooked to a golden brown, with plum sauce and sesame seeds.",
                "Harry’s new luscious sous vide cooked duck with tangy Asian cumquat and ginger sauce to complement and contrast the richness of the duck. ",
                "Marinated in herbs and spices, twice cooked to golden brown, served on shredded salad with classic salt, pepper and lemon juice.",
                "Delicately seasoned, in a very light crispy batter, served with classic lemon, salt and pepper dipping sauce."};
        for(int i=0;i<16;i++)
        {
            dishDAO.open();
            dishDAO.create(categoryName[i],dishName[i],dishPrice[i],dishDecription[i],"0");
            dishDAO.close();
        }
        String []categoryName1={"Soup","Soup","Soup","Soup","Soup","Soup","Soup","Soup"};
        String []dishName1={"Sweet & Sour Prawn Soup","Sweet & Sour Chicken Soup", "Chicken & Sweet Corn Soup","Crab & Asparagus Soup"
                ,"Rice Noodle Soup – Hu Tieu My Tho","Combination Steamboat ","Seafood Steamboat ", "Vegetarian Steamboat"};
        String []dishPrice1={"9.0","9.0","9.0","9.0","9.0","36.0","36.0","36.0"};
        String []dishDecription1={"A specialty of Southern Vietnam. Soured with tamarind, fresh tomato, and pineapple; lifted by a wetland herb (unique to Vietnamese food), and finished with okra for colour and texture",
        "A specialty of Southern Vietnam. Soured with tamarind, fresh tomato, and pineapple; lifted by a wetland herb (unique to Vietnamese food), and finished with okra for colour and texture",
        "Popular traditional soup",
        "Succulent chunks of crab meat in a tasty asparagus soup",
        "From My Tho Province, this special rice noodle soup is topped with prawns, calamari, chicken and pork.",
        "One of the most popular dishes in Vietnamese dining. Cooked in a delicious broth at your table with fresh meats, seafood and vegetables. It is shared by four people as an entrée",
        "One of the most popular dishes in Vietnamese dining. Cooked in a delicious broth at your table with fresh seafood and vegetables. It is shared by four people as an entrée",
        "One of the most popular dishes in Vietnamese dining. Cooked in a delicious broth at your table with fresh tofu and vegetables. It is shared by four people as an entrée"};
        String []categoryName2={};
        String []dishName2={};
        String []dishPrice2={};
        String []dishDecription2={};
    }

}
