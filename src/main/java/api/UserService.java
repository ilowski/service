package api;

import entity.User;
import exceptions.UserAlreadyExistException;
import exceptions.UserShortLenghtLoginException;
import exceptions.UserShortLengthPasswordException;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    boolean addUser(User user) throws UserShortLengthPasswordException, UserShortLenghtLoginException, UserAlreadyExistException;
    void removeUserById(int id );
    User getUserById(int id);
    User getUserByLogin(String login);
    boolean isCorrectLoginAndPassword(String login, String password);


}
