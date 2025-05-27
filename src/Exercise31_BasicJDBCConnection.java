import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise31_BasicJDBCConnection {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db"; // SQLite DB file
        // For MySQL, use: jdbc:mysql://localhost:3306/yourdbname

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                String query = "SELECT id, name, age FROM students";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                System.out.println("Student List:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");

                    System.out.println(id + ": " + name + " (" + age + " years old)");
                }
            }
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}
