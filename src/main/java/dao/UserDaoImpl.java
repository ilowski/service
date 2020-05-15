package dao;

import api.UserDao;
import products.User;
import tools.Parser;

import java.io.*;
import java.util.ArrayList;


public class UserDaoImpl implements UserDao {
    File file;
    ArrayList<User> users;

    public UserDaoImpl(String fileName) {
        this.users = new ArrayList<User>();
        this.file = new File(fileName);
        this.file.createNewFile();

    }

    @Override
    public void saveUser(User user) {
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(ArrayList<User> User) {
        file.delete();
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        for (int i = 0; i < users.size(); i++) {
            printWriter.write(users.get(i).toString() + "\n");
        }
        printWriter.close();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String readLine = bufferedReader.readLine();

        while (readLine != null) {
            User user = Parser.convertToUser(readLine);
            if (User != null) {
                users.add(user);
            }
            readLine = bufferedReader.readLine();
        }
        return allUsers;

    }

    @Override
    public User getUserByLogin(String login) {
        this.users = getAllUsers();
        for (User user : this.users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null
    }

    @Override
    public User getUserById(int id) {
        this.users = getAllUsers();
        for (User user : this.users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUserByLogin(String login) {
        this.users = getAllUsers();
        for (int i=0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                users.remove(i);
                saveUsers(users);
            }
        }
    }

    @Override
    public void removeUserById(int id) {
        this.users = getAllUsers();
        for (int i=0; i < users.size(); i++) {
            if (users.get(i).getId() == id)
            {
                users.remove(i);
                saveUsers(users);

            }
        }

    }
}
