package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import exceptions.UserAlreadyExistException;
import exceptions.UserShortLenghtLoginException;
import exceptions.UserShortLengthPasswordException;
import service.UserServiceImpl;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {
    private static UserRegisterLoginFacade instance = null;
    private UserService userService = UserServiceImpl.getInstance();

    private UserRegisterLoginFacadeImpl() {

    }

    public static UserRegisterLoginFacade getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    @Override
    public String registerUser(User user)  {
        try {
            userService.addUser(user);
            return "User is added! Success!";
        }
        catch (UserAlreadyExistException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        catch (UserShortLenghtLoginException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public boolean loginUser(String login, String password) {

       return userService.isCorrectLoginAndPassword(login,password);


    }
}
