package main.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Dao.UsersDao.UsersDao;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @java.lang.Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //login
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        var usersDao = new UsersDao();
//        try {
//            usersDao.findByNameAndPass word(username, password).ifPresentOrElse(user -> {
//                try {
//                    resp.sendRedirect("welcome.html");
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                }
//            },
//                    () -> {
//                        try {
//                            resp.sendRedirect("login.html");
//                            System.out.println("用户名或密码错误");
//                        }
//                        catch (IOException e) {
//                            System.out.println("跳转失败"+e.getMessage());
//                        }
//                    });
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        //使用请求转发
        try{
            if (usersDao.findByNameAndPassword(username, password).isPresent()) {
                req.setAttribute("username", username);
                req.getRequestDispatcher("welcome.html").forward(req, resp);
            } else {
                req.getRequestDispatcher("login.html").forward(req, resp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
