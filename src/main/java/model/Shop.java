package model;

import java.util.ArrayList;

public class Shop {
    private String name;
    private int id;
    private static ArrayList<Shop> instances = new ArrayList<>();

    public Shop(String name, int id){
        this.name= name;
        this.id = id;
        instances.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static ArrayList<Shop> getAllInstances(){
        return instances;
    }
    public static void clearAllShop(){
        instances.clear();
    }
}
