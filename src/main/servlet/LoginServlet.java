package main.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Dao.UsersDao.UsersDao;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @java.lang.Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //login post参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        var usersDao = new UsersDao();
        try{
            if (usersDao.findByNameAndPassword(username, password).isPresent()) {
//                if(!hasLogin(req)) {
//                    addCookies(resp, username, password);
//                }
                resp.sendRedirect("welcome.html");
            } else {
                req.getRequestDispatcher("login.html").forward(req, resp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addCookies( HttpServletResponse resp, String username, String password) {
        var userNameCookie=new Cookie("userName", URLEncoder.encode(username, StandardCharsets.UTF_8));
        var userPasswordCookie=new Cookie("userPassword", URLEncoder.encode(password, StandardCharsets.UTF_8));
        userNameCookie.setMaxAge(3600);
        userPasswordCookie.setMaxAge(3600);
        resp.addCookie(userNameCookie);
        resp.addCookie(userPasswordCookie);
    }
    private  boolean hasLogin(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userName".equals(cookie.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

}
