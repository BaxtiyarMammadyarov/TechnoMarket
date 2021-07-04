package az.mycompany.TechnoMarket.db;

import java.sql.SQLException;
import java.sql.Statement;

public class InitializrDb {

    public void createBrandTable(){
        ConnectionDb conn=new ConnectionDb();
        try {
            Statement stmt=conn.getConnection().createStatement();
            stmt.executeUpdate(
                    "create table techno_store.brand(" +
                            "id  SERIAL PRIMARY KEY" +
                            ",name varchar(20)" +
                            ",create_date date default current_date " +
                            ",status BOOL default false )");
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }

    }
    public void createModelTable(){
        ConnectionDb conn=new ConnectionDb();
        try {
            Statement stmt=conn.getConnection().createStatement();
            stmt.executeUpdate(
                    "CREATE TABLE techno_store.model(" +
                            "   id SERIAL primary key ," +
                            "   brand_id INT," +
                            "   name VARCHAR(25) NOT NULL," +
                            "   create_date date default current_date ," +
                            "   status bool default false ," +
                            "   CONSTRAINT fk_brand_id" +
                            "      FOREIGN KEY(brand_id) " +
                            "  REFERENCES techno_store.brand(id)" +
                            ")" );
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
    }
    public void createProductTable(){
        ConnectionDb conn=new ConnectionDb();
        try {
            Statement stmt=conn.getConnection().createStatement();
            stmt.executeUpdate(
                    "CREATE TABLE techno_store.product(" +
                            "   id SERIAL primary key ," +
                            "   model_id INT," +
                            "   name VARCHAR(25) NOT NULL," +
                            "   create_date date default current_date ," +
                            "   status bool default false ," +
                            "   CONSTRAINT fk_model_id" +
                            "      FOREIGN KEY(model_id) " +
                            "  REFERENCES techno_store.model(id)" +
                            ")" );
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
    }
    public void createUsersTable(){
        ConnectionDb conn=new ConnectionDb();
        try {
            Statement stmt=conn.getConnection().createStatement();
            stmt.executeUpdate(
                    "CREATE TABLE techno_store.users(" +
                            "   id SERIAL primary key ," +
                            "   name VARCHAR(25) NOT NULL," +
                            "   surname VARCHAR(25) NOT NULL," +
                            "   email VARCHAR(25) NOT NULL unique ," +
                            "   phone VARCHAR(25) NOT NULL unique ," +
                            "   username VARCHAR(25) NOT NULL unique ," +
                            "   password VARCHAR(25) NOT NULL," +
                            "   role VARCHAR(25) NOT NULL," +
                            "   create_date date default current_date ," +
                            "   status bool default true " +
                            ")" );
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
    }

    public static void main(String[] args) {
        InitializrDb initializrDb=new InitializrDb();
//        initializrDb.createBrandTable();
//        initializrDb.createModelTable();
//        initializrDb.createProductTable();
        initializrDb.createUsersTable();
    }
}
