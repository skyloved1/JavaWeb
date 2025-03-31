package main.Test;

import main.Dao.UsersDao.UsersDao;
import main.model.User;
import main.util.JDBCUtil.JDBCUtils;

import java.sql.SQLException;
import java.util.Arrays;

public class TestJDBC {
    public static void main(String[] args) {
        JDBCUtils.getConnection("root", "123456", "jdbc").ifPresentOrElse(connection -> {
            try {
                System.out.println("用户：" + connection.getMetaData().getUserName() + "连接成功");
                /*var lists = UsersDao.findAll(connection);
                //foreach (Users user : UsersDao.findAll(connection)) {

                for (var user : lists) {
                    System.out.println(user);
                }*/
//                var user = UsersDao.findByNameAndPassword(connection, "张三", "123");
//                user.ifPresentOrElse(System.out::println, () -> System.out.println("用户不存在/查询失败"));

                UsersDao.insert(connection, new User(19, "李四", "123", "123@qq.com"));
                var user1 = UsersDao.findByNameAndPassword(connection, "李四", "123");
                user1.ifPresentOrElse((user)->{
                    System.out.println(user);
                    System.out.println("测试成功，即将删除");
                    UsersDao.delete(connection, user.getId());
                }, () -> System.out.println("用户不存在/查询失败"));



                connection.close();
            } catch (SQLException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }, () -> System.out.println("数据库连接失败"));

    }
}
