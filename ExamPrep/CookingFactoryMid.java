package demoMidExam;


import java.util.*;

public class CookingFactoryMid {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> batch = new ArrayList<>();
        String input;
        int bestQuality = -1000;
        double bestAverage = -1000;
        int bestLength = 0;


        while (!"Bake It!".equals(input = scanner.nextLine())) {
            int[] command = Arrays.stream(input.split("#")).mapToInt(Integer::parseInt).toArray();

            int quality = 0;
            for (int num : command) {
                quality += num;
            }

            int length = command.length;
            double average = quality / (length * 1.0);

            if (quality > bestQuality) {
                batch.clear();
                bestQuality = quality;
                bestLength = length;
                bestAverage = average;
                for (int num : command) {
                    batch.add(num);
                }
            } else if (quality == bestQuality && average > bestAverage) {
                batch.clear();
                bestAverage = average;
                bestLength = length;
                for (int num : command) {
                    batch.add(num);
                }
            } else if (quality == bestQuality && average == bestAverage && length < bestLength) {
                batch.clear();
                bestLength = length;
                for (int num : command) {
                    batch.add(num);
                }
            }
        }
        System.out.printf("Best Batch quality: %d%n", bestQuality);
        for (int num : batch) {
            System.out.print(num + " ");
        }
    }

}
