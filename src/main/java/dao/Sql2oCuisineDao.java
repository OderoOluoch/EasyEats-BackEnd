package dao;

import model.Cuisine;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCuisineDao  implements CuisineDao{
    private Sql2o sql2o;

    public Sql2oCuisineDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Cuisine cuisine) {
        String sql = "INSERT INTO cuisines (foodType,image, price, menu_id) VALUES(:foodType, :image, :price , :menu_id)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(cuisine)
                    .executeUpdate()
                    .getKey();
            cuisine.setId(id);
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


    @Override
    public List<Cuisine> getAllCuisinesForAMenu(int menu_id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM cuisines WHERE menu_id = :menu_id")
                    .addParameter("restaurantId", menu_id)
                    .executeAndFetch(Cuisine.class);
        }
    }

    @Override
    public List<Cuisine> getAll() {
        String sql = "SELECT * FROM cuisines";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Cuisine.class);
        }
    }

    @Override
    public Cuisine findById(int id) {
        String sql = "SELECT * FROM cuisines WHERE id = :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Cuisine.class);
        }
    }

    @Override
    public void update(Cuisine cuisine, int id, String FoodType, int price, int menu_id) {
        String sql = "UPDATE cuisines SETS(foodType, price, menu_id)= (:foodType, :price, :menu_id) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("foodType", FoodType)
                    .addParameter("price", price)
                    .addParameter("menuId", menu_id)
                    .executeUpdate();
            cuisine.setFoodType(FoodType);
            cuisine.setPrice(price);
            cuisine.setMenu_id(menu_id);
        }
    }

    @Override
    public void deleteById( int id) {
        String sql = "DELETE FROM cuisine WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id", id)
                    .executeUpdate();
        }catch(Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllTasks() {
        String sql = "DELETE * FROM cuisines";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
