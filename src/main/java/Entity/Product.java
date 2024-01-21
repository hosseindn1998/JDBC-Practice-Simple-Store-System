package Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {
    private int id;
    private String name;
    private  String CreateDate;
    private int categoryId;
    private int brandId;

    public Product(String name, String createDate, int categoryId, int brandId) {
        this.name = name;
        CreateDate = createDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
