package dao;

import model.Car;
import model.Proposal;
import model.User;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProposalDao {

    public List<Proposal> getAllProposals() throws SQLException {
        List<Proposal> proposals = new ArrayList<>();
        String query = "SELECT p.id, p.user_id, p.car_id, p.rental_date, p.status, p.created_at, p.updated_at, " +
                       "u.name as user_name, u.email as user_email, " +
                       "c.brand as car_brand, c.model as car_model, c.price_per_day as car_price_per_day " +
                       "FROM proposals p " +
                       "JOIN users u ON p.user_id = u.id " +
                       "JOIN cars c ON p.car_id = c.id";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Proposal proposal = extractProposalFromResultSet(rs);
                proposals.add(proposal);
            }
        } catch (SQLException ex) {
            throw new SQLException("Error fetching proposals", ex);
        }

        return proposals;
    }

    public List<Proposal> getProposalsByUserId(int userId) throws SQLException {
        List<Proposal> proposals = new ArrayList<>();
        String query = "SELECT p.id, p.user_id, p.car_id, p.rental_date, p.status, p.created_at, p.updated_at, " +
                       "u.name as user_name, u.email as user_email, " +
                       "c.brand as car_brand, c.model as car_model, c.price_per_day as car_price_per_day " +
                       "FROM proposals p " +
                       "JOIN users u ON p.user_id = u.id " +
                       "JOIN cars c ON p.car_id = c.id " +
                       "WHERE p.user_id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Proposal proposal = extractProposalFromResultSet(rs);
                    proposals.add(proposal);
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Error fetching proposals by user ID", ex);
        }

        return proposals;
    }

    public Proposal getProposalById(int proposalId) throws SQLException {
        Proposal proposal = null;
        String query = "SELECT p.id, p.user_id, p.car_id, p.rental_date, p.status, p.created_at, p.updated_at, " +
                       "u.name as user_name, u.email as user_email, " +
                       "c.brand as car_brand, c.model as car_model, c.price_per_day as car_price_per_day " +
                       "FROM proposals p " +
                       "JOIN users u ON p.user_id = u.id " +
                       "JOIN cars c ON p.car_id = c.id " +
                       "WHERE p.id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, proposalId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    proposal = extractProposalFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Error fetching proposal by ID", ex);
        }

        return proposal;
    }

    public void updateProposal(Proposal proposal) throws SQLException {
        String query = "UPDATE proposals SET status = ?, updated_at = ? WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, proposal.getStatus());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(proposal.getUpdatedAt()));
            stmt.setInt(3, proposal.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error updating proposal status", ex);
        }
    }

    public void deleteProposalById(int proposalId) throws SQLException {
        String query = "DELETE FROM proposals WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, proposalId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Error deleting proposal", ex);
        }
    }

    private Proposal extractProposalFromResultSet(ResultSet rs) throws SQLException {
        Proposal proposal = new Proposal();
        proposal.setId(rs.getInt("id"));
        proposal.setUserId(rs.getInt("user_id"));
        proposal.setCarId(rs.getInt("car_id"));
        proposal.setRentalDate(rs.getDate("rental_date").toLocalDate());
        proposal.setStatus(rs.getString("status"));
        proposal.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        proposal.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

        User user = new User();
        user.setName(rs.getString("user_name"));
        user.setEmail(rs.getString("user_email"));
        proposal.setUser(user);

        Car car = new Car();
        car.setBrand(rs.getString("car_brand"));
        car.setModel(rs.getString("car_model"));
        car.setPricePerDay(rs.getDouble("car_price_per_day"));
        proposal.setCar(car);

        return proposal;
    }
}
