import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        fillSpiral(matrix, 0, 0, 1, n);
        printMatrix(matrix, 0, 0, n);
    }

    static void fillSpiral(int[][] mat, int row, int col, int num, int size) {
        if (size <= 0) return;
        if (size == 1) {
            mat[row][col] = num;
            return;
        }
        //right
        for (int i = 0; i < size - 1; i++) mat[row][col + i] = num++;
        // Down
        for (int i = 0; i < size - 1; i++) mat[row + i][col + size - 1] = num++;
        // Left
        for (int i = 0; i < size - 1; i++) mat[row + size - 1][col + size - 1 - i] = num++;
        // 4. Up
        for (int i = 0; i < size - 1; i++) mat[row + size - 1 - i][col] = num++;

        fillSpiral(mat, row + 1, col + 1, num, size - 2);
    }

    static void printMatrix(int[][] mat, int r, int c, int n) {
        if (r == n) return;
        System.out.printf("%-3d", mat[r][c]);

        if (c == n - 1) {
            System.out.println();
            printMatrix(mat, r + 1, 0, n);
        } else {
            printMatrix(mat, r, c + 1, n);
        }
    }
}