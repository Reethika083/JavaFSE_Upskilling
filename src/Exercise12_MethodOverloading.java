public class Exercise12_MethodOverloading {

    // Add two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Add two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        // Call each method and display results
        System.out.println("add(5, 10) = " + add(5, 10)); // 15 (int)
        System.out.println("add(3.5, 2.5) = " + add(3.5, 2.5)); // 6.0 (double)
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3)); // 6 (int)
    }
}
