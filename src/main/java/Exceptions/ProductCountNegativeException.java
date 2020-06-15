package Exceptions;

public class ProductCountNegativeException extends Exception {

    public ProductCountNegativeException() {
        super();
    }

    public ProductCountNegativeException(String message) {
        super(message);
    }
}
