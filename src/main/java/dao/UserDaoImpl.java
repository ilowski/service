package dao;

import api.UserDao;
import entity.User;
import tools.ProductParser;

import java.io.*;
import java.util.ArrayList;


public class UserDaoImpl implements UserDao {
    private final String fileName = "users.data";
    private File file;
    private ArrayList<User> users;
    private static UserDaoImpl instance = null;

    private UserDaoImpl()  {
        try {
            users = new ArrayList<User>();
            file = new File(fileName);
            file.createNewFile();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public void saveUser(User user) throws IOException {

        users.add(user);

        saveUsers(users);
    }

    @Override
    public void saveUsers(ArrayList<User> User) throws IOException {
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
    public ArrayList<User> getAllUsers() throws IOException {
        ArrayList<User> allUsers = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String readLine = bufferedReader.readLine();

        while (readLine != null) {
            User user = ProductParser.convertToUser(readLine);
            if (user != null) {
                allUsers.add(user);
            }
            readLine = bufferedReader.readLine();
        }
        return allUsers;

    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        this.users = getAllUsers();
        for (User user : this.users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(int id) throws IOException {
        this.users = getAllUsers();
        for (User user : this.users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        this.users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                users.remove(i);
                saveUsers(users);
            }
        }
    }

    @Override
    public void removeUserById(int id) throws IOException {
        this.users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                saveUsers(users);

            }
        }
    }


}
