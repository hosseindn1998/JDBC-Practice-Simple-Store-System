package Service;

import Entity.Product;
import Entity.ShareholderBrand;
import Repository.ShareholderBrandRepository;
import Repository.ShareholderRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderBrandService {
    private final Scanner scanner=new scanner(System.in);

    private final ShareholderBrandRepository shareholderBrandRepository;
    public ShareholderBrandService(ShareholderBrandRepository shareholderBrandRepository) {
        this.shareholderBrandRepository=shareholderBrandRepository;
    }
    public void addShareholderBrand() throws SQLException {

        System.out.println("Please enter your shareholder Id:");
        int shareholderId = scanner.nextInt();
        System.out.println("Please enter your brand id:");
        int brandId = scanner.nextInt();
        ShareholderBrand shareholderBrand=new ShareholderBrand();
        int result= shareholderBrandRepository.addShareholderBrand(shareholderBrand);
        if(result==1) System.out.println(" product added Successfully ");
        else{
            System.out.println("Error in product adding . something is wrong");
        }
    }


}
