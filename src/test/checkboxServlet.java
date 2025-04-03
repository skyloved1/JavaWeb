package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class checkboxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
        var res=req.getParameterMap();
       var sex= res.get("sex");
       var hobbies= res.get("hobby");
        var writer = resp.getWriter();
        writer.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                """);
        writer.println("<p>"+"hobbies are");
        for (var hobby : hobbies) {
            writer.print(  hobby+"&nbsp");
        }
        writer.println("</p>");
        writer.println("<p>"+"sex is "+ sex[0] + "</p>");
        writer.println("</body></html>");


    }
}
