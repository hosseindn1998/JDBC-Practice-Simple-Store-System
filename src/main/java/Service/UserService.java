package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*;

import Repository.UserRepository;
import Entity.User;
import Utility.Validation;
import lombok.*;

@Getter
@Setter

public class UserService {

    private final Scanner scanner = new Scanner(System.in);

    private final UserRepository userRepository;
    String machedUserName = "";
    String machedEmail="";
    String machedPassword = "";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void singUp() throws SQLException {

        System.out.println("Enter FullName :");

        String name = scanner.next();

        do {
            System.out.println("Enter username :");
            machedUserName = scanner.next();
        } while (!Validation.isValidUsername(machedUserName));

        do {
            System.out.println("Enter email :");
            machedEmail = scanner.next();
        }while (!Validation.isValidEmail(machedEmail));

        do {
            System.out.println("Enter password :");
            machedPassword = scanner.next();
        } while (!Validation.isValidPassword(machedPassword));


        User user = new User(name, machedUserName, machedEmail, machedPassword);
        int result = userRepository.addUser(user);
        if (result == 1) {
            System.out.println("Dear " + name + " ,You are now registered and can login now.");
        } else {
            System.out.println("Something is wrong! try again");
        }

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
