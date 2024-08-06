package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        try {
            User user = userDao.getUser(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/editUser.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving user for editing", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phoneNum");

        try {
            User existingUser = userDao.getUser(userId);
            String currentPassword = existingUser.getPassword();

            User updatedUser = new User(userId, username, name, email, address, phoneNum, currentPassword);
            boolean updated = userDao.updateUser(updatedUser);
            if (updated) {
                response.sendRedirect("userList");
            } else {
                request.setAttribute("errorMessage", "Failed to update user");
                request.getRequestDispatcher("/editUser.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Error updating user", e);
        }
    }
}
