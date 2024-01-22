package Repository;

import lombok.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class ShareholderBrandRepository {
    private final Connection connection;

    public ShareholderBrandRepository(Connection connection) {
        this.connection = connection;
    }


