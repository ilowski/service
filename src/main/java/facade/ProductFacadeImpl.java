package facade;

import api.ProductFacade;
import api.ProductService;
import entity.Product;
import entity.User;
import service.ProductServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class ProductFacadeImpl {

    public static ProductFacade instance = null;
    private ProductService productService = ProductServiceImpl.getInstance();

    private ProductFacadeImpl() {

    }

    public static ProductFacadeImpl getInstance() {
        if (instance == null) {
            instance = new ProductFacadeImpl();
        }
        return instance;
    }

    public String createProduct (Product product) {

    }

    public String removeProduct(String name) {

    }

    public List<User> getAllProducts() {
        List<User> users = new LinkedList<User>();
        return users;
    }
}
