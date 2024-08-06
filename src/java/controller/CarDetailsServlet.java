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

@WebServlet("/viewCarDetails")
public class CarDetailsServlet extends HttpServlet {
    private CarDao carDao;

    @Override
    public void init() throws ServletException {
        super.init();
        carDao = new CarDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String carIdStr = request.getParameter("id");
        if (carIdStr == null || carIdStr.isEmpty()) {
            response.sendRedirect("carListUser.jsp");
            return;
        }

        try {
            int carId = Integer.parseInt(carIdStr);
            Car car = carDao.getCarByID(carId);

            if (car != null) {
                System.out.println("Car Details:");
                System.out.println("Brand: " + car.getBrand());
                System.out.println("Model: " + car.getModel());
                System.out.println("Transmission: " + car.getTransmission());
                System.out.println("Fuel Type: " + car.getFuelType());
                System.out.println("Price per Day: " + car.getPricePerDay());

                HttpSession session = request.getSession(false);
                if (session != null) {
                    User user = (User) session.getAttribute("user");

                    request.setAttribute("user", user);
                    request.setAttribute("car", car);

                    request.getRequestDispatcher("/viewCarDetails.jsp").forward(request, response);
                } else {
                    response.sendRedirect("login.jsp");
                }
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
}
