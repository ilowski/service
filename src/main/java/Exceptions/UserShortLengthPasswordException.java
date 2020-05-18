package Exceptions;

public class UserShortLengthPasswordException extends Exception {
    public UserShortLengthPasswordException() {
        super();
    }

    public UserShortLengthPasswordException(String message) {
        super(message);
    }

}
