package Repository;
import lombok.*;

import java.sql.Connection;

@Getter
@Setter
@ToString

public class BrandRepository {
private final Connection connection;
public BrandRepository(Connection connection){
    this.connection=connection;
}

}
