package validators;

import entity.User;
import exceptions.UserAlreadyExistException;
import exceptions.UserShortLenghtLoginException;
import exceptions.UserShortLengthPasswordException;

public class UserValidator {
    private static UserValidator instance = null;
    private final int MIN_LENGTH_LOGIN = 5;
    private final int MIN_LENGTH_PASSWORD = 4;


    private UserValidator() {
    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserAlreadyExistException, UserShortLenghtLoginException, UserShortLengthPasswordException {
        if (checkUserLoginLength(user.getLogin())) {
            throw new UserShortLenghtLoginException(user.getLogin() + " is too short!");
        }

        if (checkUserPasswordLength(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short! OMG!");
        }


        return true;
    }

    public boolean checkUserLoginLength(String login) {
        return login.length() < MIN_LENGTH_LOGIN;
    }

    public boolean checkUserPasswordLength(String password) {
        return password.length() < MIN_LENGTH_PASSWORD;
    }


}
