import java.util.Scanner;

public class Exercise20_TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the numerator (integer): ");
        int numerator = scanner.nextInt();

        System.out.print("Enter the denominator (integer): ");
        int denominator = scanner.nextInt();

        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Oops! Division by zero is not allowed. 🚫");
        }

        scanner.close();
    }
}
