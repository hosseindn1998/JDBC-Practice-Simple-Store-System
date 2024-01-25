package Service;

import Entity.Brand;
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
        if(result==1) System.out.println(" product added Successfully ");
        else{
            System.out.println("Error in product adding . something is wrong");
        }
    }
    public void deleteProduct() throws SQLException {
        System.out.println("please Enter Product Id that you want delete? ");
        int deleteProductId=scanner.nextInt();
        int result=productRepository.deleteProduct(deleteProductId);
        if(result==1) System.out.println(" product deleted Successfully ");
        else{
            System.out.println("Error in product Deleting . something is wrong");
        }
    }
    public void editProduct()throws SQLException{
        System.out.println("please Enter Product Id that you want edit? ");
        int editProductId=scanner.nextInt();
        System.out.println("Please enter new Product name:");
        String productName = scanner.nextLine();
        System.out.println("Please enter new Product website:");
        String productCreateDate = scanner.nextLine();
        System.out.println("Please enter your Product id:");
        int categoryId = scanner.nextInt();
        System.out.println("Please enter your Product id:");
        int brandId = scanner.nextInt();
        Product product=new Product(editProductId,productName,productCreateDate,categoryId,brandId);
        int result= productRepository.addProduct(product);
        if(result==1) System.out.println(" Product edited Successfully ");
        else{
            System.out.println("Error in product adding . something is wrong");
        }
    }



}
