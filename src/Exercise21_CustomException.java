import java.util.Scanner;

// Custom Exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Exercise21_CustomException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or older!");
            }
            System.out.println("Welcome! You are eligible.");
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage() + " 🚫");
        } finally {
            scanner.close();
        }
    }
}
