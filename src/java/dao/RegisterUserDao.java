package dao;

import model.RegisterUserModel;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUserDao {
    private Connection connection;

    public RegisterUserDao() {
        try {
            connection = DatabaseUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(RegisterUserModel newUser) throws SQLException {
        String sql = "INSERT INTO users (username, name, email, address, password, user_role, phone_num, ic_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, newUser.getUsername());
            ps.setString(2, newUser.getName());
            ps.setString(3, newUser.getEmail());
            ps.setString(4, newUser.getAddress());
            ps.setString(5, newUser.getPassword());
            ps.setInt(6, newUser.getUserRole());
            ps.setString(7, newUser.getPhoneNum());
            ps.setString(8, newUser.getIcNum());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
    
}
