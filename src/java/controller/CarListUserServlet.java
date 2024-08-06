package controller;

import dao.CarDao;
import model.Car;
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

@WebServlet("/carListUser")
public class CarListUserServlet extends HttpServlet {
    private CarDao carDao;

    @Override
    public void init() throws ServletException {
        super.init();
        carDao = new CarDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.getUserRole() == 1) {
            try {
                List<Car> cars = carDao.getAllCars();
                request.setAttribute("cars", cars);
                request.getRequestDispatcher("/carListUser.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new ServletException("Error retrieving cars from database", e);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
