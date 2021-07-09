package az.mycompany.TechnoMarket.listener;


import az.mycompany.TechnoMarket.db.ConnectionDb;
import az.mycompany.TechnoMarket.db.InitializrDb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebListener
public class DbInitializr implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionDb conn=new ConnectionDb();
        DatabaseMetaData dbm = null;
        InitializrDb initializrDb=new InitializrDb();
        ResultSet tables;
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
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
