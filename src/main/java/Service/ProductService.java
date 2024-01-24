package Service;

import Entity.Product;
import Repository.ProductRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {

    private final ProductRepository productRepository;
    private final Scanner scanner=new Scanner(System.in);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void addProduct() throws SQLException {

        System.out.println("Please enter your Product name:");
        String productName = scanner.nextLine();
        System.out.println("Please enter your Product create date:");
        String createDate = scanner.nextLine();
        System.out.println("Please enter your category id:");
        int categoryId = scanner.nextInt();
        System.out.println("Please enter your brand id:");
        int brandId = scanner.nextInt();
        Product product=new Product(productName,createDate,categoryId,brandId);
        int result= productRepository.addProduct(product);
        if(result==1) System.out.println(" brand added Successfully ");
        else{
            System.out.println("Error in brand adding . something is wrong");
        }
    }


}
