package dao;

import model.ProposalWithCarDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseUtil;

public class ProposalWithCarDao {
    public List<ProposalWithCarDetails> getProposalsWithCarDetailsByUserId(int userId) throws SQLException {
        List<ProposalWithCarDetails> proposals = new ArrayList<>();
        String sql = "SELECT p.id, p.car_id, p.rental_date, p.status, p.created_at, p.updated_at, " +
                     "c.brand, c.model " +
                     "FROM proposals p " +
                     "JOIN cars c ON p.car_id = c.id " +
                     "WHERE p.user_id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ProposalWithCarDetails proposal = new ProposalWithCarDetails();
                    proposal.setId(resultSet.getInt("id"));
                    proposal.setCarId(resultSet.getInt("car_id"));
                    
                    // Convert Timestamp to LocalDateTime
                    Timestamp rentalDate = resultSet.getTimestamp("rental_date");
                    if (rentalDate != null) {
                        proposal.setRentalDate(rentalDate.toLocalDateTime());
                    }

                    proposal.setStatus(resultSet.getString("status"));
                    
                    Timestamp createdAt = resultSet.getTimestamp("created_at");
                    if (createdAt != null) {
                        proposal.setCreatedAt(createdAt.toLocalDateTime());
                    }

                    Timestamp updatedAt = resultSet.getTimestamp("updated_at");
                    if (updatedAt != null) {
                        proposal.setUpdatedAt(updatedAt.toLocalDateTime());
                    }

                    proposal.setCarBrand(resultSet.getString("brand"));
                    proposal.setCarModel(resultSet.getString("model"));
                    proposals.add(proposal);
                }
            }
        }
        return proposals;
    }
}
