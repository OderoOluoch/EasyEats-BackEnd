package model;

import java.util.ArrayList;
import java.util.List;

public class Cuisine {
    private int id;
    private String foodType;
    private String image;
    private int price;
    private int menu_id;
    private static List<Cuisine> instances = new ArrayList<Cuisine>();

    public Cuisine(int id, String foodType, String image, int price, int menu_id) {
        this.id = id;
        this.foodType = foodType;
        this.image = image;
        this.price = price;
        this.menu_id = menu_id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static List<Cuisine> getInstances() {
        return instances;
    }

    public static void setInstances(List<Cuisine> instances) {
        Cuisine.instances = instances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        foodType = foodType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }
}
