package dao;

import model.Cuisine;
import model.Menu;

import java.util.List;

public interface MenuDao {

    //create
    void add(Menu menu);

    //Retrieve menu by ID
    Menu findById(int id);

    List<Cuisine>getAllCuisinesInAMenu(int id);

    //retrieve all menu items in the DB
    List<Menu> getAll();

    //update

    //delete
    void deleteById(int id);

    void clearAll();
}
