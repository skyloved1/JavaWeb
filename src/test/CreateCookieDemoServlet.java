package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCookieDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");

        var cookie1 = new Cookie("userName", "admin");
        var cookie2 = new Cookie("userPassword", "admin");
        var lastLoginDate = new Cookie(
                "lastLoginDate",
                URLEncoder.encode(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()), StandardCharsets.UTF_8)
        );

        cookie1.setMaxAge(3600);
        cookie2.setMaxAge(3600);
        lastLoginDate.setMaxAge(3600);

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(lastLoginDate);
        resp.sendRedirect("getCookie");
    }
}