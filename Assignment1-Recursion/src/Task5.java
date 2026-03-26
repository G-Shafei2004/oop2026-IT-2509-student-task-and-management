import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        reversePrint(n, input);
    }

    public static void reversePrint(int n, Scanner input) {
        if (n == 0) {
            return;
        }
        int current = input.nextInt();
        reversePrint(n - 1, input);
        System.out.print(current + " ");
    }
}