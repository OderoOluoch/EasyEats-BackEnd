package Models;

import Dao.ShopInterface;

public class Shop implements ShopInterface {
    private String name;
    private int id;

    public Shop(String name, int id){
        this.name= name;
        this.id = id;
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

    @Override
    public void add(Shop shop) {

    }

    @Override
    public Shop findById(int id) {
        return null;
    }

    @Override
    public void update(int id, String name) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllTasks() {

    }
}
