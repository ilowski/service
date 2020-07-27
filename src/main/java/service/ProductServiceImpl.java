package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import exceptions.ProductCountNegativeException;
import exceptions.ProductNameEmptyException;
import exceptions.ProductPriceNoPositiveException;
import exceptions.ProductWeightNoPositiveException;
import validators.ProductValidator;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance = null;
    private ProductDao productDao = ProductDaoImpl.getInstance();
    private ProductValidator productValidator = ProductValidator.getInstance();

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }


    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public int countAllProducts() {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByProductName(String productName) {
        Product product = productDao.getProductByProductName(productName);
        return product;
    }

    @Override
    public boolean isProductExistByProductId(int id) {
        Product product = productDao.getProductById(id);
        if (product == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isProductAvaiableByProductName(String productName) {

        Product product = productDao.getProductByProductName(productName);
        if (product == null) {
            return false;
        }

        return product.getProductCount() > 0;
    }


    @Override
    public boolean isProductExistByProductName(String productName) {
        Product product = productDao.getProductByProductName(productName);
        if (product == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean saveProduct(Product product) throws ProductCountNegativeException, ProductNameEmptyException, ProductPriceNoPositiveException, ProductWeightNoPositiveException {
        if (productValidator.isValidate(product)) {
            productDao.saveProduct(product);
            return true;
        }
        return false;
    }
}