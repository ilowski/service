package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import products.Product;

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
    public ArrayList<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public int countAllProducts() {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByProductName(String productName) {
        for (Product product : productDao.getAllProducts()) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }



}