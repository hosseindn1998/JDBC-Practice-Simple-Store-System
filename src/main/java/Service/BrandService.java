package Service;
import Entity.Brand;
import Entity.Category;
import Entity.Shareholder;

import java.sql.SQLException;
import java.util.Scanner;
import Repository.BrandRepository;

public class BrandService {
    private final BrandRepository brandRepository;
    private final Scanner scanner=new Scanner(System.in);
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository=brandRepository;
    }
    public void addBrand() throws SQLException {

        System.out.println("Please enter your Brand name:");
        String brandName = scanner.nextLine();
        System.out.println("Please enter your Brand website:");
        String brandWebsite = scanner.nextLine();
        System.out.println("Please enter your category description:");
        String brandDescription = scanner.nextLine();
        Brand brand=new Brand(brandName,brandWebsite,brandDescription);
        int result= brandRepository.addBrand(brand);
        if(result==1) System.out.println(" brand added Successfully ");
        else{
            System.out.println("Error in brand adding . something is wrong");
        }
    }
    public void deleteBrand() throws SQLException {
        System.out.println("please Enter CategoryId that you want delete? ");
        int deleteBrandId=scanner.nextInt();
        int result=brandRepository.deleteBrand(deleteBrandId);
        if(result==1) System.out.println(" category deleted Successfully ");
        else{
            System.out.println("Error in category Deleting . something is wrong");
        }
    }


}
