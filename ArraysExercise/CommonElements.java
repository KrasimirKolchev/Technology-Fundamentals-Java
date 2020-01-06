package H_ArraysExercise;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (String word : secondArray) {
            for (int i = 0; i < firstArray.length; i++) {
                if (word.equals(firstArray[i])) {
                    System.out.print(word + " ");
                }
            }
        }
    }
}
