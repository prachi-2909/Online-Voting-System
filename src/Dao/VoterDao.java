package Dao;

import Model.Vote;
import Model.Voter;
import java.sql.*;

public class VoterDao {
    private Connection conn;

    public VoterDao() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_voting_system", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Register voter
    public boolean registerVoter(Voter voter) {
        String sql = "INSERT INTO voters (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, voter.getName());
            stmt.setString(2, voter.getEmail());
            stmt.setString(3, voter.getPassword());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Authenticate voter
    public Voter authenticateVoter(String email, String password) {
        String sql = "SELECT * FROM voters WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Voter(rs.getInt("voter_id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean saveVote(Vote vote) {
        return true;

    }
}
