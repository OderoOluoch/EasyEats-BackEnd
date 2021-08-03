package dao;

import model.Menu;

import java.util.List;

public interface MenuDao {

    //create
    void add(Menu menu);

    //Retrieve menu by ID
    Menu findById(int id);



    //retrieve all menu items in the DB
    List<Menu> getAll();


    //update


    //delete
    void deleteById(int id);
    void clearAll();
}
