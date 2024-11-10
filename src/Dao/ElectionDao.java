package Dao;

import Model.Election;
import java.sql.*;
import java.util.*;

public class ElectionDao {
    private Connection conn;

    public ElectionDao() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_voting_system", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all elections
    public List<Election> getAllElections() {
        List<Election> elections = new ArrayList<>();
        String sql = "SELECT * FROM elections";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                elections.add(new Election(
                        rs.getInt("election_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return elections;
    }
}
