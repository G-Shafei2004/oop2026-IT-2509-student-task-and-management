import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] sequence = new int[n];
            generate(0, n, k, sequence);
        }
    }

    static void generate(int index, int n, int k, int[] seq) {
        if (index == n) {
            printArray(seq, 0);
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            seq[index] = i;
            generate(index + 1, n, k, seq);
        }
    }

    static void printArray(int[] seq, int i) {
        if (i == seq.length) return;
        System.out.print(seq[i] + (i == seq.length - 1 ? "" : " "));
        printArray(seq, i + 1);
    }
}