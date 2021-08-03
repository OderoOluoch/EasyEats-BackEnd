package Models;

import Dao.ShopInterface;
import org.sql2o.Connection;

public class Shop implements ShopInterface {
    private String name;
    private int id;

    public Shop(String name, int id){
        this.name= name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO shops (name) VALUES (:name);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public void add(Shop shop) {
        String sql = "INSERT INTO shops(name, id) VALUES(:name, :id)";
        try(Connection con = DB.sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .addParameter("id", this.id)
                    .bind(shop)
                    .executeUpdate()
                    .getKey();
            shop.setId(id);
        }catch(sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public Shop findById(int id) {
        return null;
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
