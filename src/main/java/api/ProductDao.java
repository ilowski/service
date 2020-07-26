package api;

import entity.Product;

import java.util.List;

public interface ProductDao {
    void saveProduct (Product product);
    void removeProductById(int productId);
    void removeProductByName(String productName);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    Product getProductByProductName(String productName);

}
