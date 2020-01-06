package H_ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] fieldSize = new int[Integer.parseInt(scanner.nextLine())];
        int[] indexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] >= 0 && indexes[i] < fieldSize.length) {
                fieldSize[indexes[i]] = 1;
            }
        }
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {

            String[] input = command.split(" ");
            int index = Integer.parseInt(input[0]);
            String direction = input[1];
            int flight = Integer.parseInt(input[2]);

            if (index < 0 || index >= fieldSize.length || fieldSize[index] == 0) {
                continue;
            }
            fieldSize[index] = 0;
            int newPosition = flight;
            if (direction.equals("right")) {

                while (index + newPosition >= 0 && index + newPosition < fieldSize.length) {
                    if (fieldSize[index + newPosition] == 0) {
                        fieldSize[index + newPosition] = 1;
                        break;
                    } else {
                        newPosition += flight;
                    }
                }
            } else if (direction.equals("left")) {

                while (index - newPosition >= 0 && index - newPosition < fieldSize.length) {
                    if (fieldSize[index - newPosition] == 0) {
                        fieldSize[index - newPosition] = 1;
                        break;
                    } else {
                        newPosition += flight;
                    }
                }
            }
        }

        for (int number : fieldSize) {
            System.out.print(number + " ");
        }
    }
}
