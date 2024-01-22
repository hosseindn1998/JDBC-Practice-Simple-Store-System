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

    public int addShareholderBrand(int shareholderId,int brandId) throws SQLException {
        String addShareholderQuery="INSERT INTO shareholder_brand(shareholder_id,brand_id) VALUES(?,?);";
        PreparedStatement preparedStatement= connection.prepareStatement(addShareholderQuery);
        preparedStatement.setInt(1, shareholderId);
        preparedStatement.setInt(2, brandId);
        int result=preparedStatement.executeUpdate();
        return result;
    }
    public int deleteShareholderBrand(int shb_id) throws SQLException {
        String deleteShareholderBrandQuery="DELETE  FROM shareholder_brand WHERE shb_id=?";
        PreparedStatement preparedStatement= connection.prepareStatement(deleteShareholderBrandQuery);
        preparedStatement.setInt(1, shb_id);
        int result=preparedStatement.executeUpdate();
        return result;
    }
    public int editShareholder(int shbId,int shareholderId,int brandId) throws SQLException {
        String editShareholderQuery="UPDATE shareholder_brand SET shareholder_id=?,brand_id=? WHERE shb_id=?";
        PreparedStatement preparedStatement= connection.prepareStatement(editShareholderQuery);
        preparedStatement.setInt(1, shbId);
        preparedStatement.setInt(2, shareholderId);
        preparedStatement.setInt(3, brandId);
        int result=preparedStatement.executeUpdate();
        return result;
    }
}

