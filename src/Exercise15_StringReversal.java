import java.util.Scanner;

public class Exercise15_StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a string
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        // Using StringBuilder to reverse the string
        String reversed = new StringBuilder(input).reverse().toString();

        // Display reversed string
        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }
}
