package service;

import Exceptions.UserAlreadyExistException;
import Exceptions.UserShortLenghtLoginException;
import Exceptions.UserShortLengthPasswordException;
import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import products.User;
import tools.equalsUsers;
import validators.UserValidator;

import java.io.IOException;
import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private UserDao userDao = new UserDaoImpl("users.data");
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {

        if (instance == null) {
            instance = new UserServiceImpl();
        }

        return instance;
    }


    @Override
    public ArrayList<User> getUsers() throws IOException {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) throws UserShortLengthPasswordException, UserShortLenghtLoginException, UserAlreadyExistException {
        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
        }
    }

    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }

    public void equalsUsers(User userFirst, User userSecond) {
        if (equalsUsers.equals(userFirst, userSecond)) {
            System.out.println("Same");
        } else {
            System.out.println("differenta");
        }
    }
}
