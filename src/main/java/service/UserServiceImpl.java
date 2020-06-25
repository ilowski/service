package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exceptions.UserAlreadyExistException;
import tools.equalsUsers;
import validators.UserValidator;

import java.io.IOException;
import java.util.ArrayList;

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
    public boolean addUser(User user) {
        try {

            if (isUserAlreadyExists(user.getLogin())) {
                throw new UserAlreadyExistException("Change login!");
            }

            if (userValidator.isValidate(user)) {

                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void removeUserById(int id) throws IOException {
        userDao.removeUserById(id);
    }

    public boolean isUserAlreadyExists(String login) throws IOException {
        User user = getUserByLogin(login);
        return user != null;
    }

    public User getUserByLogin(String login) {

try {

    ArrayList<User> users = getUsers();
    System.out.println(users.size());
    for (User user : users) {

        if (user.getLogin().equals(login)) {

            return user;
        }
    }
}
catch (Exception e) {
    System.out.println(e.getMessage());
}
        return null;


    }

    @Override
    public User getUserById(int id) throws IOException {
        ArrayList<User> users = getUsers();
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password) {
        User userFound = getUserByLogin(login);

        if (userFound == null) {

            return false;
        }
        return userFound.getPassword().equals(password);
    }

    public void equalsUsers(User userFirst, User userSecond) {
        if (equalsUsers.equals(userFirst, userSecond)) {
            System.out.println("Same");
        } else {
            System.out.println("different");
        }
    }
}
