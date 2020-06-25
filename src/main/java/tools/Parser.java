package tools;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;
import enums.ProductSeparator;

public class Parser {

    public static User convertToUser(String userStr) {
        String userInformations[] = userStr.split(User.USER_SEPARATOR);
        Integer id = Integer.parseInt(userInformations[0]);
        String login = userInformations[1];
        String password = userInformations[2];
        return new User(id, login, password);
    }

    public static String productToString(Product product) {
        return null;
    }

    public static Product stringToProduct(String productStr) {
        final char productType = productStr.charAt(0);

        switch (productType) {
            case Product.PRODUCT_TYPE:
                return convertToProduct(productStr);

            case Cloth.PRODUCT_TYPE:
                return convertToCloth(productStr);

            case Boots.PRODUCT_TYPE:
                return convertToBoots(productStr);
        }
        return null;
    }

    public static Product convertToProduct(String productStr) {
        String[] productInformations = productStr.split(ProductSeparator.PRODUCT_SEPARATOR.getSign());
        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);
        return new Product(id, productName, price, weight, color, productCount);
    }

    public static Cloth convertToCloth(String productStr) {

        String[] productInformations = productStr.split(ProductSeparator.PRODUCT_SEPARATOR.getSign());
        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        String material = productInformations[8];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);

    }

    public static Boots convertToBoots(String productStr) {
        String[] productInformations = productStr.split(ProductSeparator.PRODUCT_SEPARATOR.getSign());
        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        Float price = Float.parseFloat(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);
        Integer size = Integer.parseInt(productInformations[7]);
        Boolean isNaturalSkin = Boolean.parseBoolean(productInformations[8]);
        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);

    }
}
