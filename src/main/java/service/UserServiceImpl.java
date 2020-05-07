package service;

import api.UserService;
import company.User;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {

    ArrayList<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
    }

    public UserServiceImpl(ArrayList<User> users)
    {
        this.users = users;
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUserById(int id) {

        for (int i =0; i<users.size(); i++)
        {
            User userFromList = users.get(i);
            if (userFromList.getId() == id)
            {
                users.remove(i);
                break;
            }
        }
    }
}
