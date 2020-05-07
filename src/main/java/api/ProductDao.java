package api;

import company.Product;

import java.util.ArrayList;

public interface ProductDao {
    void saveProduct (Product product);
    void saveProducts (ArrayList<Product> products);
    void removeProductById(int productId);
    void removeProductByName(String productName);
    ArrayList<Product> getAllproducts();
    Product getProductById(int productId);
    Product getProductByProductName(String productName);

}
