package api;

import company.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);
    void saveUsers(List<User> users);
    List<User> getAllUsers();
    User getUserByLogin(String login);
    User getUserById(int id);
    void removeUserByLogin(String login);
    void removeUserById(int id);


}
