import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n: ");

        if (input.hasNextInt()) {
            int n = input.nextInt();
            if (n > 0) {
                System.out.println("The sum is: " + sum(n));
            } else {
                System.out.println("Please enter a positive integer.");
            }
        }
    }
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
}