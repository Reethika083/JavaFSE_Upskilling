import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Exercise32_StudentDAO {

    private static final String URL = "jdbc:sqlite:students.db"; // Change if MySQL
    // For MySQL: jdbc:mysql://localhost:3306/yourdbname
    // Add username/password if needed

    // Insert a new student
    public void insertStudent(String name, int age) {
        String sql = "INSERT INTO students(name, age) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) inserted.");

        } catch (Exception e) {
            System.out.println("Insert error: " + e.getMessage());
        }
    }

    // Update student age by id
    public void updateStudentAge(int id, int newAge) {
        String sql = "UPDATE students SET age = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) updated.");

        } catch (Exception e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }

    // Testing insert and update
    public static void main(String[] args) {
        Exercise32_StudentDAO dao = new Exercise32_StudentDAO();

        // Insert new students
        dao.insertStudent("Diana", 23);
        dao.insertStudent("Ethan", 20);

        // Update age of student with id 1
        dao.updateStudentAge(1, 22);
    }
}
