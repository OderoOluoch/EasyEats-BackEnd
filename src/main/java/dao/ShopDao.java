package dao;

import model.Menu;
import model.Shop;
import model.Waiter;

import java.util.List;

public interface ShopDao {
    //CREATE
    void add(Shop shop);

    //READ
    List<Shop> getAll();
    List<Menu>getAllMenusForAShop(int id);

    Shop findById(int id);

    //UPDATE
    void update(Shop shop,int id, String name, String tagline, String image);

    //DELETE
    void deleteById(int id);
    void clearAllShops();

    List<Waiter> getAllWaitersForAShop(int shop_id);
}
