package H_ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] fieldSize = new int[Integer.parseInt(scanner.nextLine())];
        int[] indexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] >= 0 && indexes[i] < fieldSize.length - 1) {
                fieldSize[indexes[i]] = 1;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String[] input = command.split(" ");
            int index = Integer.parseInt(input[0]);
            String direction = input[1];
            int flight = Integer.parseInt(input[2]);

            while (true) {
                if (index < 0 || index > fieldSize.length - 1 || flight == 0) {
                    break;
                } else if (flight < 0) {
                    flight = Math.abs(flight);
                    if (direction.equals("right")) {
                        direction = "left";
                    } else {
                        direction = "right";
                    }
                } else if (index == fieldSize.length - 1 && index == fieldSize[0]) {
                    fieldSize[index] = 0;
                    break;
                }
                if (direction.equals("right")) {
                    fieldSize[index] = 0;
                    if (fieldSize[index + flight] > fieldSize.length - 1) {
                        break;
                    } else {
                        for (int i = index + flight; i < fieldSize.length; i += flight) {
                            if (fieldSize[i] == 0) {
                                fieldSize[i] = 1;
                                break;
                            }
                        }
                    }
                } else {
                    fieldSize[index] = 0;
                    if (fieldSize[index - flight] < 0) {
                        break;
                    } else {
                        for (int i = index - flight; i >= 0; i -= flight) {
                            if (fieldSize[i] == 0) {
                                fieldSize[index] = 1;
                                break;
                            }
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (int number : fieldSize) {
            System.out.print(number + " ");
        }
    }
}