package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class code {

    static Scanner sc = new Scanner(System.in);

    public static void insertStudent() {

        String sql = "INSERT INTO students (name, age, course, email) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter student age: ");
            int age = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter student course: ");
            String course = sc.nextLine().trim();

            System.out.print("Enter student email: ");
            String email = sc.nextLine().trim();

            if (name.isEmpty() || course.isEmpty() || email.isEmpty()
                    || age <= 0) {
                System.out.println("Invalid input. Please try again.");
                return;
            }

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student inserted successfully!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Age must be a valid integer.");
        } catch (SQLException e) {
            System.out.println("Error inserting student: "
                    + e.getMessage());
        }
    }

    public static void displayStudents() {

        String sql = "SELECT * FROM students ORDER BY id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n========== STUDENT RECORDS ==========");

            System.out.printf("%-5s %-20s %-6s %-20s %-30s%n",
                    "ID", "NAME", "AGE", "COURSE", "EMAIL");

            System.out.println(
                    "--------------------------------------------------------------------------"
            );

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf("%-5d %-20s %-6d %-20s %-30s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email"));
            }

            if (!found) {
                System.out.println("No student records found.");
            }

            System.out.println(
                    "====================================="
            );

        } catch (SQLException e) {
            System.out.println("Error displaying students: "
                    + e.getMessage());
        }
    }

    public static void updateStudent() {

        String sql = "UPDATE students "
                   + "SET name = ?, age = ?, course = ?, email = ? "
                   + "WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter student ID to update: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter new name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter new age: ");
            int age = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter new course: ");
            String course = sc.nextLine().trim();

            System.out.print("Enter new email: ");
            String email = sc.nextLine().trim();

            if (id <= 0 || name.isEmpty() || age <= 0
                    || course.isEmpty() || email.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
                return;
            }

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("ID and age must be valid integers.");
        } catch (SQLException e) {
            System.out.println("Error updating student: "
                    + e.getMessage());
        }
    }

    public static void deleteStudent() {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter student ID to delete: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            if (id <= 0) {
                System.out.println("Invalid student ID.");
                return;
            }

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("ID must be a valid integer.");
        } catch (SQLException e) {
            System.out.println("Error deleting student: "
                    + e.getMessage());
        }
    }

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection()) {
            System.out.println("MySQL connected successfully!");
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
            return;
        }

        int choice=0;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                continue;
            }

            switch (choice) {

                case 1:
                    insertStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}