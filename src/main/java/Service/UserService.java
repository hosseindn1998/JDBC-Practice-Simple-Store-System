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



}
