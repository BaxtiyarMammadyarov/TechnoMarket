package az.mycompany.TechnoMarket.db;

import az.mycompany.TechnoMarket.model.Users;
import az.mycompany.TechnoMarket.util.PasswordEncoder;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class UserRepo {

    public Users getByUser(String username) {
        ConnectionDb conn = new ConnectionDb();
        Users user = new Users();
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("Select * from users where username=?");
            stmt.setString(1, username);

            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                user.setId(set.getInt("id"));
                user.setName(set.getString("name"));
                user.setSurname(set.getString("surname"));
                user.setEmail(set.getString("email"));
                user.setPhone(set.getString("phone"));
                user.setUsername(set.getString("username"));
                user.setPassword(set.getString("password"));
                user.setStatus(set.getString("status"));
                user.setDateTime(LocalDateTime.parse(set.getString("create_date")));
                user.setEnabled(set.getBoolean("enabled"));
            }
            conn.disConnection();
            return user;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
        return user;
    }

    public boolean existByUsername(String username) {
        ConnectionDb conn = new ConnectionDb();
        boolean answer=false;
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement(
                            "select * from users where username=? ");
            stmt.setString(1, username);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                answer= true;
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
        return answer;
    }

    public boolean existByEmail(String username) {
        ConnectionDb conn = new ConnectionDb();
        boolean answer=false;
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement(
                            "select * from users where email=? ");
            stmt.setString(1, username);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                answer= true;
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
        return answer;

    }

    public boolean existByPhone(String phone) {
        ConnectionDb conn = new ConnectionDb();
        boolean answer=false;
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement(
                            "select * from users where phone=? ");
            stmt.setString(1, phone);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
               answer= true;
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
        return answer;

    }
    public void addUser(Users user){
        ConnectionDb conn = new ConnectionDb();
        PasswordEncoder encoder=new PasswordEncoder();
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement(
                            "insert into users(name,surname,email,phone,username,password,status,create_date)" +
                                    "values(?,?,?,?,?,?,?,?) ");
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getSurname());
            stmt.setString(3,user.getEmail());
            stmt.setString(4,user.getPhone());
            stmt.setString(5,user.getUsername());
            stmt.setString(6,encoder.passwordEncoder(user.getPassword()));
            stmt.setString(7,user.getStatus());
            LocalDateTime dateTime=LocalDateTime.now();
            stmt.setString(8,dateTime.toString());
            stmt.executeUpdate();
            conn.disConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }

    }

//    public static void main(String[] args) {
//        Users users=new Users();
//     UserRepo repo=new UserRepo();
//        System.out.println( repo.existByUsername("baxtiyar"));
//
//    }


}
