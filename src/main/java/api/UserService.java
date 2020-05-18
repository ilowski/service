package api;

import products.User;

import java.io.IOException;
import java.util.ArrayList;

public interface UserService {


    ArrayList<User> getUsers() throws IOException;
    void addUser(User user);
    void removeUserById(int id);



}
