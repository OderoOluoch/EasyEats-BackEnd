package dao;

import model.OrderType;

import java.util.List;

public interface OrderTypeDao {

    //CREATE
    void add(OrderType orderType);

    //READ
    List<OrderType> getAll();
    OrderType findById(int id);

    //UPDATE
//    void update(OrderType orderType,int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAll();
}
