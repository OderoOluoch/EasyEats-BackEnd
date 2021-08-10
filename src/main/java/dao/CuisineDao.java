package dao;

import model.Cuisine;

import java.util.List;

public interface CuisineDao {
    //CREATE
    void add(Cuisine cuisine);

    //READ
    List<Cuisine> getAll();
    List <Cuisine> getAllCuisinesForAMenu(int id);
    Cuisine findById(int id);

    //UPDATE
    void update(Cuisine cuisine,int id, String FoodType,int price, int MenuId);

    //DELETE
    void deleteById(int id);
    void clearAllTasks();
}
