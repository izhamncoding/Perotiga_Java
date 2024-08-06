package dao;

import model.Car;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDetailsDao {

    public void insertCar(Car car) throws SQLException {
        String query = "INSERT INTO cars (brand, model, car_age, availability, price_per_day, transmission, fuel_type, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getCarAge());
            statement.setInt(4, car.getAvailability());
            statement.setDouble(5, car.getPricePerDay());
            statement.setString(6, car.getTransmission());
            statement.setString(7, car.getFuelType());
            statement.setDate(8, Date.valueOf(car.getCreatedAt())); 
            statement.setDate(9, Date.valueOf(car.getUpdatedAt()));

            statement.executeUpdate();
        }
    }
}
