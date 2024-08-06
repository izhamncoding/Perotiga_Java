package controller;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && (user.getUserRole() == 2 || user.getUserRole() == 3)) {
            try {
                List<User> users = userDao.getAllUsers();
                request.setAttribute("users", users);
                request.getRequestDispatcher("/userList.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new ServletException("Error retrieving users from database", e);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
