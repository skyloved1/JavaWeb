package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CreateCookieDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookie1=new Cookie("userName","admin");
        var cookie2 = new Cookie("userPassword", "admin");
        cookie1.setMaxAge(3600);
        cookie2.setMaxAge(3600);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

    }
}
