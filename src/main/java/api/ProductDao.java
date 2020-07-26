package api;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductDao {
    void saveProduct (Product product);
    void saveProducts (ArrayList<Product>products);
    void removeProductById(int productId);
    void removeProductByName(String productName);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    Product getProductByProductName(String productName);

}
