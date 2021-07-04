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
                    .prepareStatement("Select * from techno_store.users where username=?");
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
                user.setRole(set.getString("role"));
                user.setDateTime(LocalDateTime.parse(set.getDate("create_date").toString()));
                user.setStatus(set.getBoolean("status"));
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
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement(
                            "select * from techno_store.users where username=? ");
            stmt.setString(1, username);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                return true;
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
        return false;
    }

    public boolean existByEmail(String username) {
        ConnectionDb conn = new ConnectionDb();
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement(
                            "select * from techno_store.users where email=? ");
            stmt.setString(1, username);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                return true;
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
        return false;

    }

    public boolean existByPhone(String phone) {
        ConnectionDb conn = new ConnectionDb();
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement(
                            "select * from techno_store.users where phone=? ");
            stmt.setString(1, phone);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                return true;
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }
        return false;

    }
    public void addUser(Users user){
        ConnectionDb conn = new ConnectionDb();
        PasswordEncoder encoder=new PasswordEncoder();
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement(
                            "insert into techno_store.users(name,surname,email,phone,username,password,role)" +
                                    "values(?,?,?,?,?,?,?) ");
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getSurname());
            stmt.setString(3,user.getEmail());
            stmt.setString(4,user.getPhone());
            stmt.setString(5,user.getUsername());
            stmt.setString(6,encoder.passwordEncoder(user.getPassword()));
            stmt.setString(7,"user");
            stmt.executeUpdate();
            conn.disConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            conn.disConnection();
        }

    }

    public static void main(String[] args) {
        Users users=new Users();
        users.setName("kjihih");
        users.setSurname("hjhihk");
        users.setPhone("joijoij");
        users.setEmail("pklpkp");
        users.setUsername("kjkjk");
        users.setPassword("kjhkjhk");
        UserRepo repo=new UserRepo();
        repo.addUser(users);

    }


}
