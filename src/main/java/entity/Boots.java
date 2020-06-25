package entity;

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
        return PRODUCT_TYPE + PRODUCT_SEPARATOR + super.getBasicProductToString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + isNaturalSkin;
    }
}
