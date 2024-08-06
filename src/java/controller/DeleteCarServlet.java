package controller;

import dao.CarDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet {
    private CarDao carDao;

    @Override
    public void init() throws ServletException {
        super.init();
        carDao = new CarDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("id"));
        try {
            carDao.deleteCar(carId);
            response.sendRedirect("carListAdmin");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error deleting car from database", e);
        }
    }
}
