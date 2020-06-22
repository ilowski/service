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
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
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
    public void addUser(User user) throws IOException, UserShortLengthPasswordException, UserShortLenghtLoginException, UserAlreadyExistException {
        if (isUserAlreadyExists(user.getLogin())) {
            throw new UserAlreadyExistException("Change login!");
        }

        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
        }
    }

    @Override
    public void removeUserById(int id) throws IOException {
        userDao.removeUserById(id);
    }

    public boolean isUserAlreadyExists(String login) {
        User user = getUserByLogin(login);
        return user != null;
    }

    public User getUserByLogin(String login) {
        ArrayList<User> users = getUsers();

        for (User user : users) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;


    }

    public void equalsUsers(User userFirst, User userSecond) {
        if (equalsUsers.equals(userFirst, userSecond)) {
            System.out.println("Same");
        } else {
            System.out.println("differenta");
        }
    }
}
