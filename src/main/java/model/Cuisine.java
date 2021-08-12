package model;

import java.util.ArrayList;
import java.util.List;

public class Cuisine {
    private int id;
    private String foodType;
    private int price;
    private int menuId;
    private static List<Cuisine> instances = new ArrayList<Cuisine>();



    public Cuisine(int id, String FoodType, int price, int MenuId){
        this.id = id;
        this.foodType = FoodType;
        this.price = price;
        this.menuId = MenuId;
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

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        menuId = menuId;
    }
}
