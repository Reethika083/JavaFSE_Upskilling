import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercise33_TransactionHandling {

    private static final String URL = "jdbc:sqlite:bank.db"; // Change if MySQL

    public void transferMoney(int fromId, int toId, double amount) {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL)) {
            conn.setAutoCommit(false); // Start transaction

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                    PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {

                // Debit from sender
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                int debitRows = debitStmt.executeUpdate();

                // Credit to receiver
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                int creditRows = creditStmt.executeUpdate();

                if (debitRows == 1 && creditRows == 1) {
                    conn.commit();
                    System.out.println("Transaction successful! $" + amount + " transferred.");
                } else {
                    conn.rollback();
                    System.out.println("Transaction failed! Rolled back.");
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Exception! Transaction rolled back: " + e.getMessage());
            } finally {
                conn.setAutoCommit(true); // Restore auto-commit
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Exercise33_TransactionHandling bank = new Exercise33_TransactionHandling();

        // Transfer $200 from Alice (id=1) to Bob (id=2)
        bank.transferMoney(1, 2, 200);
    }
}
