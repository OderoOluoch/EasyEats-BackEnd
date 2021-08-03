package dao;

import model.Shop;

public interface ShopInterface {
    void save();
    //CREATE
    void add(Shop shop);

    //READ
    Shop findById(int id);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllTasks();
}
