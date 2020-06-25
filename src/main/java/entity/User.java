package entity;

public class User {

    private int id;
    private String login;
    private String password;
    public final static String USER_SEPARATOR = "#";

    public User (int id, String login, String password)
    {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String toString()
    {
        return id + USER_SEPARATOR + login + USER_SEPARATOR +password;
    }


}
