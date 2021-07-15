package az.mycompany.TechnoMarket.db;

import az.mycompany.TechnoMarket.model.Brand;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BrandRepo {

    public List<Brand> get() {
        ConnectionDb conn = new ConnectionDb();
        List<Brand> list = new ArrayList<>();
        try {
            Statement stmt = conn.getConnection().createStatement();

            ResultSet set = stmt.executeQuery("select * from brand");
            while (set.next()) {
                list.add(convertResultSetToBrand(set));
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public Brand add(Brand brand) {
        ConnectionDb conn = new ConnectionDb();
        Brand brand1 = getByName(brand.getName());
        try {
            if (brand1 == null) {
                PreparedStatement stmt = conn
                        .getConnection()
                        .prepareStatement("insert into brand(name,create_date) values(?,?) ");
                stmt.setString(1, brand.getName());
                LocalDateTime dateTime = LocalDateTime.now();
                stmt.setString(2, dateTime.toString());
                stmt.executeUpdate();
                Statement statement = conn.getConnection().createStatement();
                brand = getByName(brand.getName());
                conn.disConnection();
            } else {
                brand = brand1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return brand;
    }

    public void delete(int id) {
        ConnectionDb conn = new ConnectionDb();

        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("update brand set enabled=false where id=?");
            stmt.setInt(1, id);
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void update(Brand brand) {


    }

    public Brand getByName(String name) {
        ConnectionDb conn = new ConnectionDb();
        Brand brand = null;
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("select * from  where name =?");
            stmt.setString(1, name);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                brand = convertResultSetToBrand(set);
            }

            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return brand;
    }

    public boolean existByBrand(Brand brand) {
        ConnectionDb conn = new ConnectionDb();

        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("select * from brand where name=?");
            stmt.setString(1, brand.getName());
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                return true;
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    private Brand convertResultSetToBrand(ResultSet set) throws SQLException {
        return new Brand(set.getInt("id")
                    , LocalDateTime.parse(set.getString("create_date"))
                    , set.getBoolean("enabled")
                    , set.getString("name"));

    }
}
