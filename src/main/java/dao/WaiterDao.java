package dao;

import model.Menu;
import model.Waiter;

import java.util.List;

public interface WaiterDao {

    //create
    void add(Waiter waiter);

    //Retrieve menu by ID
    Menu findById(int id);

    List<Waiter> getAllWaitersByShop(int id);


    //retrieve all menu items in the DB
    List<Waiter> getAll();


    //update


    //delete
    void deleteById(int id);
    void clearAll();
}
