package api;

import products.Product;

import java.io.IOException;
import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getAllProducts() throws IOException;
    int countAllProducts() throws IOException;
    Product getProductByProductName(String productName) throws IOException;
    boolean isProductAvaiableByProductName(String productName);
    boolean isProductExistByProductName(String productName);
    boolean isProductExistByProductId(int id);
}
