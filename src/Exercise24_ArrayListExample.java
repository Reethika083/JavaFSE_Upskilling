import java.util.ArrayList;
import java.util.Scanner;

public class Exercise24_ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student names (type 'done' to finish):");

        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }
            studentNames.add(name);
        }

        System.out.println("\nList of students:");
        for (String student : studentNames) {
            System.out.println(student);
        }

        scanner.close();
    }
}
