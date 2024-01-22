package Repository;

import Entity.Shareholder;
import lombok.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class ShareholderRepository {
 private final Connection connection;

    public ShareholderRepository(Connection connection) {
        this.connection = connection;
    }
    public int addShareholder(Shareholder shareholder) throws SQLException {
        String addShareholderQuery="INSERT INTO shareholder(name,phone_number,national_code) VALUES(?,?,?);";
        PreparedStatement preparedStatement= connection.prepareStatement(addShareholderQuery);
        preparedStatement.setString(1, shareholder.getName());
        preparedStatement.setInt(2, shareholder.getPhoneNumber());
        preparedStatement.setInt(3, shareholder.getNational_code());
    int result=preparedStatement.executeUpdate();
    return result;
    }


}
