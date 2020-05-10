package dao;

import api.ProductDao;
import company.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao
{
    File file;
    ArrayList<Product> products;
    int numberOfProducts = 0;

    public ProductDaoImpl(File file) throws IOException {
        this.file = file;
        products = new ArrayList<Product>();
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        products.add(product);
        saveProducts(products);
        }



    @Override
    public void saveProducts(ArrayList<Product> products) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for (int i=numberOfProducts; i <= products.size(); i++)
        {
            printWriter.write(products.get(i).toString() + "\n");
            printWriter.close();
        }
        numberOfProducts = products.size();
    }

    @Override
    public void removeProductById(int productId) throws IOException {
        for (Product product : products)
        {
            if (product.getId() == productId)
            {
                products.remove(product);
                break;
            }
        }
    }

    @Override
    public void removeProductByName(String productName) throws IOException {

        for (Product product : products)
        {
            if (product.getProductName().equals(productName))
            {
                products.remove(product);
                break;
            }
        }

    }

    @Override
    public ArrayList<Product> getAllproducts() throws IOException {
        return products;
    }

    @Override
    public Product getProductById(int productId) throws IOException {
        for (Product product : products)
        {
            if(product.getId() == productId)
            {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {

        for (Product product : products)
        {
            if (product.getProductName().equals(productName))
            {
                return product;
            }
        }
        return null;
    }
}
