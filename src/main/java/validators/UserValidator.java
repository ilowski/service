package validators;

import Exceptions.UserAlreadyExistException;
import Exceptions.UserShortLenghtLoginException;
import Exceptions.UserShortLengthPasswordException;
import dao.UserDaoImpl;
import products.User;

public class UserValidator {
    private static UserValidator instance = null;
    private static UserDaoImpl userDao = new UserDaoImpl();
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

        if (checkUserIsAlreadyExist(user.getLogin())) {
            throw new UserAlreadyExistException(user.getLogin() + " this user is already exist! Try again");
        }
    }

    public boolean checkUserLoginLength(String login) {
        return login.length() < MIN_LENGTH_LOGIN);
    }

    public boolean checkUserPasswordLength(String password) {
        return password.length() < MIN_LENGTH_PASSWORD;
    }

    public boolean checkUserIsAlreadyExist(String login) {
        return userDao.getUserByLogin(login).equals(null);
    }
}
