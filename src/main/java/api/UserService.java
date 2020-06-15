package api;

import Exceptions.UserAlreadyExistException;
import Exceptions.UserShortLenghtLoginException;
import Exceptions.UserShortLengthPasswordException;
import products.User;

import java.io.IOException;
import java.util.ArrayList;

public interface UserService {


    ArrayList<User> getUsers() throws IOException;
    void addUser(User user) throws IOException, UserShortLengthPasswordException, UserShortLenghtLoginException, UserAlreadyExistException;
    void removeUserById(int id )throws IOException;



}
