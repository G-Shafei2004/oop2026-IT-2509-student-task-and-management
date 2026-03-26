public class Task10 {
    public static void main(String[] args) {
        testPowerOfTwo(0, 9);
        System.out.println("--------------------");
        testEven(10, 18);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }
    public static void testPowerOfTwo(int current, int max) {
        if (current > max) return;
        printResult(current);
        testPowerOfTwo(current + 1, max);
    }

    public static void testEven(int current, int max) {
        if (current > max) return;
        printResult(current);
        testEven(current + 2, max);
    }

    public static void printResult(int n) {
        if (isPowerOfTwo(n)) {
            System.out.println(n + " is a power of two");
        } else {
            System.out.println(n + " is not a power of two");
        }
    }
}