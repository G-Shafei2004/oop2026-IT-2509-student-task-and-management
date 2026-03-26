import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        if (input.hasNextInt()) {
            int n = input.nextInt();
            input.nextLine();
            reverseStrings(n, input);
        }
    }
    public static void reverseStrings(int n, Scanner input) {
        if (n <= 0) {
            return;
        }
        String current = input.nextLine();
        reverseStrings(n - 1, input);
        System.out.println(current);
    }
}