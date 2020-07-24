package api;

import entity.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);



    List<User> getAllUsers();

    User getUserByLogin(String login);

    User getUserById(int id);

    void removeUserByLogin(String login);

    void removeUserById(int id);


}
