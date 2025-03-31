package main.Dao.UsersDao;

import main.model.User;
import main.util.JDBCUtil.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class UsersDao {
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static Optional<Connection> conn = Optional.empty();

    public UsersDao() {
        if (conn.isEmpty()) {
            conn = JDBCUtils.getConnection("root", "123456", "JDBC");
        }
    }

    public static void DestoryConnection() {

        conn.ifPresent((connection -> {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("关闭连接失败" + Arrays.toString(e.getStackTrace()));
            }
        }));


    }

    static public ArrayList<User> findAll() throws SQLException {
        var state = conn.get().createStatement();
        var result = state.executeQuery("SELECT * FROM users");
        var users = new ArrayList<User>();
        while (result.next()) {
            users.add(new User(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("password"), result.getDate("birthday")));
        }
        return users;
    }

    /**
     * 根据用户名和密码查找用户
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户
     * @throws SQLException 数据库异常
     */
    public Optional<User> findByNameAndPassword(String name, String password) throws SQLException {
        var state = conn.get().createStatement();
        var result = state.executeQuery("SELECT * FROM users WHERE name = '" + name + "' AND password = '" + password + "'");
        if (result.next()) {
            return Optional.of(new User(result.getInt("id"), result.getString("name"), result.getString("email"), result.getString("password"), result.getDate("birthday")));
        }
        return Optional.empty();
    }

    public int insert(User user) throws SQLException {
        var state = conn.get().createStatement();
        var u = findByNameAndPassword(user.getName(), user.getPassword());
        if (u.isPresent()) {
            return 0;
        }
        var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        var birthday = simpleDateFormat.format(user.getBirthday());
        return state.executeUpdate("INSERT INTO users (name, email, password, birthday) VALUES ('" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', '" + birthday + "')");
    }

    public void delete(int id) {
        try {
            var state = conn.get().createStatement();
            state.executeUpdate("DELETE FROM users WHERE id = " + id);
        } catch (SQLException e) {
            System.out.println("删除用户失败\t" + Arrays.toString(e.getStackTrace()));
        }
    }
}
