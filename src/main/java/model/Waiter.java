package model;

import java.util.Objects;

public class Waiter {
    private int id;
    private String name;
    private int shop_id;

    public Waiter(int id, String name, int shop_id) {
        this.id = id;
        this.name = name;
        this.shop_id = shop_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
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
        Waiter waiter = (Waiter) o;
        return id == waiter.id && Objects.equals(name, waiter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
