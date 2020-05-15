package service;

import products.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UserServiceTest {

    @Test
    public void testGetAllUsers()
    {
        // is

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1,"Adam","Boniek"));
        users.add(new User(5,"Michal","michalek123"));

        // then

        UserServiceImpl userService = new UserServiceImpl(users);
        ArrayList<User> usersTest= userService.getUsers();

        // excepted
        Assert.assertEquals(users, usersTest);

    }

    @Test

    public void testAddUser()
    {
        //is
        ArrayList<User> users = new ArrayList<User>();
        User user = new User(5,"Tomek","admin");
        users.add(user);

        //then
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        ArrayList<User> usersTest = userService.getUsers();

        //excepted
        Assert.assertEquals(users,usersTest);
    }

    @Test
    public void testRemoveUser()
    {
        //is
        ArrayList<User> users = new ArrayList<User>();
        User user = new User(1,"admin","admin");
        users.add(user);

        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        userService.removeUserById(1);
        users.remove(user);
        ArrayList<User> userTest = userService.getUsers();

        //excepted
        Assert.assertEquals(users, userTest);


    }
}
