package ExceptionHandling;

public class ExceptionHandlingDemo {

    // 1. Basic try-catch
    public static void basicTryCatch() {
        try {
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }
    }

    // 2. Multiple catch blocks
    public static void multipleCatch() {
        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException
            int[] arr = new int[5];
            arr[10] = 50; // ArrayIndexOutOfBoundsException
        } catch (NullPointerException e) {
            System.out.println("Null pointer: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error: " + e.getMessage());
        }
    }

    // 3. try-catch-finally
    public static void tryCatchFinally() {
        try {
            int data = 50 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            System.out.println("Finally block always executes");
        }
    }

    // 4. throw keyword
    public static void validateAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote");
        } else {
            System.out.println("Eligible to vote");
        }
    }

    // 5. throws keyword
    public static void readFile() throws java.io.IOException {
        throw new java.io.IOException("File not found");
    }

    // 6. Custom Exception
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        System.out.println("Valid age: " + age);
    }

    // 7. try-with-resources (AutoCloseable)
    public static void tryWithResources() {
        try (java.io.FileReader fr = new java.io.FileReader("test.txt")) {
            System.out.println("File opened");
        } catch (java.io.IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // 8. Nested try-catch
    public static void nestedTry() {
        try {
            try {
                int[] arr = {1, 2, 3};
                System.out.println(arr[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: " + e);
            }
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: " + e);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Basic Try-Catch ===");
        basicTryCatch();

        System.out.println("\n=== 2. Multiple Catch ===");
        multipleCatch();

        System.out.println("\n=== 3. Try-Catch-Finally ===");
        tryCatchFinally();

        System.out.println("\n=== 4. Throw Keyword ===");
        try {
            validateAge(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 5. Throws Keyword ===");
        try {
            readFile();
        } catch (java.io.IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n=== 6. Custom Exception ===");
        try {
            checkAge(200);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 7. Try-With-Resources ===");
        tryWithResources();

        System.out.println("\n=== 8. Nested Try ===");
        nestedTry();
    }
}
