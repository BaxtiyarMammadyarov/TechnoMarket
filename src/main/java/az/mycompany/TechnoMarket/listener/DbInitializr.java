package az.mycompany.TechnoMarket.listener;


import az.mycompany.TechnoMarket.db.ConnectionDb;
import az.mycompany.TechnoMarket.db.InitializrDb;
import az.mycompany.TechnoMarket.db.UserRepo;
import az.mycompany.TechnoMarket.model.Users;
import az.mycompany.TechnoMarket.util.PasswordEncoder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class DbInitializr implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionDb conn=new ConnectionDb();
        DatabaseMetaData dbm ;
        InitializrDb initializrDb=new InitializrDb();
        ResultSet tables;
        UserRepo repo=new UserRepo();
        PasswordEncoder encoder=new PasswordEncoder();

        try {
            dbm = conn.getConnection().getMetaData();
            tables = dbm.getTables(null, null, "brand", null);
            if(!tables.next()){
                initializrDb.createBrandTable();
            }
             tables = dbm.getTables(null, null, "model", null);
            if(!tables.next()){
                initializrDb.createModelTable();
            }
           tables = dbm.getTables(null, null, "product", null);
            if(!tables.next()){
                initializrDb.createProductTable();
            }
            tables = dbm.getTables(null, null, "users", null);
            if(!tables.next()){
                initializrDb.createUsersTable();
            }

            repo.addUser(new Users("Baxtiyar","Mammadyarov","batiyar03@gmail.com","077564564616","baxtiyar","admin","admin"));


            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
