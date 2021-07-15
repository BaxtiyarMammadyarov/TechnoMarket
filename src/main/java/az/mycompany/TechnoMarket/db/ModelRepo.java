package az.mycompany.TechnoMarket.db;

import az.mycompany.TechnoMarket.model.Brand;
import az.mycompany.TechnoMarket.model.Model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ModelRepo {

    public List<Model> get() {
        ConnectionDb conn = new ConnectionDb();
        List<Model> list = new ArrayList<>();
        try {
            Statement stmt = conn.getConnection().createStatement();

            ResultSet set = stmt.executeQuery("select * from model join brand on(model.brand_id=brand.id)");
            while (set.next()) {
                list.add(convertResultSetToModel(set));
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    public Model add(Model model) {
        BrandRepo repo = new BrandRepo();

        ConnectionDb conn = new ConnectionDb();
        Brand brand = new Brand();
        Model model1 = getByName(model.getName());
        try {
            if (model1 == null) {
                if (repo.existByBrand(model.getBrand())) {
                    brand = repo.getByName(model.getBrand().getName());

                } else {
                    brand = repo.add(model.getBrand());
                }
                PreparedStatement stmt = conn
                        .getConnection()
                        .prepareStatement("insert into model(name,brand_id,create_date) values(?,?,?) ");
                stmt.setString(1, brand.getName());
                stmt.setInt(2, brand.getId());
                LocalDateTime dateTime = LocalDateTime.now();
                stmt.setString(3, dateTime.toString());
                stmt.executeUpdate();
                model.setBrand(brand);

                conn.disConnection();
            } else {
                model = model1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;

    }

    public void delete(int id) {
        ConnectionDb conn = new ConnectionDb();

        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("update model set enabled=false where id=?");
            stmt.setInt(1, id);
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Model model) {

    }

    public boolean existByModel(Model model) {
        ConnectionDb conn = new ConnectionDb();

        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("select * from model where name=?");
            stmt.setString(1, model.getName());
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

    public Model getByModel(String name) {
        ConnectionDb conn = new ConnectionDb();
        Model model = new Model();
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("select * from model join brand on(model.brand_id=brand.id)  where name =?");
            stmt.setString(1, name);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                model = convertResultSetToModel(set);
            }

            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public Model getByName(String name) {
        ConnectionDb conn = new ConnectionDb();
        Model model = null;
        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("select * from model where name =?");
            stmt.setString(1, name);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                model = convertResultSetToModel(set);
            }

            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    private Model convertResultSetToModel(ResultSet set) throws SQLException {
        return new Model(set.getInt("model.id")
                , LocalDateTime.parse(set.getDate("model.create_date").toString())
                , set.getBoolean("model.enabled")
                , set.getString("model.name"),
                new Brand(set.getInt("brand.id")
                        , LocalDateTime.parse(set.getString("brand.create_date"))
                        , set.getBoolean("brand.enabled")
                        , set.getString("brand.name")));
    }
}
