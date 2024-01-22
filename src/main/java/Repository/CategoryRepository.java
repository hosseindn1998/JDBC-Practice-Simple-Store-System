package Repository;

import lombok.*;

import java.sql.Connection;
@Getter
@Setter
public class CategoryRepository {
private final Connection connection;
public CategoryRepository(Connection connection){
    this.connection=connection;
}

}
