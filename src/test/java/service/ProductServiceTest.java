package service;

import products.Boots;
import products.Cloth;
import products.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ProductServiceTest {

    @Test
    public void testGetAllProductsPositive() {
        // is
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Boots(1, "Boots special", 25.00f, 25.5f, "black", 5, 35, true));
        products.add(new Cloth(1, "t-shirt", 50.00f, 24.5f, "black", 4, "40L", "wool"));
        // then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        ArrayList<Product> produtsTest = productService.getAllProducts();
        // excepted
        Assert.assertEquals(products, produtsTest);
    }

    @Test
    public void tesGetAllProductsNegative() {
        // is
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Boots(1, "Boots special", 25.00f, 25.5f, "black", 5, 35, true));
        products.add(new Cloth(2, "t-shirt", 50.00f, 24.5f, "black", 4, "40L", "wool"));
        // then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(3, "t-shirt", 50.00f, 24.5f, "black", 4, "40L", "wool"));
        ArrayList<Product> productsTest = productService.getAllProducts();
        // excepted
        Assert.assertNotEquals(products, productsTest);

    }

    @Test
    public void testCountAllProdcutsPositive() {
        //is
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Boots(1, "Boots special", 25.00f, 25.5f, "black", 5, 35, true));
        products.add(new Cloth(2, "t-shirt", 50.00f, 24.5f, "black", 4, "40L", "wool"));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        int result = productService.countAllProducts();

        //excepted
        Assert.assertEquals(2, result);

    }

    @Test
    public void testCountAllProductsZero() {
        //is
        ArrayList<Product> products = new ArrayList<Product>();

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        int result = productService.countAllProducts();

        //excepted
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByProductNameWhenExist() {
        //is
        ArrayList<Product> products = new ArrayList<Product>();
        Cloth cloth = new Cloth(2, "t-shirt", 50.00f, 24.5f, "black", 4, "40L", "wool");

        products.add(new Boots(1, "Boots special", 25.00f, 25.5f, "black", 5, 35, true));
        products.add(cloth);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product product = productService.getProductByProductName("t-shirt");


        //excepted
        Assert.assertEquals(cloth, product);
    }

    @Test
    public void testGetProductByProductNameWhenNoExist() {
        //is
        ArrayList<Product> products = new ArrayList<Product>();
        Cloth cloth = new Cloth(2, "t-shirt", 50.00f, 24.5f, "black", 4, "40L", "wool");
        products.add(cloth);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product product = productService.getProductByProductName("T=shirtoLirto");

        //excepted
        Assert.assertEquals(null, product);

    }

    @Test
    public void testIsProductAvaiableByProductNameWhenIs() {
        //is
        ArrayList<Product> products = new ArrayList<Product>();
        Cloth cloth = new Cloth(2, "t-shirt", 50.00f, 24.5f, "black", 4, "40L", "wool");
        products.add(cloth);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isProductAvaiableByProductName("t-shirt");

        //excepted
        Assert.assertTrue(result);

    }

    @Test
    public void testIsProductAvaiableByProductNameWhenIsNot() {
        //is
        ArrayList<Product> products = new ArrayList<Product>();
        Cloth cloth = new Cloth(2, "t-shirt", 50.00f, 24.5f, "black", 4, "40L", "wool");
        products.add(cloth);

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isProductAvaiableByProductName("t=fasa");

        //excepted
        Assert.assertFalse(result);

    }


    @Test
    public void testProductExistByProductNamePositive()
    {
        // is
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Cloth(5,"t-shirt",25.5f,33.2f,"blue",5,"40L","wool"));

        // then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isProductExistByProductName("t-shirt");

        // excepted
        Assert.assertTrue(result);
    }

    @Test
    public void testProductExistByProductNameNegative()
    {
        // is
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Cloth(5,"t-shirt",25.5f,33.2f,"blue",5,"40L","wool"));

        // then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isProductExistByProductName("bamboo");

        // excepted
        Assert.assertFalse(result);
    }

    @Test
    public void testIsProductExistByProductIdPositive()
    {
        // is
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Cloth(5,"t-shirt",25.5f,33.2f,"blue",5,"40L","wool"));

        // then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isProductExistByProductId(5);

        // excepted
        Assert.assertTrue(result);
    }

    @Test
    public void testIsProductExistByProductIdNegative()
    {
        // is
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Cloth(5,"t-shirt",25.5f,33.2f,"blue",5,"40L","wool"));

        // then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        boolean result = productService.isProductExistByProductId(3);

        // excepted
        Assert.assertFalse(result);
    }


}