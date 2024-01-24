package Service;

import Entity.Product;
import Entity.ShareholderBrand;
import Repository.ShareholderBrandRepository;
import Repository.ShareholderRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderBrandService {
    private final Scanner scanner=new Scanner(System.in);

    private final ShareholderBrandRepository shareholderBrandRepository;
    public ShareholderBrandService(ShareholderBrandRepository shareholderBrandRepository) {
        this.shareholderBrandRepository=shareholderBrandRepository;
    }
    public void addShareholderBrand() throws SQLException {

        System.out.println("Please enter your shareholder Id:");
        int shareholderId = scanner.nextInt();
        System.out.println("Please enter your brand id:");
        int brandId = scanner.nextInt();
        ShareholderBrand shareholderBrand=new ShareholderBrand(shareholderId,brandId);
        int result= shareholderBrandRepository.addShareholderBrand(shareholderBrand);
        if(result==1) System.out.println(" shareholder brand relation added Successfully ");
        else{
            System.out.println("Error in shareholder brand relating . something is wrong");
        }
    }
    public void deleteShareholderBrand() throws SQLException {
        System.out.println("please Enter shareholder brand relation Id that you want delete? ");
        int deleteShareholderBrandId=scanner.nextInt();
        int result=shareholderBrandRepository.deleteShareholderBrand(deleteShareholderBrandId);
        if(result==1) System.out.println(" shareholder brand relation deleted Successfully ");
        else{
            System.out.println("Error in shareholder brand relation Deleting . something is wrong");
        }
    }
    public void editShareholderBrand()throws SQLException{
        System.out.println("please Enter shareholderBrand relation Id that you want edit? ");
        int editShareholderId=scanner.nextInt();
        System.out.println("Please enter your shareholder id:");
        int shareholderId = scanner.nextInt();
        System.out.println("Please enter your brand id:");
        int brandId = scanner.nextInt();
        ShareholderBrand shareholderBrand=new ShareholderBrand(editShareholderId,shareholderId,brandId);
        int result= shareholderBrandRepository.addShareholderBrand(shareholderBrand);
        if(result==1) System.out.println(" shareholder brand relation added Successfully ");
        else{
            System.out.println("Error in shareholder brand relating . something is wrong");
        }
    }


}
