package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*;

import Repository.UserRepository;
import Entity.User;
import lombok.*;

@Getter
@Setter

public class UserService {

    private final Scanner scanner = new Scanner(System.in);

    private final UserRepository userRepository;
    String userName = "";
    String password = "";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void singUp() throws SQLException {

        System.out.println("Enter FullName :");

        String name = scanner.next();

        do {
            System.out.println("Enter username :");
            userName = scanner.next();
        } while (!isValidUsername(userName));

        System.out.println("Enter email :");
        String email = scanner.next();

        do {
            System.out.println("Enter password :");
            password = scanner.next();
        } while (!isValidPassword(password));


        User user = new User(name, userName, email, password);
        int result = userRepository.addUser(user);
        if (result == 1) {
            System.out.println("Dear " + name + " ,You are now registered and can login now.");
        } else {
            System.out.println("Something is wrong! try again");
        }

    }

    public static boolean isValidPassword(String password) {

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern pattern = Pattern.compile(regex);
        if (password == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static boolean isValidUsername(String username) {

        String regex = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";

        Pattern pattern = Pattern.compile(regex);
        if (username == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(username);

        return matcher.matches();
    }

    public void signIn() throws SQLException {

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();


        System.out.println("Please enter your password");
        String password = scanner.nextLine();

        User user = userRepository.findByUsername(username);
        if (user == null)
            System.out.println("Please register first");
        else if (!user.getPassword().equals(password))
            System.out.println("Please enter correct password");
        else
            System.out.println("WELCOME " + user.getUserName());
    }


}
