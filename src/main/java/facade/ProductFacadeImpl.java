package facade;

import api.ProductFacade;
import api.ProductService;
import entity.Product;
import exceptions.ProductCountNegativeException;
import exceptions.ProductNameEmptyException;
import exceptions.ProductPriceNoPositiveException;
import exceptions.ProductWeightNoPositiveException;
import service.ProductServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {

    public static ProductFacadeImpl instance = null;
    private ProductService productService = ProductServiceImpl.getInstance();

    private ProductFacadeImpl() {

    }

    public static ProductFacadeImpl getInstance() {
        if (instance == null) {
            instance = new ProductFacadeImpl();
        }
        return instance;
    }

    @Override
    public String createProduct(Product product) {
        try {
            if (productService.saveProduct(product)) {
                return "success!";
            }

        } catch (ProductCountNegativeException e) {
            e.printStackTrace();
            e.getMessage();
        } catch (ProductNameEmptyException e) {
            e.printStackTrace();
            e.getMessage();
        } catch (ProductPriceNoPositiveException e) {
            e.printStackTrace();
            e.getMessage();
        } catch (ProductWeightNoPositiveException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return "fail!";
    }

    @Override
    public String removeProduct(String name) {
        return "created";
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new LinkedList<>();
        return products;
    }


}
