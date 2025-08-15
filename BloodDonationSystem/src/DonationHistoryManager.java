import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DonationHistoryManager {

    public void viewDonationHistory() {
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT d.name, d.blood_group, dh.donation_date " +
                         "FROM donors d JOIN donation_history dh ON d.id = dh.donor_id " +
                         "ORDER BY dh.donation_date DESC";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Donation History ---");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                                   ", Blood Group: " + rs.getString("blood_group") +
                                   ", Date: " + rs.getDate("donation_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewLastDonationForEachDonor() {
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT d.id, d.name, MAX(dh.donation_date) AS last_donated " +
                         "FROM donors d " +
                         "LEFT JOIN donation_history dh ON d.id = dh.donor_id " +
                         "GROUP BY d.id, d.name";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Last Donation for Each Donor ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Last Donated: " + rs.getDate("last_donated"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
