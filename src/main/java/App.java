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
        Sql2oCuisineDao cuisineDao;

        Connection conn;
        Gson gson = new Gson();

       String connectionString = "jdbc:postgresql://localhost:5432/easyeats";
        Sql2o sql2o = new Sql2o(connectionString,  "moringa", "kidero");

 //       String connectionString = "jdbc:postgresql://ec2-54-205-232-84.compute-1.amazonaws.com:5432/dal28rppnvpc7q"; //!
  //      Sql2o sql2o = new Sql2o(connectionString, "jmlvmwjddfacno", "c7eec8209a29c3902cdb894f876bd162a12ee1d5a64635800202dd4920728f3d"); //!


        menuDao = new Sql2oMenuDao(sql2o);
        waiterDao = new Sql2oWaiterDao(sql2o);
        shopDao = new Sql2oShopDao(sql2o);
        tableDao = new Sql2oNextGenTableDao(sql2o);
        orderTypeDao = new Sql2oOrderTypeDao(sql2o);
        cuisineDao = new Sql2oCuisineDao(sql2o);


        conn = sql2o.open();

        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

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

        //Read all menu Items
        get("/api/v1/menus", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(menuDao.getAll());//send it back to be displayed
        });

        //Get menu by Id
        get("/api/v1/menus/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int menuId = Integer.parseInt(req.params("id"));
            Menu menuToFind = menuDao.findById(menuId);
            if (menuToFind == null){
                throw new ApiException(404, String.format("No menu with the id: \"%s\" exists", req.params("id")));
            }
            else {
                return gson.toJson(menuToFind);
            }

        });

//        get("/api/v1/menus/:id/cuisines", "application/json", (req, res) -> {
//            int menuId = Integer.parseInt(req.params("id"));
//            Menu menuToFind = menuDao.findById(menuId);
//            if (menuToFind == null){
//                throw new ApiException(404, String.format("No menu item with the id: \"%s\" exists", req.params("id")));
//            }
//            else if (menuDao.getAllMenusForAShop(menuId).size()==0){
//                return "{\"message\":\"I'm sorry, but no foodtypes are listed for this restaurant.\"}";
//            }
//            else {
//                return gson.toJson(menuDao.getAllMenusForAShop(menuId));
//            }
//        });






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
        post("/api/v1/shops/new", "application/json", (req, res)->{
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


        get("/api/v1/shops/:id/menus", "application/json", (req,res)->{
            int shopId = Integer.parseInt(req.params("id"));
            Shop shop = shopDao.findById(shopId);

            if (shop == null){
                throw new ApiException(404, String.format("No shop or outlet item with the id: \"%s\" exists", req.params("id")));
            }
            else if (shopDao.getAllMenusForAShop(shopId).size()==0){
                return "{\"message\":\"I'm sorry, but no foodtypes are listed for this restaurant.\"}";
            }
            else {
                return gson.toJson(shopDao.getAllMenusForAShop(shopId));
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




        //Create a cuisine item
        post("/api/v1/cuisines/new", "application/json", (req, res) -> {
            Cuisine cuisine = gson.fromJson(req.body(), Cuisine.class);
            cuisineDao.add(cuisine);
            res.status(201);
            return gson.toJson(cuisine);
        });

        //Read all departments
        get("/api/v1/cuisines", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(cuisineDao.getAll());//send it back to be displayed
        });

        //Get department by Id
        get("/api/v1/cuisines/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int cuisineId = Integer.parseInt(req.params("id"));
            Cuisine cusineToFind = cuisineDao.findById(cuisineId);
            if (cusineToFind == null){
                throw new ApiException(404, String.format("No cuisineId with the id: \"%s\" exists", req.params("id")));
            }
            else {
                return gson.toJson(cuisineDao);
            }

        });


    }
}
