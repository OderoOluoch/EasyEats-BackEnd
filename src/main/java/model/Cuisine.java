package model;

import java.util.ArrayList;
import java.util.List;

public class Cuisine {
    private int id;
    private String FoodType;
    private int price;
    private int MenuId;
    private static List<Cuisine> instances = new ArrayList<Cuisine>();



    public Cuisine(int id, String FoodType, int price, int MenuId){
        this.id = id;
        this.FoodType = FoodType;
        this.price = price;
        this.MenuId = MenuId;
        instances.add(this);
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
        return FoodType;
    }

    public void setFoodType(String foodType) {
        FoodType = foodType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMenuId() {
        return MenuId;
    }

    public void setMenuId(int menuId) {
        MenuId = menuId;
    }
}
