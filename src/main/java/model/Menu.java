package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private int id;
    private String name;
    private String description;
    private int shop_id;
    private static List<Menu> instances = new ArrayList<>();
    private List<Cuisine> cuisines;

    public Menu(int id, String name, String description, int shop_id, List<Cuisine> cuisines) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.shop_id = shop_id;
        this.cuisines = cuisines;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Menu> getInstances() {
        return instances;
    }

    public static void setInstances(List<Menu> instances) {
        Menu.instances = instances;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id && Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
