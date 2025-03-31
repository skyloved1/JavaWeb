package main.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Dao.UsersDao.UsersDao;
import main.model.User;
import main.util.JDBCUtil.JDBCUtils;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class RegisterServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String date = req.getParameter("birthday");
        try {
            if (username == null || password == null || email == null || date == null) {
                throw new InvalidParameterException("参数不能为空");
            }
        } catch (Exception e) {
            System.out.println("注册失败"+e.getMessage());
            System.out.println("将跳转到注册页面");
            resp.sendRedirect("register.html");
        }
        JDBCUtils.getConnection("root","123456","JDBC").ifPresent(
                connection -> {
                     User user = new User(username,password,email,date);
                    try {
                        UsersDao.insert(connection,user);
                        resp.sendRedirect("login.html");
                    } catch (Exception e) {
                        System.out.println("注册失败"+e.getMessage());
                    }
                }
        );
    }
}
