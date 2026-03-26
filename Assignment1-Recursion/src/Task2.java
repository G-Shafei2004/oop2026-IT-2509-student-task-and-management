import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Size of the array: ");
        int size = input.nextInt();
        int[] myArray = new int[size];
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            myArray[i] = input.nextInt();
        }
        System.out.print("Сколько первых элементов сложить (n)?: ");
        int n = input.nextInt();

        int result = sumArray(myArray, n);
        System.out.println("Sum of the first " + n + " elements: " + result);
    }

    public static int sumArray(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }

        int currentElement = arr[n - 1];
        int restSum = sumArray(arr, n - 1);
        return currentElement + restSum;
    }
}