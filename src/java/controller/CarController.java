package controller;

import dao.CarDao;
import model.Car;

import java.sql.SQLException;
import java.util.List;

public class CarController {
    private CarDao carDao;

    public CarController() {
        carDao = new CarDao();
    }

    public List<Car> getAllCars() throws SQLException {
        return carDao.getAllCars();
    }
}
