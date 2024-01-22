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
public int deleteCategory(int id)throws SQLException{
    String deleteCategoryQuery="DELETE FROM categories WHERE category_id=?";
    PreparedStatement preparedStatement=connection.prepareStatement(deleteCategoryQuery);
    preparedStatement.setInt(1,id);
    int result = preparedStatement.executeUpdate();
    return result;
}
public int editCategory (Category category)throws SQLException{
    String editCategoryQuery = "UPDATE  prescription SET name=?,description =? WHERE id=?;";
    PreparedStatement preparedStatement = connection.prepareStatement(editCategoryQuery);
    preparedStatement.setString(1, category.getName());
    preparedStatement.setString(2, category.getDescription());
    preparedStatement.setInt(3,category.getId());
    int result = preparedStatement.executeUpdate();
    return result;
}
}
