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
            System.out.println("数据库" + dataBase + "连接失败\t" + Arrays.toString(e.getStackTrace()));
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        getConnection("root", "123456", "jdbc").ifPresentOrElse(connection -> {
            try {
                System.out.println("用户：" + connection.getMetaData().getUserName() + "连接成功");
                var lists = UsersDao.findAll(connection);
                //foreach (Users user : UsersDao.findAll(connection)) {

                for (var user : lists) {
                    System.out.println(user);
                }
                var user = UsersDao.findByNameAndPassword(connection, "张三", "123");
                user.ifPresentOrElse(System.out::println, () -> System.out.println("用户不存在/查询失败"));



                connection.close();
            } catch (SQLException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }, () -> System.out.println("数据库连接失败"));

    }
}
