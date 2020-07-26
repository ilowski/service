package dao;

import api.ProductDao;
import entity.Product;
import enums.Color;
import tools.ColorParser;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static ProductDaoImpl instance = null;
    private final String databaseName = "management";
    private final String tableName = "products";
    private final String user = "root";
    private final String password = "test123";
    private String productType;
    private Connection connection;


    private ProductDaoImpl() {
        init();
    }

    public static ProductDaoImpl getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?userSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void saveProduct(Product product) {
        PreparedStatement preparedStatement = null;

        try {
            String query = "INSERT INTO " + tableName + " (productName, price, weight, color, productCount VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setFloat(3, product.getWeight());
            preparedStatement.setString(4, product.getColor().getColor());
            preparedStatement.setInt(5, product.getProductCount());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void removeProductById(int productId) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "DELETE FROM " + tableName + " WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeProductByName(String productName) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "DELETE FROM " + tableName + " WHERE productName=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productName);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new LinkedList<Product>();
        Statement statement = null;
        try {
            String query = "SELECT * FROM " + tableName;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("productName");
                Float price = resultSet.getFloat("price");
                Float weight = resultSet.getFloat("weight");
                String colorStr = resultSet.getString("color");
                Color color = ColorParser.parseStringToColor(colorStr);
                int productCount = resultSet.getInt("productCount");
                Product product = new Product(id, productName, price, weight, color, productCount);
                products.add(product);
            }
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        Statement statement = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE id='" + productId + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("productName");
                Float price = resultSet.getFloat("price");
                Float weight = resultSet.getFloat("weight");
                String colorStr = resultSet.getString("color");
                Color color = ColorParser.parseStringToColor(colorStr);
                int productCount = resultSet.getInt("productCount");
                Product product = new Product(id, productName, price, weight, color, productCount);
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) {
        Statement statement = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE productName='" + productName + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productNameResult = resultSet.getString("productName");
                Float price = resultSet.getFloat("price");
                Float weight = resultSet.getFloat("weight");
                String colorStr = resultSet.getString("color");
                Color color = ColorParser.parseStringToColor(colorStr);
                int productCount = resultSet.getInt("productCount");
                Product product = new Product(id, productNameResult, price, weight, color, productCount);
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
