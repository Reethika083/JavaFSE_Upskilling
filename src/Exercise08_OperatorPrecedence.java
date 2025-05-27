public class Exercise08_OperatorPrecedence {
    public static void main(String[] args) {
        // Expression 1
        int result1 = 10 + 5 * 2; // Multiplication happens first
        System.out.println("10 + 5 * 2 = " + result1); // 10 + 10 = 20

        // Expression 2
        int result2 = (10 + 5) * 2; // Parentheses change the order
        System.out.println("(10 + 5) * 2 = " + result2); // 15 * 2 = 30

        // Expression 3
        int result3 = 100 / 10 + 5 - 3; // Left to right: 10 + 5 - 3 = 12
        System.out.println("100 / 10 + 5 - 3 = " + result3);

        // Expression 4
        int result4 = 8 + 2 * 3 - 4 / 2; // 8 + 6 - 2 = 12
        System.out.println("8 + 2 * 3 - 4 / 2 = " + result4);
    }
}
