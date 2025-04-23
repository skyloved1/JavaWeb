package main.util.JDBCUtil;

import main.Dao.UsersDao.UsersDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

public class JDBCUtils {
    public static Optional<Connection> getConnection(String userName, String password, String dataBase) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败\t" + Arrays.toString(e.getStackTrace()));
        }
        String url = "jdbc:mysql://localhost:3306/" + dataBase + "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        try {
            return Optional.of(DriverManager.getConnection(url, userName, password));
        } catch (SQLException e) {
            System.out.println("数据库" + dataBase + "连接失败\t" +e);
        }
        return Optional.empty();
    }
}
