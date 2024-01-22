package Repository;

import lombok.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entity.Category;
@Getter
@Setter
public class CategoryRepository {
private final Connection connection;
public CategoryRepository(Connection connection){
    this.connection=connection;
}
public int addCategory (Category category)throws SQLException {
    String addCategoryQuery="INSERT INTO categories(name,description)VALUES (?,?)";
    PreparedStatement preparedStatement=connection.prepareStatement(addCategoryQuery);
    preparedStatement.setString(1,category.getName());
    preparedStatement.setString(2,category.getDescription());
    int result= preparedStatement.executeUpdate();
    return result;
}
}
