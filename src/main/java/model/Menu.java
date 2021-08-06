package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private int id;
    private String name;
    private static List<Menu> instances = new ArrayList<>();
    private List<Cuisine> cuisines;

    public Menu(int id, String name) {
        this.id = id;
        this.name = name;
        instances.add(this);
        cuisines = new ArrayList<Cuisine>();
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

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }
}
