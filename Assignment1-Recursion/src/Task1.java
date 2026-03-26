import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = input.nextInt();

        int total = sumSquares(n);
        System.out.println("Result: " + total);
    }


    public static int sumSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int square = n * n;
        int sumOfPrevious = sumSquares(n - 1);
        int total = square + sumOfPrevious;
        return total;
    }
}