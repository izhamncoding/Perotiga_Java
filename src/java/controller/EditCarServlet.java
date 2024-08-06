package controller;

import dao.CarDao;
import model.Car;
import util.DatabaseUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editCar")
public class EditCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CarDao carDao;

    @Override
    public void init() throws ServletException {
        super.init();
        carDao = new CarDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Car car = carDao.getCarByID(id);
            if (car != null) {
                request.setAttribute("car", car);
                request.getRequestDispatcher("/editCar.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("editError", "Car not found");
                response.sendRedirect(request.getContextPath() + "/carListAdmin");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error when retrieving car for editing", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        int carAge = Integer.parseInt(request.getParameter("carAge"));
        int availability = Integer.parseInt(request.getParameter("availability"));
        double pricePerDay = Double.parseDouble(request.getParameter("pricePerDay"));
        String transmission = request.getParameter("transmission");
        String fuelType = request.getParameter("fuelType");

        try {
            Car existingCar = carDao.getCarByID(id);

            existingCar.setBrand(brand);
            existingCar.setModel(model);
            existingCar.setCarAge(carAge);
            existingCar.setAvailability(availability);
            existingCar.setPricePerDay(pricePerDay);
            existingCar.setTransmission(transmission);
            existingCar.setFuelType(fuelType);

            boolean updated = carDao.updateCar(existingCar);

            if (updated) {
                HttpSession session = request.getSession();
                session.setAttribute("editSuccess", "Car details successfully updated");
                response.sendRedirect(request.getContextPath() + "/carListAdmin");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("editError", "Failed to update car details");
                response.sendRedirect(request.getContextPath() + "/editCar?id=" + id);
            }
        } catch (SQLException e) {
            throw new ServletException("Database error when updating car", e);
        }
    }
}
