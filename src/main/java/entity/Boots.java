package entity;

import enums.ProductSeparators;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;
    public final static char PRODUCT_TYPE = 'B';

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    public Boots(int id, String productName, float price, float weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;

    }

    public String toString()
    {
        return ProductSeparators.PRODUCT_TYPE_BOOTS.getSign() + ProductSeparators.PRODUCT_SEPARATOR.getSign() + super.getBasicProductToString() + ProductSeparators.PRODUCT_SEPARATOR.getSign() + size + ProductSeparators.PRODUCT_SEPARATOR.getSign() + isNaturalSkin;
    }
}
