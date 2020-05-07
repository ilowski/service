package service;

import api.ProductService;
import company.Product;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
    ArrayList<Product> products;
    public ProductServiceImpl(ArrayList<Product> products) {
        this.products = products;
    }

    public ProductServiceImpl() {
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return products;
    }

    @Override
    public int countAllProducts() {
       return products.size();
    }

    @Override
    public Product getProductByProductName(String productName) {
        for (Product product : products)
        {
            if (product.getProductName().equals(productName))
            {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductAvaiableByProductName(String productName) {
        Product product = getProductByProductName(productName);
        if (product != null && product.getProductCount() > 0) {
            return true;
        }
        return false;

    }
        @Override
        public boolean isProductExistByProductName (String productName){
            for (Product product : products) {
                if (product.getProductName().equals(productName)) {
                    return true;
                }

            }
            return false;
        }

    @Override
    public boolean isProductExistByProductId(int id) {
        for (Product product : products)
        {
            if (product.getId() == id)
            {
                return true;
            }
        }
        return false;
    }

}