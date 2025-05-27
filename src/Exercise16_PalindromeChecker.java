import java.util.Scanner;

public class Exercise16_PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a string
        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();

        // Clean string: remove non-alphanumeric, convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse cleaned string
        String reversed = new StringBuilder(cleaned).reverse().toString();

        // Check palindrome
        if (cleaned.equals(reversed)) {
            System.out.println("\"" + input + "\" is a palindrome! 🎉");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome! 😢");
        }

        scanner.close();
    }
}
