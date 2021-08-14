package model;

import java.util.ArrayList;

public class Shop {
    private String name;
    private String tagline;
    private String image;
    private int id;
    private static ArrayList<Shop> instances = new ArrayList<>();

    public Shop(String name, String tagline, String image, int id) {
        this.name = name;
        this.tagline = tagline;
        this.image = image;
        this.id = id;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static ArrayList<Shop> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Shop> instances) {
        Shop.instances = instances;
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
