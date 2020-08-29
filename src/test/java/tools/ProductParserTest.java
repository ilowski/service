package tools;

import entity.Product;
import enums.Color;
import org.junit.Assert;
import org.junit.Test;

public class ProductParserTest {
    public static boolean equalsTwoProducts(Product a, Product b) {
        return a.toString().equals(b.toString());
    }
    @Test
    public void ProductParsertoProduct() {
        //is
        Color red = Color.RED;
        Product product = new Product(1,"kox",50.0f,40.0f,red,5);


        //then
        String productStr = product.toString();
        Product result = ProductParser.convertToProduct(productStr);

        //excepted

        Assert.assertTrue(equalsTwoProducts(result,product));
    }
}
