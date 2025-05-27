import java.util.Scanner;

public class Exercise09_GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for marks out of 100
        System.out.print("Enter your marks (out of 100): ");
        int marks = scanner.nextInt();
        char grade;

        // Assign grade based on marks using if-else ladder 📊
        if (marks >= 90 && marks <= 100) {
            grade = 'A';
        } else if (marks >= 80 && marks < 90) {
            grade = 'B';
        } else if (marks >= 70 && marks < 80) {
            grade = 'C';
        } else if (marks >= 60 && marks < 70) {
            grade = 'D';
        } else if (marks >= 0 && marks < 60) {
            grade = 'F';
        } else {
            System.out.println("Invalid marks entered 😅");
            scanner.close();
            return;
        }

        // Display the grade
        System.out.println("Your grade is: " + grade);

        scanner.close();
    }
}
