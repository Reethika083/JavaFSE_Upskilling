import java.util.Scanner;

public class Exercise04_LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Apply leap year logic 💡
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a LEAP YEAR! 🎉🗓️");
        } else {
            System.out.println(year + " is NOT a leap year ❌");
        }

        scanner.close();
    }
}
