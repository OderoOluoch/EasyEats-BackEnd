import com.google.gson.Gson;
import dao.Sql2oMenuDao;
import exceptions.ApiException;
import model.Menu;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        Sql2oMenuDao menuDao;

        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/easyeats";
        Sql2o sql2o = new Sql2o(connectionString,  "moringa", "kidero");


        menuDao = new Sql2oMenuDao(sql2o);
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

    }
}
