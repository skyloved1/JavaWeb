package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GetCookieDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookies=req.getCookies();
        var writer=resp.getWriter();
        resp.setContentType("text/html,utf-8");
        for (var cookie:cookies){
            writer.println(cookie.getName()+"="+cookie.getValue()+"\n");
        }
    }
}
