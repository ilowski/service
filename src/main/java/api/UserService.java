package api;

import entity.User;

import java.io.IOException;
import java.util.ArrayList;

public interface UserService {


    ArrayList<User> getUsers() throws IOException;
    boolean addUser(User user);
    void removeUserById(int id )throws IOException;
    User getUserById(int id) throws IOException;
    User getUserByLogin(String login) throws IOException;
    boolean isCorrectLoginAndPassword(String login, String password);


}
