package main.util;

import main.Dao.UsersDao.UsersDao;
import main.util.JDBCUtil.JDBCUtils;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Example01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ExecutionException, InterruptedException {
      var conn= JDBCUtils.getConnection("root","123456","jdbc");
      var userDao=new UsersDao();
     var u= userDao.findByName("dmz");
        u.ifPresentOrElse(
                user -> System.out.println("用户存在："+user),
                () -> System.out.println("用户不存在")
        );
    }
}
