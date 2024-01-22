package Repository;

import Entity.Brand;
import Entity.Product;
import lombok.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class ProductRepository {


    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public int addProduct(Product product,int categoryId,int brandId) throws SQLException {
        String addBrandQuery = "INSERT INTO product(name,create_date,category_id,brand_id)VALUES (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addBrandQuery);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getCreateDate());
        preparedStatement.setInt(3, categoryId);
        preparedStatement.setInt(4, brandId);
        int result = preparedStatement.executeUpdate();
        return result;
    }


}


