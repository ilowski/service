package api;

import entity.Product;
import exceptions.ProductCountNegativeException;
import exceptions.ProductNameEmptyException;
import exceptions.ProductPriceNoPositiveException;
import exceptions.ProductWeightNoPositiveException;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    int countAllProducts();
    Product getProductByProductName(String productName);
    boolean isProductAvaiableByProductName(String productName);
    boolean isProductExistByProductName(String productName);
    boolean isProductExistByProductId(int id);
    boolean saveProduct(Product product) throws ProductWeightNoPositiveException, ProductPriceNoPositiveException, ProductNameEmptyException, ProductCountNegativeException;

}
