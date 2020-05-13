package dao;

import api.UserDao;
import company.User;

import java.io.File;
import java.util.ArrayList;



public class UserDaoImpl implements UserDao {
    File file;
    ArrayList<User> users;

    public UserDaoImpl(String fileName) {
        this.users = new ArrayList<User>();
        File file = new File(fileName);
        file.createNewFile();
    }

    @Override
    public void saveUser(User user) {
    }

    @Override
    public void saveUsers(User user) {

    }

    @Override
    public ArrayList<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void removeUserByLogin(String login) {

    }

    @Override
    public void removeUserById(int id) {

    }
}
