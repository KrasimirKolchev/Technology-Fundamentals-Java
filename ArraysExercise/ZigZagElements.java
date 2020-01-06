package H_ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        int[] first = new int[linesCount];
        int[] second = new int[linesCount];

        for (int i = 0; i < linesCount; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            if (i % 2 == 0) {
                first[i] += numbers[0];
                second[i] += numbers[1];
            } else {
                second[i] += numbers[0];
                first[i] += numbers[1];
            }
        }
        for (int numer : first) {
            System.out.print(numer + " ");
        }
        System.out.println();
        for (int number : second) {
            System.out.print(number + " ");
        }
    }
}
