package controller;

import dao.CarDetailsDao;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet {
    private CarDetailsDao carDetailsDao;

    @Override
    public void init() throws ServletException {
        carDetailsDao = new CarDetailsDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        int carAge = Integer.parseInt(request.getParameter("carAge"));
        int availability = Integer.parseInt(request.getParameter("availability"));
        double pricePerDay = Double.parseDouble(request.getParameter("pricePerDay"));
        String transmission = request.getParameter("transmission");
        String fuelType = request.getParameter("fuelType");

        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setCarAge(carAge);
        car.setAvailability(availability);
        car.setPricePerDay(pricePerDay);
        car.setTransmission(transmission);
        car.setFuelType(fuelType);

        LocalDate now = LocalDate.now();
        car.setCreatedAt(now);
        car.setUpdatedAt(now);

        try {
            carDetailsDao.insertCar(car);
            response.sendRedirect("carListAdmin");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error adding car: " + e.getMessage());
            request.getRequestDispatcher("error").forward(request, response);
        }
    }
}
