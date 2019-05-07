package H_ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int counter = 0;
        String sequence = "";


        for (int i = 0; i < numbers.length; i++) {
            int currentCounter = 0;
            String currentSequence = "";

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] == numbers[j]) {
                    currentCounter++;
                    currentSequence += numbers[j] + " ";
                } else {
                    break;
                }
            }
            if (currentCounter > counter) {
                counter = currentCounter;
                sequence = currentSequence + numbers[i];
            }
        }
        if (sequence.equals("")) {
            System.out.print(numbers[0]);
        }
        System.out.println(sequence);
    }
}
