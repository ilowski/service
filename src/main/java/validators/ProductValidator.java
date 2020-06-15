package validators;

import Exceptions.ProductCountNegativeException;
import Exceptions.ProductNameEmptyException;
import Exceptions.ProductPriceNoPositiveException;
import Exceptions.ProductWeightNoPositiveException;
import products.Product;

public class ProductValidator {
    private static ProductValidator instance = null;

    private ProductValidator() {

    }

    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product) throws ProductCountNegativeException, ProductNameEmptyException, ProductPriceNoPositiveException, ProductWeightNoPositiveException {
        if (isCountNegative(product.getProductCount())) {
            throw new ProductCountNegativeException(product.getProductCount() + " that is less than 0 product count");
        }

        if (isNameEmpty(product.getProductName())) {
            throw new ProductNameEmptyException("Product name is empty!");
        }

        if(isPriceNotPositive(product.getPrice())) {
            throw new ProductPriceNoPositiveException("Price is less than 0.01!");
        }

        if (isWeightNoPositive(product.getWeight())) {
            throw new ProductWeightNoPositiveException("Weight is less than 0.01!");
        }

    }

    public boolean isWeightNoPositive(float weight) {
    return weight <= 0.00f;
    }

    public boolean isCountNegative(int productCount) {
        return productCount < 0;
    }

    public boolean isNameEmpty(String productName) {
        return productName.length() == 0;
    }

    public boolean isPriceNotPositive(float price) {
        return price <= 0.00f;
    }

}