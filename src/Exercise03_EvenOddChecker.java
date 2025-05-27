import java.util.Scanner;

public class Exercise03_EvenOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter an integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Check if even or odd using %
        if (number % 2 == 0) {
            System.out.println(number + " is EVEN 🎯");
        } else {
            System.out.println(number + " is ODD 🌀");
        }

        scanner.close();
    }
}
