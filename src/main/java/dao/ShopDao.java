package dao;

import model.Shop;

import java.util.List;

public interface ShopDao {
    //CREATE
    void add(Shop shop);

    //READ
    List<Shop> getAll();
    Shop findById(int id);

    //UPDATE
    void update(Shop shop,int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllShops();
}
