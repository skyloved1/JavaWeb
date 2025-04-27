package main.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Dao.UsersDao.UsersDao;
import main.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var usersDao = new UsersDao();
        ArrayList<User> users = null;
        try {
            users = usersDao.findAll();
        } catch (SQLException e) {
            resp.getWriter().println(e.getMessage());
        }
        req.setAttribute("allUsers", users);
        req.getRequestDispatcher("allUsers.jsp").forward(req, resp);
    }
}
