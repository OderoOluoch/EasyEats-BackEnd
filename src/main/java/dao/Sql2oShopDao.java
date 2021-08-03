package dao;

import model.Shop;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oShopDao implements ShopInterface{
    private Sql2o sql2o;

    public Sql2oShopDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void save() {

    }

    @Override
    public void add(Shop shop) {
        String sql = "INSERT INTO shops(name, id) VALUES(:name, :id)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(shop)
                    .executeUpdate().getKey();
            shop.setId(id);
        }
    }

    @Override
    public List<Shop> getAll() {
        String sql = "SELECT * FROM shops";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Shop.class);
        }
    }

    @Override
    public Shop findById(int id) {
        String sql = "SELECT * FROM shops WHERE id= :id";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Shop.class);
        }
    }

    @Override
    public void update(int id, String name) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllTasks() {

    }
}
