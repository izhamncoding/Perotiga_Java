package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDao;
import model.User;

@WebServlet("/adminHome")
public class AdminHomeServlet extends HttpServlet {
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

        if (user != null && (user.getUserRole() == 1 || user.getUserRole() == 2)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/proposalListAdmin").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
