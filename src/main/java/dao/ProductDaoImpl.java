package dao;

import api.ProductDao;
import products.Product;
import tools.Parser;

import java.io.*;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {
    private File file;
    private ArrayList<Product> products;
    private int numberOfProducts = 0;
    private String productType;

    public ProductDaoImpl(String fileName, String productType) throws IOException {
        this.file = new File(fileName);
        this.file.createNewFile();
        this.productType = productType;
        products = new ArrayList<>();
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        products.add(product);
        numberOfProducts++;
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
        }
        printWriter.close();
        numberOfProducts = products.size();
    }

    @Override
    public void removeProductById(int productId) throws IOException {
        products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            int currentProductId = products.get(i).getId();
            if (currentProductId == productId) {
                products.remove(i);
                numberOfProducts--;
                saveProducts(products);
            }
        }

    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        products = getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equals(productName)) {
                products.remove(i);
                numberOfProducts--;

            }
        }


    }

    @Override
    public ArrayList<Product> getAllProducts() throws IOException {
        ArrayList<Product> allProducts = new ArrayList<Product>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            Product product = Parser.stringToProduct(readLine, productType);
            if (product != null) {
                allProducts.add(product);
            }
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return allProducts;
    }

    @Override
    public Product getProductById(int productId) throws IOException {
        products = getAllProducts();
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        products = getAllProducts();
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
