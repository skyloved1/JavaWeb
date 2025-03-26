package main.Dao.UsersDao;

import main.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class UsersDao {
     static public ArrayList<User> findAll (Connection conn) throws SQLException {
          var state = conn.createStatement();
          var result = state.executeQuery("SELECT * FROM users");
            var users = new ArrayList<User>();
            while (result.next()) {
                users.add(new User(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("password"), result.getDate("birthday")));
            }
            return users;
     }
     static public Optional<User> findByNameAndPassword (Connection conn, String name, String password) throws SQLException {
          var state = conn.createStatement();
          var result = state.executeQuery("SELECT * FROM users WHERE name = '" + name + "' AND password = '" + password + "'");
            if (result.next()) {
                return Optional.of(new User(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("password"), result.getDate("birthday")));
            }
            return Optional.empty();
     }

}
