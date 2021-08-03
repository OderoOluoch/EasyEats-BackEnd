package dao;

import model.NextGenTable;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNextGenTableDao implements NextGenTableDao{

    private final Sql2o sql2o;

    public Sql2oNextGenTableDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(NextGenTable table) {
        String sql = "INSERT INTO menu (name) VALUES (:name)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(table)
                    .executeUpdate()
                    .getKey();
            table.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }



    @Override
    public List<NextGenTable> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM menu")
                    .executeAndFetch(NextGenTable.class);
        }
    }


    @Override
    public NextGenTable findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM menu WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(NextGenTable.class);
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
        String sql = "DELETE from menu";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

}
