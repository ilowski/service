package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import products.Product;

import java.io.IOException;
import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance = null;
    private ProductDao productDao = new ProductDaoImpl("products.data", "PRODUCT");

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }


    @Override
    public ArrayList<Product> getAllProducts() throws IOException  {
        return productDao.getAllProducts();
    }

    @Override
    public int countAllProducts() throws IOException {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        for (Product product : productDao.getAllProducts()) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductExistByProductId(int id) {
        return false;
    }

    @Override
    public boolean isProductAvaiableByProductName(String productName) {
        return false;
    }

    @Override
    public boolean isProductExistByProductName(String productName) {
        return false;
    }
}