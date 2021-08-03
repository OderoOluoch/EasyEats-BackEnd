package Dao;

import Models.Shop;

public interface ShopInterface {
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
