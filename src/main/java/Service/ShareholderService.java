package Service;

import Entity.Category;
import Entity.Shareholder;
import Repository.ShareholderRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderService {
    private final Scanner scanner = new Scanner(System.in);
    private final ShareholderRepository shareholderRepository;

    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    public void addShareholder() throws SQLException {

        System.out.println("Please enter shareholder name:");
        String shareHolderName = scanner.nextLine();
        System.out.println("Please enter your phone number (without 0) for example 912*******:");
        int phoneNumber = scanner.nextInt();
        System.out.println("Please enter your national code (must be 10 character):");
        int nationalCode = scanner.nextInt();
        Shareholder shareholder = new Shareholder(shareHolderName, phoneNumber, nationalCode);
        int result = shareholderRepository.addShareholder(shareholder);
        if (result == 1) System.out.println(" shareholder added Successfully ");
        else {
            System.out.println("Error in shareholder adding . something is wrong");
        }
    }

    public void deleteShareholder() throws SQLException {
        System.out.println("please Enter shareholderId that you want delete? ");
        int deleteShareHolderId = scanner.nextInt();
        int result = shareholderRepository.deleteShareholder(deleteShareHolderId);
        if (result == 1) System.out.println(" category deleted Successfully ");
        else {
            System.out.println("Error in category Deleting . something is wrong");
        }
    }

    public void editShareholder() throws SQLException {
        System.out.println("please Enter ShareHolderId that you want edit? ");
        int editShareHolderId = scanner.nextInt();
        System.out.println("Please enter New shareholder name:");
        String shareHolderName = scanner.nextLine();
        System.out.println("Please enter New phone number (without 0) for example 912*******:");
        int phoneNumber = scanner.nextInt();
        System.out.println("Please enter New national code (must be 10 character):");
        int nationalCode = scanner.nextInt();
        Shareholder shareholder = new Shareholder(shareHolderName, phoneNumber, nationalCode);
        int result = shareholderRepository.addShareholder(shareholder);
        if (result == 1) System.out.println(" shareholder edited Successfully ");
        else {
            System.out.println("Error in shareholder editing . something is wrong");
        }
    }
}
