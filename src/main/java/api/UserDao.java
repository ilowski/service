package api;

import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {

    void saveUser(User user) throws IOException;



    List<User> getAllUsers() throws IOException;

    User getUserByLogin(String login) throws IOException;

    User getUserById(int id) throws IOException;

    void removeUserByLogin(String login) throws IOException;

    void removeUserById(int id) throws IOException;


}
