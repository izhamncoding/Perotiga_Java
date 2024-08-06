package dao;

import model.Car;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class CarDao {
    private Connection connection;

    public CarDao() {
        try {
            connection = DatabaseUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getAllCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int carAge = resultSet.getInt("car_age");
                int availability = resultSet.getInt("availability");

                Car car = new Car(id, brand, model, carAge, availability);
                cars.add(car);
            }
        }
        return cars;
    }

    public Car getCarByID(int id) throws SQLException {
        String query = "SELECT * FROM cars WHERE id = ?";
        Car car = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                car = new Car();
                car.setId(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setCarAge(rs.getInt("car_age"));
                car.setAvailability(rs.getInt("availability"));
                car.setCarImagePath(rs.getString("car_image_path"));
                car.setPricePerDay(rs.getDouble("price_per_day"));
                car.setTransmission(rs.getString("transmission"));
                car.setFuelType(rs.getString("fuel_type"));

                Timestamp createdAt = rs.getTimestamp("created_at");
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                if (createdAt != null) {
                    car.setCreatedAt(createdAt.toLocalDateTime().toLocalDate());
                }
                if (updatedAt != null) {
                    car.setUpdatedAt(updatedAt.toLocalDateTime().toLocalDate());
                }
            }

        } catch (SQLException ex) {
            throw new SQLException("Error fetching car with ID: " + id, ex);
        }

        return car;
    }

    public String getCarModelById(int id) throws SQLException {
        String query = "SELECT model FROM cars WHERE id = ?";
        String carModel = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                carModel = rs.getString("model");
            }

        } catch (SQLException ex) {
            throw new SQLException("Error fetching car model with ID: " + id, ex);
        }

        return carModel;
    }

    public String getCarNameById(int id) throws SQLException {
        String query = "SELECT brand, model FROM cars WHERE id = ?";
        String carName = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                carName = brand + " " + model;
            }

        } catch (SQLException ex) {
            throw new SQLException("Error fetching car name with ID: " + id, ex);
        }

        return carName;
    }

    public void deleteCar(int carId) throws SQLException {
        String sql = "DELETE FROM cars WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, carId);
            statement.executeUpdate();
        }
    }

    public boolean updateCar(Car car) throws SQLException {
        String sql = "UPDATE cars SET brand=?, model=?, car_age=?, availability=?, price_per_day=?, transmission=?, fuel_type=?, updated_at=? WHERE id=?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, car.getBrand());
            stmt.setString(2, car.getModel());
            stmt.setInt(3, car.getCarAge());
            stmt.setInt(4, car.getAvailability());
            stmt.setDouble(5, car.getPricePerDay());
            stmt.setString(6, car.getTransmission());
            stmt.setString(7, car.getFuelType());
            stmt.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setInt(9, car.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException ex) {
            throw new SQLException("Error updating car with ID: " + car.getId(), ex);
        }
    }
    
    
    
    
}
