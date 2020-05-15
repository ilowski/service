package main;

import dao.ProductDaoImpl;
import products.Cloth;
import products.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {


        ProductDaoImpl productsDao = new ProductDaoImpl(new File("products.txt"));
        Cloth cloth = new Cloth(5,"tshirtlol",25.5f,2.5f,"RED",55,"50L","wool");
        productsDao.saveProduct(cloth);
       productsDao.removeProductById(5);
       ArrayList<Product> products = productsDao.getAllproducts();

       for (Product product : products)
       {
           System.out.println(product.getProductName());
       }

    }
}
