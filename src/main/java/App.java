import com.google.gson.Gson;
import dao.*;
import exceptions.ApiException;
import model.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        Sql2oMenuDao menuDao;
        Sql2oWaiterDao waiterDao;
        Sql2oShopDao shopDao;
        Sql2oNextGenTableDao tableDao;
        Sql2oOrderTypeDao orderTypeDao;

        Connection conn;
        Gson gson = new Gson();

//        String connectionString = "jdbc:postgresql://localhost:5432/easyeats";
//        Sql2o sql2o = new Sql2o(connectionString,  "moringa", "kidero");

        String connectionString = "jdbc:postgresql://ec2-54-211-160-34.compute-1.amazonaws.com:5432/d6uji9646strn2"; //!
        Sql2o sql2o = new Sql2o(connectionString, "oxpycedyoxgsyz", "499f26ca77bdb24a0198a064d62f41248eb91b6788a504b1bab8279948c8dc9e"); //!


        menuDao = new Sql2oMenuDao(sql2o);
        waiterDao = new Sql2oWaiterDao(sql2o);
        shopDao = new Sql2oShopDao(sql2o);
        tableDao = new Sql2oNextGenTableDao(sql2o);
        orderTypeDao = new Sql2oOrderTypeDao(sql2o);


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
            shopDao.add(shop);
            res.status(201);
            return gson.toJson(shop);
        });

        //Read all shops
        get("/api/v1/shops", "application/json", (req,res)->{
            return  gson.toJson(shopDao.getAll());
        });

        //Read a single shop by id
        get("/api/v1/shops/:id", "application/json", (req,res)->{
          int id = Integer.parseInt(req.params("id"));
          Shop shop = shopDao.findById(id);
          if(shop == null){
              throw new ApiException(404, String.format("No Shop with the id: \"%s\" exists", req.params("id")));
          }else{
              return gson.toJson(shop);
          }
        });


        //Create a table
        post("/api/v1/tables/new", "application/json", (req, res)->{
            NextGenTable table = gson.fromJson(req.body(),NextGenTable.class);
            tableDao.add(table);
            res.status(201);
            return gson.toJson(table);
        });

        //Read all shops
        get("/api/v1/tables", "application/json", (req,res)->{
            return  gson.toJson(tableDao.getAll());
        });

        //Read a single shop by id
        get("/api/v1/tables/:id", "application/json", (req,res)->{
            int id = Integer.parseInt(req.params("id"));
            NextGenTable table = tableDao.findById(id);
            if(table == null){
                throw new ApiException(404, String.format("No table with the id: \"%s\" exists", req.params("id")));
            }else{
                return gson.toJson(table);
            }
        });


        //Create an Order Type
        post("/api/v1/order_types/new", "application/json", (req, res)->{
            OrderType orderType = gson.fromJson(req.body(),OrderType.class);
            orderTypeDao.add(orderType);
            res.status(201);
            return gson.toJson(orderType);
        });

        //Read all shops
        get("/api/v1/order_types", "application/json", (req,res)->{
            return  gson.toJson(orderTypeDao.getAll());
        });

        //Read a single shop by id
        get("/api/v1/order_types/:id", "application/json", (req,res)->{
            int id = Integer.parseInt(req.params("id"));
            OrderType orderType = orderTypeDao.findById(id);
            if(orderType == null){
                throw new ApiException(404, String.format("No table with the id: \"%s\" exists", req.params("id")));
            }else{
                return gson.toJson(orderType);
            }
        });

    }
}
