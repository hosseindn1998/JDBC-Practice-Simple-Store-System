package Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shareholder {
    private int id;
    private String name;
    private int phoneNumber;
    private int national_code;

    public Shareholder(String name, int phoneNumber, int national_code) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.national_code = national_code;
    }
}

