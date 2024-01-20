package Entity;

import lombok.*;


import java.util.PrimitiveIterator;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    private int id;
    private String name;
    private String userName;
    private String email;
    private String password;
}
