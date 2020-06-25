package entity;

import enums.ProductSeparator;

public class Cloth extends Product {
    private String size;
    private String material;
    public final static char PRODUCT_TYPE = 'C';


    public Cloth(int id, String productName, float price, float weight, String color, int productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize()
    {
        return size;
    }
    public String getMaterial()
    {
        return material;
    }

    public String toString()
    {
        return ProductSeparator.PRODUCT_TYPE_CLOTH.getSign() + ProductSeparator.PRODUCT_SEPARATOR.getSign() + super.getBasicProductToString() + ProductSeparator.PRODUCT_SEPARATOR.getSign() + size + ProductSeparator.PRODUCT_SEPARATOR.getSign() + material;

    }

}
