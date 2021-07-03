package az.mycompany.TechnoMarket.db;

import az.mycompany.TechnoMarket.model.Users;

import java.lang.ref.PhantomReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class UserRepo {

  public   Users getByUser(String username){
        ConnectionDb conn=new ConnectionDb();
        Users user =new Users();
        try {
            PreparedStatement stmt=conn
                    .getConnection()
                    .prepareStatement("Select * from techno_store.users where username=?");
            stmt.setString(1,username);

            ResultSet set= stmt.executeQuery();
            while (set.next()){

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
