import java.sql.*;
import java.util.Scanner;

public class Admin {
    Scanner sc = new Scanner(System.in);

    public void addDonor() {
        try (Connection conn = DbConnection.getConnection()) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Blood Group: ");
            String bloodGroup = sc.nextLine();

            System.out.print("Enter Location: ");
            String location = sc.nextLine();

            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();
    
            System.out.print("Enter email: ");
            String email = sc.nextLine();
    
            System.out.print("Enter gender: ");
            String gender = sc.nextLine();

            String sql = "INSERT INTO donors(name, age, blood_group, location,phone,email,gender) VALUES (?, ?, ?, ?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, bloodGroup);
            ps.setString(4, location);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, gender);


            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Donor added successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateDonorDetails() {
        try (Connection conn = DbConnection.getConnection()) { 
        System.out.print("Enter Donor ID to update: ");
        int donorId = sc.nextInt();
        sc.nextLine(); // consume newline
    
        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new Age: ");
            int age = sc.nextInt();
            sc.nextLine(); 
    
        System.out.print("Enter new blood group: ");
        String bloodGroup = sc.nextLine();
        
        System.out.print("Enter new Location: ");
        String location = sc.nextLine();

        System.out.print("Enter new phone number: ");
        String phone = sc.nextLine();
    
        System.out.print("Enter new email: ");
        String email = sc.nextLine();
    
        System.out.print("Enter new gender: ");
        String gender = sc.nextLine();
    
        
    
        String sql = "UPDATE donors SET name = ?,age=?, blood_group = ?,location=?, phone = ?, email = ?, gender = ? WHERE id = ?";
             PreparedStatement stmt = conn.prepareStatement(sql);
    
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, bloodGroup);
            stmt.setString(4, location);
            stmt.setString(5, phone);
            stmt.setString(6, email);
            stmt.setString(7, gender);
            
            stmt.setInt(8, donorId);
    
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Donor details updated successfully.");
            } else {
                System.out.println("Donor not found with ID: " + donorId);
            }
    
        } catch (SQLException e) {
            System.out.println("Error updating donor details: " + e.getMessage());
        }
    }
    

    public void viewDonors() {
        try (Connection conn = DbConnection.getConnection()) {
            String sql = "SELECT * FROM donors";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Donor List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Age: " + rs.getInt("age")
                        + ", Blood Group: " + rs.getString("blood_group")
                        + ", Location: " + rs.getString("location"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByBloodGroupAndLocation() {
        try (Connection conn = DbConnection.getConnection()) {
            System.out.print("Enter Blood Group: ");
            String bloodGroup = sc.nextLine();

            System.out.print("Enter Location: ");
            String location = sc.nextLine();

            String sql = "SELECT * FROM donors WHERE blood_group = ? AND location = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bloodGroup);
            ps.setString(2, location);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n---Matching Donors---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Age: " + rs.getInt("age"));
            }
            if(!rs.next())
            {
                System.out.println("No donours found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logDonation() {
        try (Connection conn = DbConnection.getConnection()) {
            System.out.print("Enter Donor ID: ");
            int donorId = sc.nextInt();
            sc.nextLine(); // consume newline

            String sql = "INSERT INTO donation_history (donor_id, donation_date) VALUES (?, CURDATE())";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, donorId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Donation logged successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
