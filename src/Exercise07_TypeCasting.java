public class Exercise07_TypeCasting {
    public static void main(String[] args) {
        // Double to int (narrowing conversion 🔽)
        double decimalValue = 9.78;
        int intValue = (int) decimalValue; // Explicit casting
        System.out.println("Double value: " + decimalValue);
        System.out.println("After casting to int: " + intValue);

        // Int to double (widening conversion 🔼)
        int wholeNumber = 42;
        double castedDouble = wholeNumber; // Implicit casting
        System.out.println("Int value: " + wholeNumber);
        System.out.println("After casting to double: " + castedDouble);
    }
}
