package Utility;

import Connection.Jdbcconnection;
import Repository.*;
import Service.*;

import java.sql.Connection;
import java.sql.Connection.*;

public class ApplicationContext {
    private static final Connection CONNECTION;
    private static final UserRepository USER_REPOSITORY;
    private static final UserService USER_SERVICE;
    private static final ShareholderRepository SHAREHOLDER_REPOSITORY ;
    private static final ShareholderService SHAREHOLDER_SERVICE;
    private static final CategoryRepository CATEGORY_REPOSITORY;
    private static final CategoryService CATEGORY_SERVICE;



    static {
        CONNECTION = Jdbcconnection.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE = new UserService(USER_REPOSITORY);
        SHAREHOLDER_REPOSITORY=new ShareholderRepository(CONNECTION);
        SHAREHOLDER_SERVICE=new ShareholderService(SHAREHOLDER_REPOSITORY);
        CATEGORY_REPOSITORY=new CategoryRepository(CONNECTION);
        CATEGORY_SERVICE=new CategoryService(CATEGORY_REPOSITORY);

    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }

}
