package controller;

import dao.CarDao;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/carListAdmin")
public class CarListAdminServlet extends HttpServlet {
    private CarDao carDao;

    @Override
    public void init() throws ServletException {
        super.init();
        carDao = new CarDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Car> cars = carDao.getAllCars();
            request.setAttribute("cars", cars);

            System.out.println("Retrieved cars:");
            for (Car car : cars) {
                System.out.println(car.getId() + " - " + car.getBrand() + " " + car.getModel());
            }

            request.getRequestDispatcher("/carListAdmin.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error retrieving cars from database", e);
        }
    }
}
