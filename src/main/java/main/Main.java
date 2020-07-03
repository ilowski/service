package main;

import api.ProductService;
import api.UserRegisterLoginFacade;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;
import enums.Color;
import enums.Material;
import facade.UserRegisterLoginFacadeImpl;
import service.ProductServiceImpl;
import tools.ColorParser;
import tools.MaterialParser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static ProductService productService = ProductServiceImpl.getInstance();
    static Scanner scan = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Log in");
        System.out.println("2 - Register");
        System.out.println("0 - Exit");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Add new product");
        System.out.println("0 - Log out");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Add boots");
        System.out.println("2 - Add cloth");
        System.out.println("3 - Add other product");
        System.out.println("0 - exit");
    }

    public static Product createBootsProduct() {
        System.out.println("What product name?");
        String productName = scan.next();
        System.out.println("What price is?");
        float price = scan.nextFloat();
        System.out.println("What weight is?");
        float weight = scan.nextFloat();
        System.out.println("what is color? RED/GREEN/BLUE");
        String colorStr = scan.next();
        Color color = ColorParser.parseStringToColor(scan.next());
        System.out.println("what count?");
        int count = scan.nextInt();
        System.out.println("what size?");
        int size = scan.nextInt();
        System.out.println("Is natural skin?");
        boolean isNaturalSkin = scan.nextBoolean();

        return new Boots(1, productName, price, weight, color, count, size, isNaturalSkin);
    }


    public static Product createClothProduct() {
        System.out.println("ProductName: ");
        String productName = scan.next();
        System.out.println("Price: ");
        float price = scan.nextFloat();
        System.out.println("Weight: ");
        float weight = scan.nextFloat();
        System.out.println("Color: ");
        Color color = ColorParser.parseStringToColor(scan.next());
        System.out.println("Count: ");
        int count = scan.nextInt();
        System.out.println("Size: ");
        String size = scan.next();
        System.out.println("Material: ");
        String materialStr = scan.next();
        Material material = MaterialParser.parseStringToMaterial(materialStr);

        return new Cloth(1, productName, price, weight, color, count, size, material);

    }

    public static Product createOtherProduct() {
        System.out.println("Product name: ");
        String productName = scan.next();
        System.out.println("Price: ");
        float price = scan.nextFloat();
        System.out.println("Weight: ");
        float weight = scan.nextFloat();
        System.out.println("Color: ");
        Color color = ColorParser.parseStringToColor(scan.next());
        System.out.println("Count: ");
        int count = scan.nextInt();

        return new Product(1, productName, price, weight, color, count);
    }

    public static void main(String[] args) throws IOException {

        boolean appOn = true;
        boolean loggedOn = false;
        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();

        while (appOn) {
            startMenu();
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    String loginLog = scan.next();
                    String passwordLog = scan.next();
                    if (userFacade.loginUser(loginLog, passwordLog)) {
                        loggedOn = true;
                        System.out.println("logged");
                    } else {

                        System.out.println("wrong credits");
                    }
                    break;
                case 2:
                    String loginRegister = scan.next();
                    String passwordRegister = scan.next();
                    User user2 = new User(999, loginRegister, passwordRegister);
                    if (userFacade.registerUser(user2)) {
                        System.out.println("sukces");
                    } else {
                        System.out.println("error");
                    }
                    break;
                case 0:
                    appOn = false;
            }

            while (loggedOn) {
                loggedMenu();
                choice = scan.nextInt();

                switch (choice) {
                    case 0:
                        loggedOn = false;
                        break;
                    case 1:
                        Product product = null;
                        productTypeMenu();
                        choice = scan.nextInt();
                        switch (choice) {
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;
                            case 3:
                                product = createOtherProduct();
                                break;
                        }
                        if (productService.saveProduct(product)) {
                            System.out.println("done!");
                        } else {
                            System.out.println("fail!");
                        }
                }


            }

        }


    }
}
