package tools;

import entity.User;

import java.util.Objects;

public class equalsUsers {

    public static boolean equals(Object o, Object x)
    {
        if (o == x) {
            return true;
        }

        if (o == null || x == null || x.getClass() != o.getClass())
        {
            return false;
        }

        User userO = (User) o;
        User userX = (User) x;

        return Objects.equals(userX.getId(),userO.getId()) &&
                Objects.equals(userX.getLogin(),userO.getLogin()) &&
                Objects.equals(userX.getPassword(),userO.getPassword());
    }
}
