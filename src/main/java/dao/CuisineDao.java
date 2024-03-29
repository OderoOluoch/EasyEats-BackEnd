package dao;

import model.Cuisine;

import java.util.List;

public interface CuisineDao {
    //CREATE
    void add(Cuisine cuisine);

    //READ
    List<Cuisine> getAll();
    List <Cuisine> getAllCuisinesForAMenu(int id);
//    List<Cuisine> getAllCuisinesByMenuItem(int menuId);
    Cuisine findById(int id);

    //UPDATE
    void update(Cuisine cuisine,int id, String food,int price, int MenuId);

    //DELETE
    void deleteById(int id);
    void clearAllTasks();
}
