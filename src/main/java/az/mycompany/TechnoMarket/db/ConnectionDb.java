package az.mycompany.TechnoMarket.db;


import java.sql.*;

public class ConnectionDb {
//    private String className = "org.postgresql.Driver";
    private String urlDb ="jdbc:postgresql://localhost:5432/technostore";

    private String userName= "postgres";
    private String password= "root";
    private  Connection conn=null;



    public  Connection getConnection() {

        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlDb , userName, password);
                return conn;

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    public void disConnection() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        ConnectionDb connectionDb=new ConnectionDb();
       Statement stmt= connectionDb.getConnection().createStatement();
       stmt.executeUpdate(" create table techno_store.test (id integer ,name varchar )");

    }


}
