import java.util.List;

/**
 * Examples of lower bounded wildcards in Java generics.
 */
public class GenericsExample {
    /**
     * Adds Number values to any list whose element type is Number or a supertype
     * of Number (such as Object).
     */
    public static void addNumbers(List<? super Number> values) {
        values.add(Integer.valueOf(10));
        values.add(Double.valueOf(20.5));
        values.add(Float.valueOf(3.14f));
    }

    /**
     * Values read from this list are safely treated as Object because its
     * actual element type may be Number or Object.
     */
    public static void printNumbers(List<? super Number> values) {
        for (Object value : values) {
            System.out.println(value);
        }
    }

    /**
     * A simple upper bounded wildcard example. Values can be read as Number,
     * but adding a particular Number subtype is not safe for every possible
     * List<? extends Number>.
     */
    public static double sumNumbers(List<? extends Number> values) {
        double sum = 0.0;
        for (Number value : values) {
            sum += value.doubleValue();
        }
        return sum;
    }
}
