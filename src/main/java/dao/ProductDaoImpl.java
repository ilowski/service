package dao;

import api.ProductDao;
import company.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {
    private File file;
    private ArrayList<Product> products;
    private int numberOfProducts = 0;

    public ProductDaoImpl(String fileName) throws IOException {
        this.file = new File(fileName);
        this.file.createNewFile();
        products = new ArrayList<>();
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        products.add(product);
        saveProducts(products);
    }


    @Override
    public void saveProducts(ArrayList<Product> products) throws IOException {
        file.delete();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for (int i = 0; i < products.size(); i++) {
            printWriter.write(products.get(i).toString() + "\n");
            printWriter.close();
        }
        numberOfProducts = products.size();
    }

    @Override
    public void removeProductById(int productId) throws IOException {
        for (int i = 0; i < products.size();i++) {
            int currentProductId = products.get(i).getId();
            if ( currentProductId == productId) {
                products.remove(i);
                numberOfProducts--;
                saveProducts(products);
            }
        }

    }

    @Override
    public void removeProductByName(String productName) throws IOException {

        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                products.remove(product);
                numberOfProducts--;

            }
        }


    }

    @Override
    public ArrayList<Product> getAllproducts() throws IOException {
        ArrayList<Product> allProducts = new ArrayList<Product>();

    }

    @Override
    public Product getProductById(int productId) throws IOException {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {

        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
