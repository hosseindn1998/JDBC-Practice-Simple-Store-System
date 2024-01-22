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
    public int deleteShareholder(int id) throws SQLException {
        String deleteShareholderQuery="DELETE * FROM shareholder WHERE shareholder_id=?";
        PreparedStatement preparedStatement= connection.prepareStatement(deleteShareholderQuery);
        preparedStatement.setInt(1, id);

        int result=preparedStatement.executeUpdate();
        return result;
    }
    public int editShareholder(Shareholder shareholder,int id) throws SQLException {
        String editShareholderQuery="UPDATE shareholder SET name=?,phone_number=?,national_code WHERE shareholder_id=?";
        PreparedStatement preparedStatement= connection.prepareStatement(editShareholderQuery);
        preparedStatement.setString(1, shareholder.getName());
        preparedStatement.setInt(2, shareholder.getPhoneNumber());
        preparedStatement.setInt(3, shareholder.getNational_code());
        preparedStatement.setInt(4, id);
        int result=preparedStatement.executeUpdate();
        return result;
    }
}
