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
        String []categoryArr={"Entrée","Soup","Noodle/Rice","Salad/Vegetarian","Chicken/Duck","Pork","Beef","Prawn","Seafood","Red wine","White Wine",
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
        String []categoryName1={"Soup","Soup","Soup","Soup","Soup","Soup","Soup","Soup","Soup","Soup","Soup"};
        String []dishName1={"Sweet and Sour Prawn Soup","Sweet and Sour Chicken Soup", "Sweet and Sour Tofu Soup","Chicken & Sweet Corn Soup","Crab & Asparagus Soup"
                ,"Rice Noodle Soup – Hu Tieu My Tho","Combination Steamboat ","Seafood Steamboat ", "Vegetarian Steamboat",
                "Flat rice noodle beef soup","Flat rice noodle chicken soup"};
        String []dishPrice1={"9.0","9.0","8.5","9.0","9.0","9.0","36.0","36.0","36.0","14.0","14.0"};
        String []dishDecription1={"A specialty of Southern Vietnam. Soured with tamarind, fresh tomato, and pineapple; lifted by a wetland herb (unique to Vietnamese food), and finished with okra for colour and texture",
        "A specialty of Southern Vietnam. Soured with tamarind, fresh tomato, and pineapple; lifted by a wetland herb (unique to Vietnamese food), and finished with okra for colour and texture",
        "A specialty of Southern Vietnam. Soured with tamarind, fresh tomato, and pineapple; lifted by a wetland herb (unique to Vietnamese food), and finished with okra for colour and texture",
        "Popular traditional soup with fresh crab and asparagus",
        "Succulent chunks of crab meat in a tasty asparagus soup",
        "From My Tho Province, this special rice noodle soup is topped with prawns, calamari, chicken and pork.",
        "One of the most popular dishes in Vietnamese dining. Cooked in a delicious broth at your table with fresh meats, seafood and vegetables. It is shared by four people as an entrée",
        "One of the most popular dishes in Vietnamese dining. Cooked in a delicious broth at your table with fresh seafood and vegetables. It is shared by four people as an entrée",
        "One of the most popular dishes in Vietnamese dining. Cooked in a delicious broth at your table with fresh tofu and vegetables. It is shared by four people as an entrée",
        "Traditional beef soup with bean sprout and basil",
        "Traditional chicken soup with bean sprout and basil"};
        String []categoryName2={"Noodle/Rice","Noodle/Rice","Noodle/Rice","Noodle/Rice","Noodle/Rice","Noodle/Rice","Noodle/Rice","Noodle/Rice"};
        String []dishName2={"Crispy Fried Egge Noodle","Soft Egg Noodle", "Rice Noodle","Fried Rice","Mimosa Rice","Garlic Rice (Small)","Garlic Rice (Large)","Steamed Rice"};
        String []dishPrice2={"22.5","22.5","22.5","13.5","10.0","6.5","9.0","2.5"};
        String []dishDecription2={"Crispy Fried Egg Noodles smothered with your choice of vegetables, meat and seafood, or vegetables and seafood, or vegetables only. Chilli optional.",
        "Soft Egg Noodles braised with your choice of vegetables, meat and seafood, or vegetables and seafood, or vegetables only. Chilli optional.",
        "Rice Noodles braised with your choice of vegetables, meat and seafood, or vegetables and seafood, or vegetables only. Chilli optional.",
        "With prawns, pork sausage, egg and peas",
        "Stir-fried rice with chicken, a touch of butter and pepper","",""};

        String []categoryName3={"Salad/Vegetarian","Salad/Vegetarian","Salad/Vegetarian","Salad/Vegetarian","Salad/Vegetarian","Salad/Vegetarian","Salad/Vegetarian","Salad/Vegetarian","Salad/Vegetarian","Salad/Vegetarian"};
        String []dishName3={"Duck Salad","Vegetarin Duck Salad","Beef Salad","Papaya Salad","Vegetarian Salad","Bonfire Totu",
                "Tofu sautéed in your choice of tasty sauce (optional chilli)","Salt and Pepper Tofu","Asian Broccoli","Asian Broccoli with Garlic Sauce"};
        String []dishPrice3={"12.0","12.0","15.0","13.80","13.5","26.0","17.9","18.5","12.6","13.5"};
        String []dishDescription3={"Harry’s signature duck salad. Twice cooked with aromatic spices; dressed with lime juice, kaffir lime and special Vietnamese ingredients, served with lightly pickle salad in lettuce leaves, accompanied by prawn crackers. ",
        "Harry’s signature duck salad, with tofu based substitute. Cooked with aromatic spices; dressed with lime juice, kaffir lime and special Vietnamese ingredients, served with lightly pickle salad in lettuce leaves, accompanied by prawn crackers. ",
        "Harry’s new succulent sous vide cooked beef, with green apple and pickle salad, prawn crackers and fish sauce. Serves up to 4 people. ",
        "Sliced prawns and pork, with lightly papaya salad, prawn crackers and fish sauce. Serves up to 4 ",
        "Delicious tofu with lightly pickled salad, herbs, and served with crushed peanuts and soy sauce. ",

        "Tofu, shitake mushroom and onion, cooked in a pot at the table and served with rice paper, lettuce, herbs, pickles and Harry’s hoisin sauce. ",
        "Tomato Sauce, Lemongrass Tofu, Curry Sauce,Sate Sauce ,Mixed Vegetables,Salt & Pepper Tofu",
        "Salt and pepper with lime sauce",
        "Stir-fried with Harry’s special sauce.",
                "Stir-fried with garlic sauce. "

        };


    }

}
