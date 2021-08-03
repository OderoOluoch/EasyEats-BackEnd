package dao;

import model.Menu;
import model.Waiter;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oWaiterDao implements WaiterDao{

    private final Sql2o sql2o;
    public Sql2oWaiterDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(Waiter waiter) {
        String sql = "INSERT INTO waiter (name) VALUES (:name)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(waiter)
                    .executeUpdate()
                    .getKey();
            waiter.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }



    @Override
    public List<Waiter> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM waiter")
                    .executeAndFetch(Waiter.class);
        }
    }


    @Override
    public Menu findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM waiter WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Menu.class);
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
        String sql = "DELETE from waiter";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
