public class Calculator {
    public static void main() {

    }

    public static double multiply(double a, double b) {
        return a*b;
    }

    public static double divide(double a, double b) {
        if(b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return a/b;
    }

    public static double divide_WithoutExcetion(double a, double b) {
        return a / b;
    }

    public static double plus(double a, double b) {
        return a + b;
    }

    public static double minus(double a, double b) {
        return a - b;
    }

    public static double square(double a) {
        return a*a;
    }

    public static double sqRoot(double a) {
        if(a < 0) {
            throw new IllegalArgumentException("Square root cannot be found for negative numbers");
        }
        return Math.sqrt(a);
    }
}
