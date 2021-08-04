package dao;

import model.NextGenTable;

import java.util.List;

public interface NextGenTableDao {
    //CREATE
    void add(NextGenTable table);

    //READ
    List<NextGenTable> getAll();
    NextGenTable findById(int id);

    //UPDATE
//    void update(NextGenTable table,int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAll();
}
