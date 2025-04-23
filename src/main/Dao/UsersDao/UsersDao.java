package main.Dao.UsersDao;

import main.model.User;
import main.util.JDBCUtil.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

public class UsersDao {

    public Optional<User> findByNameAndPassword(String name, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (Connection connection = JDBCUtils.getConnection("root", "123456", "JDBC").orElseThrow();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getDate("birthday")
                    ));
                }
            }
        }
        return Optional.empty();
    }
    public Optional<User> findByName(String name)  {
        String query = "SELECT * FROM users WHERE name = ?";
        try(var connection=JDBCUtils.getConnection("root","123456","JDBC").orElseThrow();
            var statement=connection.prepareStatement(query)){
            statement.setString(1,name);
            var resultSet=statement.executeQuery();
                if(resultSet.next()){
                    return Optional.of(new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getDate("birthday")
                    ));
                }

        }
        catch (SQLException e){
            System.out.println("findByName查询异常"+e.getMessage());
        }
        return Optional.empty();
    }
    public ArrayList<User> findAll() throws SQLException {
        String query = "SELECT * FROM users";
        ArrayList<User> users = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection("root", "123456", "JDBC").orElseThrow();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getDate("birthday")
                ));
            }
        }
        return users;
    }

    public int insert(User user) throws SQLException {
        String query = "INSERT INTO users (name, email, password, birthday) VALUES (?, ?, ?, ?)";
        try (Connection connection = JDBCUtils.getConnection("root", "123456", "JDBC").orElseThrow();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
            return statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection connection = JDBCUtils.getConnection("root", "123456", "JDBC").orElseThrow();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}