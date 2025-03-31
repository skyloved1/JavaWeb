package main.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Dao.UsersDao.UsersDao;
import main.util.JDBCUtil.JDBCUtils;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet  extends HttpServlet {
    @java.lang.Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
      //login
String username = req.getParameter("username");
String password = req.getParameter("password");
        var conn = JDBCUtils.getConnection("root", "123456", "JDBC");
        conn.ifPresentOrElse(
                connection -> {
                    try {
                        UsersDao.findByNameAndPassword(connection,username,password).ifPresent(
                                user->{
                                    try {
                                        resp.sendRedirect("welcome.html");
                                    } catch (IOException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                        );
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                },
                () -> {
                    System.out.println("数据库连接失败");
                }
        );
    }
}
