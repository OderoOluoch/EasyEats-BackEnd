import com.google.gson.Gson;
import dao.Sql2oMenuDao;
import dao.Sql2oShopDao;
import dao.Sql2oWaiterDao;
import exceptions.ApiException;
import model.Menu;
import model.Shop;
import model.Waiter;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        Sql2oMenuDao menuDao;
        Sql2oWaiterDao waiterDao;
        Sql2oShopDao ShopInterface;

        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/easyeats";
        Sql2o sql2o = new Sql2o(connectionString,  "moringa", "kidero");


        menuDao = new Sql2oMenuDao(sql2o);
        waiterDao = new Sql2oWaiterDao(sql2o);
        ShopInterface = new Sql2oShopDao(sql2o);
        conn = sql2o.open();

        //Home url
        get("/api/v1/", "application/json", (req, res) -> {
            String welcome = "Welcome to nextGen API ";
            res.status(201);
            return gson.toJson(welcome);
        });


        //Create a menu item
        post("/api/v1/menus/new", "application/json", (req, res) -> {
            Menu menu = gson.fromJson(req.body(), Menu.class);
            menuDao.add(menu);
            res.status(201);
            return gson.toJson(menu);
        });

        //Read all departments
        get("/api/v1/menus", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(menuDao.getAll());//send it back to be displayed
        });

        //Get department by Id
        get("/api/v1/menus/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentId = Integer.parseInt(req.params("id"));
            Menu menuToFind = menuDao.findById(departmentId);
            if (menuToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            else {
                return gson.toJson(menuToFind);
            }

        });






        //Create a waiter item
        post("/api/v1/waiters/new", "application/json", (req, res) -> {
            Waiter waiter = gson.fromJson(req.body(), Waiter.class);
            waiterDao.add(waiter);
            res.status(201);
            return gson.toJson(waiter);
        });

        //Read all departments
        get("/api/v1/waiters", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(waiterDao.getAll());//send it back to be displayed
        });

        //Get department by Id
        get("/api/v1/waiters/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentId = Integer.parseInt(req.params("id"));
            Menu menuToFind = waiterDao.findById(departmentId);
            if (menuToFind == null){
                throw new ApiException(404, String.format("No waiter with the id: \"%s\" exists", req.params("id")));
            }
            else {
                return gson.toJson(menuToFind);
            }

        });

        //Create a Shop
        post("/api/v1/shop/new", "application/json", (req, res)->{
            Shop shop = gson.fromJson(req.body(),Shop.class);
            ShopInterface.add(shop);
            res.status(201);
            return gson.toJson(shop);
        });

        //Read all shops
        get("/api/v1/shops", "application/json", (req,res)->{
            return  gson.toJson(ShopInterface.getAll());
        });

        //Read a single shop by id
        get("/api/v1/shops/:id", "application/json", (req,res)->{
          int id = Integer.parseInt(req.params("id"));
          Shop shop = ShopInterface.findById(id);
          if(shop == null){
              throw new ApiException(404, String.format("No Shop with the id: \"%s\" exists", req.params("id")));
          }else{
              return gson.toJson(shop);
          }
        });

    }
}
