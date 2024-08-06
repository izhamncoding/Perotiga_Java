package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import dao.UserDao;

@WebServlet("/auth")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.validate(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userRole", user.getUserRole());

            int userRole = user.getUserRole();
            if (userRole == 2 || userRole == 3) {
                response.sendRedirect("adminHome.jsp");
            } else if (userRole == 1) {
                response.sendRedirect("userHome.jsp");
            } else {
                response.sendRedirect("login.jsp?error=true");
            }
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
