package Repository;
import lombok.*;
import Entity.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
@ToString

public class BrandRepository {
private final Connection connection;
public BrandRepository(Connection connection){
    this.connection=connection;
}
public int addBrand(Brand brand)throws SQLException {
    String addBrandQuery="INSERT INTO brand(name,website,description)VALUES (?,?,?);";
    PreparedStatement preparedStatement=connection.prepareStatement(addBrandQuery);
    preparedStatement.setString(1,brand.getName());
    preparedStatement.setString(2,brand.getWebsite());
    preparedStatement.setString(3,brand.getDescription());
    int result=preparedStatement.executeUpdate();
    return result;
}
private int deleteBrand(int id) throws SQLException{
    String deleteBrandQuery="DELETE FROM brand WHERE id=?";

    PreparedStatement preparedStatement=connection.prepareStatement(deleteBrandQuery);
    preparedStatement.setInt(1,id);
    int result = preparedStatement.executeUpdate();
    return result;
}
}
