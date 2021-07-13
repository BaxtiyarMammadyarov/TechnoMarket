package az.mycompany.TechnoMarket.db;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializrDb {

    public void createBrandTable(){
        ConnectionDb conn=new ConnectionDb();
        try {
            Statement stmt=conn.getConnection().createStatement();
            stmt.executeUpdate(
                    "create table brand(" +
                            "id  SERIAL PRIMARY KEY" +
                            ",name varchar(20)" +
                            ",create_date date default current_date " +
                            ",enabled BOOL default true )");
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
                    "CREATE TABLE model(" +
                            "   id SERIAL primary key ," +
                            "   brand_id INT," +
                            "   name VARCHAR(25) NOT NULL," +
                            "   create_date date default current_date ," +
                            "   enabled BOOL default true ," +
                            "   CONSTRAINT fk_brand_id" +
                            "      FOREIGN KEY(brand_id) " +
                            "  REFERENCES brand(id)" +
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
                    "CREATE TABLE product(" +
                            "   id SERIAL primary key ," +
                            "   model_id INT," +
                            "   name VARCHAR NOT NULL," +
                            "color VARCHAR NOT NULL," +
                            "photo VARCHAR NOT NULL," +
                            "product_type VARCHAR  ," +
                            "price numeric," +
                            "count_product INT," +
                            "   create_date date default current_date ," +
                            "   enabled BOOL default true ," +
                            "   CONSTRAINT fk_model_id" +
                            "      FOREIGN KEY(model_id) " +
                            "  REFERENCES model(id)" +
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
                    "CREATE TABLE users(" +
                            "   id SERIAL primary key ," +
                            "   name VARCHAR NOT NULL," +
                            "   surname VARCHAR NOT NULL," +
                            "   email VARCHAR NOT NULL unique ," +
                            "   phone VARCHAR NOT NULL unique ," +
                            "   username VARCHAR NOT NULL unique ," +
                            "   password VARCHAR NOT NULL," +
                            "   status VARCHAR NOT NULL," +
                            "   create_date date default current_date ," +
                            "   enabled bool default true " +
                            ")" );
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
    }

//    public static void main(String[] args) throws SQLException {
//        InitializrDb initializrDb=new InitializrDb();
//        ConnectionDb connectionDb=new ConnectionDb();
////        initializrDb.createBrandTable();
////        initializrDb.createModelTable();
////        initializrDb.createProductTable();
//        initializrDb.createUsersTable();
////        DatabaseMetaData metaData=connectionDb.getConnection().getMetaData();
////        ResultSet tables=metaData.getTables(null,null,"brand",null);
//
//    }
}
