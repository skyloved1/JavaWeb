package main.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Dao.UsersDao.UsersDao;
import main.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String date = req.getParameter("birthday");

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || date.isEmpty()) {
            System.out.println("注册失败,参数为空");
            System.out.println("将跳转到注册页面");
            resp.sendRedirect("register.html");
            return;
        }

        try {
            User user = new User(username, password, email, date);
            UsersDao usersDao = new UsersDao();
            usersDao.insert(user);
            resp.sendRedirect("login.html");
        } catch (ParseException e) {
            System.out.println("注册失败" + e.getMessage() + "日期格式错误");
        } catch (SQLException e) {
            System.out.println("注册失败" + e.getMessage() + "数据库错误");
        }

    }
}
