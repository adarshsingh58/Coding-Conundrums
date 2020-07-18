import java.util.List;

/*
 * ProductoionReady
 * Scalable
 * Maintainable
 * */
public class Test {
    public static void main(String[] args) {


    }


}

enum Action {
    READ,
    WRITE,
    DELETE;
}

enum Role {
    ADMIN,
    READ_USER,
    WRITE_USER,
    DELETE_USER;
}

class RoleActionMapping {
    List<Action> actions;
    Role role;
}

class User {
    String firstName;
    String lastName;
    String id;
    Role role;
}

