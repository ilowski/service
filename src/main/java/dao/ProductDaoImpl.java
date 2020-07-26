package dao;

import api.ProductDao;
import entity.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {

    private String productType;
    private static ProductDaoImpl instance = null;
    private final String databaseName = "management";
    private final String tableName = "products";
    private final String user = "root";
    private final String password = "test123";
    private Connection connection;


    public static ProductDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    private ProductDaoImpl()  {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?userSSL=false", user, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    public void saveProduct(Product product)  {

    }


   

    @Override
    public void removeProductById(int productId) {




    }

    @Override
    public void removeProductByName(String productName) {


    }

    @Override
    public ArrayList<Product> getAllProducts()  {

    }

    @Override
    public Product getProductById(int productId) {

    }

    @Override
    public Product getProductByProductName(String productName) {

}
