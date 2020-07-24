package api;

import entity.User;
import exceptions.UserAlreadyExistException;
import exceptions.UserShortLenghtLoginException;
import exceptions.UserShortLengthPasswordException;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getUsers() throws IOException;
    boolean addUser(User user) throws UserShortLengthPasswordException, UserShortLenghtLoginException, UserAlreadyExistException;
    void removeUserById(int id )throws IOException;
    User getUserById(int id) throws IOException;
    User getUserByLogin(String login) throws IOException;
    boolean isCorrectLoginAndPassword(String login, String password);


}
