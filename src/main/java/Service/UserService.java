package Service;

import java.sql.SQLException;
import java.util.Scanner;
import Repository.UserRepository;
import Entity.User;
import lombok.*;

@Getter
@Setter

public class UserService {

    private final Scanner scanner = new Scanner(System.in);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository =userRepository;
    }
    public void singUp() throws SQLException {

        System.out.println("Enter FullName :");
        String name = scanner.next();

        System.out.println("Enter username :");
        String userName = scanner.next();

        System.out.println("Enter email :");
        String email = scanner.next();

        System.out.println("Enter email :");
        String password = scanner.next();

        User user = new User(name,userName,email,password);
        int result=userRepository.addUser(user);
        if (result == 1) {
            System.out.println("Dear "+name+" ,You are now registered and can login now.");
        }else{
            System.out.println("Something is wrong! try again");
        }

    }


}
