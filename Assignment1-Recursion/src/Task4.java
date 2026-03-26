import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter b: ");
        int b = input.nextInt();
        System.out.print("Enter n: ");
        int n = input.nextInt();

        if (n < 0) {
            System.out.println("Error! Power n must be >= 0");
        } else {
            int result = sumPowers(b, n);
            System.out.println("Result: " + result);
        }
    }

    public static int sumPowers(int b, int n) {
        if (n == 0) {
            return 1;
        }

        int currentPower = (int) Math.pow(b, n);
        int sumOfRest = sumPowers(b, n - 1);
        int total = currentPower + sumOfRest;

        return total;
    }
}