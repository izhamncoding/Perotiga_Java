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

@WebServlet("/bookCar")
public class BookCarServlet extends HttpServlet {
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

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String carIdStr = request.getParameter("id");
        if (carIdStr == null || carIdStr.isEmpty()) {
            response.sendRedirect("carListUser.jsp");
            return;
        }

        try {
            int carId = Integer.parseInt(carIdStr);
            Car car = carDao.getCarByID(carId);
            if (car != null) {
                request.setAttribute("user", user);
                request.setAttribute("car", car);
                request.getRequestDispatcher("/bookCar.jsp").forward(request, response);
            } else {
                response.sendRedirect("carListUser.jsp");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("carListUser.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("carListUser.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String carIdStr = request.getParameter("carId");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        if (carIdStr == null || carIdStr.isEmpty() || startDateStr == null || startDateStr.isEmpty() ||
                endDateStr == null || endDateStr.isEmpty()) {
            response.sendRedirect("carListUser.jsp");
            return;
        }

        try {
            int carId = Integer.parseInt(carIdStr);
            response.sendRedirect("confirmBooking.jsp");
        } catch (NumberFormatException e) {
            response.sendRedirect("carListUser.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("carListUser.jsp");
        }
    }
}
