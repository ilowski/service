package products;

public class Product {
    public final static char PRODUCT_TYPE ='P';
    private int id;
    private String productName;
    private float price;
    private float  weight;
    private String color;
    private int productCount;
    public final static String PRODUCT_SEPARATOR = "#";

    public Product(int id, String productName, float price, float weight, String color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public int getProductCount()
    {
        return productCount;
    }
    public String getColor()
    {
        return color;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }

    public  float getWeight() {
        return weight;
    }

    public void setPrice(float price)
    {
        this.price=price;
    }

    public void setProductCount (int productCount)
    {
        this.productCount=productCount;
    }

    public String getBasicProductToString() {
        return  id + PRODUCT_SEPARATOR + productName + PRODUCT_SEPARATOR + price + PRODUCT_SEPARATOR + weight + PRODUCT_SEPARATOR + color + PRODUCT_SEPARATOR + productCount;
    }

    public String toString() {
        return PRODUCT_TYPE + PRODUCT_SEPARATOR + getBasicProductToString();
    }
}
