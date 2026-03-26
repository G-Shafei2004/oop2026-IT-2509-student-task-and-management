import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String input = sc.next();
            permute(input.toCharArray(), 0, input.length() - 1);
        }
    }

    static void permute(char[] chars, int left, int right) {
        if (left == right) {
            System.out.println(new String(chars));
            return;
        }

        for (int i = left; i <= right; i++) {
            swap(chars, left, i);
            permute(chars, left + 1, right);
            swap(chars, left, i);
        }
    }

    static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}