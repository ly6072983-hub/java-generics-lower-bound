import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for the lower bounded wildcard example.
 * Student: Yousef Ayman (يوسف أيمن)
 */
public class Main {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        GenericsExample.addNumbers(numbers);
        GenericsExample.printNumbers(numbers);

        // List<Object> is also accepted because Number is a subtype of Object.
        List<Object> objects = new ArrayList<>();
        GenericsExample.addNumbers(objects);
        GenericsExample.printNumbers(objects);
    }
}
