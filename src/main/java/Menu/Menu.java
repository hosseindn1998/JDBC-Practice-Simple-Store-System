package Menu;

import Service.*;
import Utility.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);



    UserService userService= ApplicationContext.getUserService();
    ShareholderService shareholderService=ApplicationContext.getShareholderService();
    CategoryService categoryService=ApplicationContext.getCategoryService();
    ShareholderBrandService shareholderBrandService=ApplicationContext.getShareholderBrandService();
    ProductService productService=ApplicationContext.getProductService();
    BrandService brandService=ApplicationContext.getBrandService();



    public void publicMenu() throws SQLException {

        System.out.println("1-Register User");
        System.out.println("2-SignIn User");
        System.out.println("3-Add prescription");
        System.out.println("4-Edit prescription");
        System.out.println("5-Delete prescription");
        System.out.println("6-Exit");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1 -> singUp();
            case 2 -> signIn();
            case 3 -> addBrand();
            case 4 -> editBrand();
            case 5 -> deleteBrand();
            case 6 -> addCetegory();
            case 7 -> editCategory();
            case 8 -> deleteCategory();
            case 9  -> addProduct();
            case 10-> editProduct();
            case 11 -> deleteProduct();
            case 12 -> addShareholder();
            case 13 -> editShareholder();
            case 14 -> deleteShareholder();
            case 15 -> addShareholderBrand();
            case 16 -> editShareholderBrand();
            case 17 -> deleteShareholderBrand();

            case 18 -> System.out.println("Thank you for use,Nice to meet you");
            default -> System.out.println("Fake input,please Enter Number 1-6 ");
        }

    }

    public void singUp() throws SQLException {
        userService.singUp();
    }
    public void signIn() throws SQLException {
        userService.signIn();
    }

    public void addBrand() throws SQLException {
        brandService.addBrand();
    }

    public void editBrand() throws SQLException {
        brandService.editBrand();
    }
    public void deleteBrand() throws SQLException {
        brandService.deleteBrand();
    }
    public void addCetegory() throws SQLException {
        categoryService.addCategory();
    }

    public void editCategory() throws SQLException {
        categoryService.editCategory();
    }
    public void deleteCategory() throws SQLException {
        categoryService.deleteCategory();
    }
    public void addShareholder() throws SQLException {
        shareholderService.addShareholder();
    }

    public void editShareholder() throws SQLException {
        shareholderService.editShareholder();
    }
    public void deleteShareholder() throws SQLException {
        shareholderService.deleteShareholder();
    }
    public void addShareholderBrand() throws SQLException {
        shareholderBrandService.addShareholderBrand();
    }

    public void editShareholderBrand() throws SQLException {
        shareholderBrandService.editShareholderBrand();
    }
    public void deleteShareholderBrand() throws SQLException {
        shareholderBrandService.deleteShareholderBrand();
    }
    public void addProduct() throws SQLException {
        productService.addProduct();
    }

    public void editProduct() throws SQLException {
        productService.editProduct();
    }
    public void deleteProduct() throws SQLException {
        productService.deleteProduct();
    }


}
