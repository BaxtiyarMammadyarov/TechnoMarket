package az.mycompany.TechnoMarket.db;

import az.mycompany.TechnoMarket.model.Brand;
import az.mycompany.TechnoMarket.model.Model;
import az.mycompany.TechnoMarket.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    public List<Product> get() {
        ConnectionDb conn = new ConnectionDb();
        List<Product> list = new ArrayList<>();
        try {
            Statement stmt = conn.getConnection().createStatement();

            ResultSet set = stmt.executeQuery("select * from product p  join model  m " +
                    "on (p.model_id=m.id) " +
                    "  join " +
                    " brand b on(m.brand_id=b.id)");
            while (set.next()) {
                list.add(convertResultSetToProduct(set));
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    public Product add(Product product) {
        ModelRepo repo = new ModelRepo();
        ConnectionDb conn = new ConnectionDb();
        Product product1 = getByNameAndColor(product.getName(), product.getColor());
        Model model = new Model();
        try {
            if (product1 == null) {
                if (repo.existByModel(product.getModel())) {
                    model = repo.getByName(product.getModel().getName());

                } else {
                    model = repo.add(product.getModel());
                }
                PreparedStatement stmt = conn
                        .getConnection()
                        .prepareStatement(
                                "insert into product(" +
                                        "name,color,photo,product_type,price,product_count,model_id) " +
                                        "values(?,?,?,?,?,?,?) ");
                stmt.setString(1, product.getName());
                stmt.setString(2, product.getColor());
                stmt.setString(3, product.getPhoto());
                stmt.setString(4,product.getType());
                stmt.setBigDecimal(5,product.getPrice());
                stmt.setInt(6, product.getCountProduct());
                stmt.setInt(7, model.getId());
                stmt.executeUpdate();
                product.setModel(model);

                conn.disConnection();
            } else {
                product = product1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;

    }

    public void delete(int id) {
        ConnectionDb conn = new ConnectionDb();

        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("update product set enabled=false where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(Product product) {

    }

    public Product getByNameAndColor(String name, String color) {
        ConnectionDb connection = new ConnectionDb();
        Product product = null;
        try {
            PreparedStatement statement = connection
                    .getConnection()
                    .prepareStatement("select * from product where name=? and color=?");
            statement.setString(1, name);
            statement.setString(2, color);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                product = convertResultSetToProduct(set);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
    private Product convertResultSetToProduct(ResultSet set) throws SQLException {
        return new Product(set.getInt("product.id")
                , LocalDateTime.parse(set.getDate("product.create_date").toString())
                , set.getBoolean("product.enabled")
                , set.getString("product.name")
                , set.getString("color")
                , set.getString("photo")
                ,set.getString("type")
                ,set.getBigDecimal("price")
                , set.getInt("count_product"),
                new Model(set.getInt("model.id")
                        , LocalDateTime.parse(set.getDate("model.create_date").toString())
                        , set.getBoolean("model.enabled")
                        , set.getString("model.name"),
                        new Brand(set.getInt("brand.id")
                                , LocalDateTime.parse(set.getDate("brand.create_date").toString())
                                , set.getBoolean("brand.enabled")
                                , set.getString("brand.name"))));
    }
    public List<String>getBrandNameByType(String type){
        List<String>list=new ArrayList<>();
        ConnectionDb conn = new ConnectionDb();

        try {
            PreparedStatement stmt = conn
                    .getConnection()
                    .prepareStatement("select distinct p.product_type from product p join model m "  +
                                               "on (p.model_id=m.id)" +
                                               "join brand b on(m.brand_id=b.id)" +
                            "where p.product_type=?");
            stmt.setString(1, type);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    list.add(resultSet.getString(type));
                }
            }
            conn.disConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}

