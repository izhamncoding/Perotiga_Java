package controller;

import dao.RegisterUserDao;
import model.RegisterUserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private RegisterUserDao userDao;

    public void init() {
        userDao = new RegisterUserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        int userRole = 1;
        String phoneNum = request.getParameter("phone_num");
        String icNum = request.getParameter("ic_num");

 
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Password: " + password);
        System.out.println("UserRole: " + userRole);
        System.out.println("PhoneNum: " + phoneNum);
        System.out.println("ICNum: " + icNum);

        RegisterUserModel newUser = new RegisterUserModel(0, username, name, email, address, password, userRole, phoneNum, icNum);

        try {
            userDao.saveUser(newUser);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error saving user", e);
        }
    }

    public void destroy() {
    }
}
