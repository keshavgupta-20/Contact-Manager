package DaoImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dao.UserDao;
import Entites.User;
import Util.JdbcUtil;

public class UserdaoImpl implements UserDao {
	public User getUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection con = JdbcUtil.getDbConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getString("userId"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }


	 

	public boolean saveUser(User user) {
	       String sql = "INSERT INTO users (userId, name, email, password) VALUES (?, ?, ?, ?)";
	        try (Connection con = JdbcUtil.getDbConnection();	
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, user.getUserId());
	            ps.setString(2, user.getName());
	            ps.setString(3, user.getEmail());
	            ps.setString(4, user.getPassword());

	            return ps.executeUpdate() == 1;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
