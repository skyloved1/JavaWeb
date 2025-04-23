package main.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Dao.UsersDao.UsersDao;

import java.io.IOException;

public class GetProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession(false);
        if (session != null) {
            var username = (String) session.getAttribute("username");
            UsersDao usersDao = new UsersDao();
            var user = usersDao.findByName(username);
            user.ifPresentOrElse(
                    u -> {
                        req.setAttribute("user", u);
                        try {
                            req.getRequestDispatcher("profile.jsp").forward(req, resp);
                        } catch (ServletException | IOException e) {
                            System.out.println("转发失败:" + e.getMessage());
                        }
                    },
                    () -> {
                        try {
                            resp.sendRedirect("login.html");
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
            );
        } else {
            System.out.println("session is null");
        }
    }


}
