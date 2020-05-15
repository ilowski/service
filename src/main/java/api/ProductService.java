package api;

import products.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getAllProducts();
    int countAllProducts();
    Product getProductByProductName(String productName);
    boolean isProductAvaiableByProductName(String productName);
    boolean isProductExistByProductName(String productName);
    boolean isProductExistByProductId(int id);
}
