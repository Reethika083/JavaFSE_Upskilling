public class Exercise30_PatternMatchingSwitch {

    public static void checkType(Object obj) {
        // Enhanced switch with pattern matching (Java 21+)
        String result = switch (obj) {
            case Integer i -> "It's an Integer with value: " + i;
            case String s -> "It's a String with value: \"" + s + "\"";
            case Double d -> "It's a Double with value: " + d;
            case null -> "It's null!";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };

        System.out.println(result);
    }

    public static void main(String[] args) {
        checkType(42);
        checkType("Hello, Java 21!");
        checkType(3.14);
        checkType(true);
        checkType(null);
    }
}
