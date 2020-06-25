package api;

import entity.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface ProductDao {
    void saveProduct (Product product) throws IOException;
    void saveProducts (ArrayList<Product>products) throws IOException;
    void removeProductById(int productId) throws IOException;
    void removeProductByName(String productName) throws IOException;
    ArrayList<Product> getAllProducts() throws IOException;
    Product getProductById(int productId) throws IOException;
    Product getProductByProductName(String productName) throws IOException;

}
