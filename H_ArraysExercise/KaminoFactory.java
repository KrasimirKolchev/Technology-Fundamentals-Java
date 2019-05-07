package H_ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String input = "";
        int bestSequenceIndex = Integer.MAX_VALUE;
        int bestSum = 0;
        int sample = 0;
        int bestSample = 0;
        String sequenceOutput = "";

        while (!"Clone them!".equals(input = scanner.nextLine())) {
            sample++;
            String[] data = Arrays.stream(input.split("!+")).filter(e -> !e.equals("")).toArray(String[]::new);
            int[] sequence = new int[size];
            int index = 0;
            for (int i = 0; i < data.length; i++) {
                sequence[index++] = Integer.parseInt(data[i]);
            }

            int maxCount = 0;
            int bestIndex = 0;
            for (int i = 0; i < sequence.length; i++) {
                int currentCount = 0;
                for (int j = i; j < sequence.length; j++) {
                    if (sequence[i] == sequence[j]) {
                        currentCount++;
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                            bestIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < sequence.length; i++) {
                sum += sequence[i];
            }

            if ((bestIndex < bestSequenceIndex) || (sum > bestSum)) {
                sequenceOutput = "";
                bestSequenceIndex = bestIndex;
                bestSum = sum;
                bestSample = sample;
                for (int i = 0; i < sequence.length; i++) {
                    sequenceOutput += sequence[i] + " ";
                }
            }
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", bestSample, bestSum);
        System.out.println(sequenceOutput);
    }
}
