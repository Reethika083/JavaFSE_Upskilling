import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise28_StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 7, 20, 33, 42, 18);

        System.out.println("Original list: " + numbers);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even numbers filtered by Stream API: " + evenNumbers);
    }
}
