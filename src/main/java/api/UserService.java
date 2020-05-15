package api;

import products.User;

import java.util.ArrayList;

public interface UserService {


    ArrayList<User> getUsers();
    void addUser(User user);
    void removeUserById(int id);



}
