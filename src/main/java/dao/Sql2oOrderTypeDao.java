package dao;

import model.OrderType;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oOrderTypeDao implements OrderTypeDao{

    private final Sql2o sql2o;
    public Sql2oOrderTypeDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(OrderType orderType) {
        String sql = "INSERT INTO order_type (name) VALUES (:name)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(orderType)
                    .executeUpdate()
                    .getKey();
            orderType.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }



    @Override
    public List<OrderType> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM order_type")
                    .executeAndFetch(OrderType.class);
        }
    }


    @Override
    public OrderType findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM order_type WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(OrderType.class);
        }
    }

    @Override
    public void deleteById(int id) {
//        String sql = "DELETE from menu WHERE id = :id";
//        String deleteJoin = "DELETE from news_depatments WHERE newsid = :newsid";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("id", id)
//                    .executeUpdate();
//            con.createQuery(deleteJoin)
//                    .addParameter("newsid", id)
//                    .executeUpdate();
//
//        } catch (Sql2oException ex){
//            System.out.println(ex);
//        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE from order_type";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
