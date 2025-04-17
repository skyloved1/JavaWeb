package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class GetCookieDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8"); // 修复内容类型

        var cookies = req.getCookies();
        var writer = resp.getWriter();
        int hasLogin = -1;
        int index = 0;
        for (var cookie : cookies) {
            if (cookie.getName().equals("lastLoginDate")) {
                hasLogin = index;
                continue;
            }
            writer.println(cookie.getName() + "=" + cookie.getValue() + "\n");
            index++;
        }
        if (hasLogin == -1) {
            writer.println("没有登录过");
        } else {
            writer.println("欢迎回来,上次登录时间：" + URLDecoder.decode(cookies[hasLogin].getValue(), StandardCharsets.UTF_8));
        }
    }
}