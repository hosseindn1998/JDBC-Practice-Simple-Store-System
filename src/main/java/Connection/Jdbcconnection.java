package Connection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Jdbcconnection {

    private static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "#HDn1998");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Jdbcconnection() {
    }

    static public Connection getConnection() {
        return connection;
    }

}