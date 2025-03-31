package main.Test;

import main.Dao.UsersDao.UsersDao;
import main.model.User;

import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        UsersDao usersDao = new UsersDao();
        usersDao.insert(new User(19, "李四", "123", "123@qq.com"));
        var user1 = usersDao.findByNameAndPassword("李四", "123");
        user1.ifPresentOrElse((user) -> {
            System.out.println(user);
            System.out.println("测试成功，即将删除");
            usersDao.delete(user.getId());
        }, () -> System.out.println("用户不存在/查询失败"));
        UsersDao.DestoryConnection();


    }
}
