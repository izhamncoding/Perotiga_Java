package dao;

import model.User;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private String jdbcURL = "jdbc:derby://localhost:1527/perotigarental";
    private String jdbcUsername = "perotigarental";
    private String jdbcPassword = "123";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (username, name, email, address, password, user_role, phone_num, ic_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "SELECT id, username, name, email, address, password, user_role, phone_num, ic_num FROM users WHERE id = ?";
    private static final String SELECT_USER_BY_USERNAME_PASSWORD = "SELECT id, username, name, email, address, password, user_role, phone_num, ic_num FROM users WHERE username = ? AND password = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET username = ?, name = ?, email = ?, address = ?, password = ?, user_role = ?, phone_num = ?, ic_num = ? WHERE id = ?";

    public UserDao() {}

    protected Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Database connection error: Driver not found.", e);
        }
        return connection;
    }

    public void saveUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getUserRole());
            preparedStatement.setString(7, user.getPhoneNum());
            preparedStatement.setString(8, user.getIcNum());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User getUser(int id) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("password");
                int userRole = rs.getInt("user_role");
                String phoneNum = rs.getString("phone_num");
                String icNum = rs.getString("ic_num");
                user = new User(id, username, name, email, address, password, userRole, phoneNum, icNum);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("password");
                int userRole = rs.getInt("user_role");
                String phoneNum = rs.getString("phone_num");
                String icNum = rs.getString("ic_num");
                User user = new User(id, username, name, email, address, password, userRole, phoneNum, icNum);
                users.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        String sql = "UPDATE users SET username = ?, name = ?, email = ?, address = ?, phone_num = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPhoneNum());
            statement.setInt(6, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public User validate(String username, String password) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int userRole = rs.getInt("user_role");
                String phoneNum = rs.getString("phone_num");
                String icNum = rs.getString("ic_num");
                user = new User(id, username, name, email, address, password, userRole, phoneNum, icNum);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    public void deleteUserRelatedRecords(int userId) throws SQLException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            connection.setAutoCommit(false);
            
            try {
                String deleteProposalsSql = "DELETE FROM proposals WHERE user_id = ?";
                try (PreparedStatement ps = connection.prepareStatement(deleteProposalsSql)) {
                    ps.setInt(1, userId);
                    ps.executeUpdate();
                }

                String deleteUserSql = "DELETE FROM users WHERE id = ?";
                try (PreparedStatement ps = connection.prepareStatement(deleteUserSql)) {
                    ps.setInt(1, userId);
                    ps.executeUpdate();
                }

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
     
}
