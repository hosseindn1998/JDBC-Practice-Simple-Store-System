package Service;
import Repository.CategoryRepository;
import Entity.Category;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {
    private final Scanner scanner = new Scanner(System.in);
    private final CategoryRepository categoryRepository;
    CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    public void addCategory() throws SQLException {

        System.out.println("Please enter your category name:");
        String categoryName = scanner.nextLine();
        System.out.println("Please enter your category description:");
        String categoryDescription = scanner.nextLine();
        Category category=new Category(categoryName,categoryDescription);
        int result= categoryRepository.addCategory(category);
        if(result==1) System.out.println(" category added Successfully ");
        else{
            System.out.println("something is wrong");
        }
    }
    public void deleteCategory() throws SQLException {
        System.out.println("please Enter CategoryId that you want delete? ");
        int deleteCategoryId=scanner.nextInt();
        int result=categoryRepository.deleteCategory(deleteCategoryId);
        if(result==1) System.out.println(" category deleted Successfully ");
        else{
            System.out.println("something is wrong");
        }
    }
}
