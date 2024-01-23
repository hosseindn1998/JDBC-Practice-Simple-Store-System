package Repository;

import Entity.User;
import lombok.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class UserRepository  {
    private final Connection connection;
    public UserRepository(Connection connection){
        this.connection=connection;
    }

    public int addUser(User user) throws SQLException {

        String addUserQuery = "INSERT INTO Users(name,username,email,password) VALUES(?,?,?,?); ";

        PreparedStatement preparedStatement = connection.prepareStatement(addUserQuery);

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getEmail());

        int result = preparedStatement.executeUpdate();
        return result;

    }
    public int deleteUser(int id) throws SQLException {

        String addUserQuery = "DELETE  FROM Users WHERE id=?;";

        PreparedStatement preparedStatement = connection.prepareStatement(addUserQuery);

        preparedStatement.setInt(1, id);

        int result = preparedStatement.executeUpdate();
        return result;
    }
    public User findByUsername(String username) throws SQLException {
        String findUser = "SELECT * FROM users WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String Name = resultSet.getString("name");
            String fetchUsername = resultSet.getString("username");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            User user = new User(id, Name, fetchUsername,email ,password);
            return user;
        }
        else
            return null;
    }

}
