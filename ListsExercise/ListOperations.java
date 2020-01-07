package N_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] command = input.split(" ");

            switch (command[0]) {
                case "Add" :
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "Insert" :
                    int index = Integer.parseInt(command[2]);
                    if (index < 0 || index > numbers.size() - 1) {
                        System.out.println("Invalid index");
                        break;
                    }
                    numbers.add(index, Integer.parseInt(command[1]));
                    break;
                case "Remove" :
                    int index2 = Integer.parseInt(command[1]);
                    if (index2 < 0 || index2 > numbers.size() - 1) {
                        System.out.println("Invalid index");
                        break;
                    }
                    numbers.remove(index2);
                    break;
                case "Shift" :
                    int times = Integer.parseInt(command[2]);
                    switch (command[1]) {
                        case "left" :
                            for (int i = 0; i < times; i++) {
                                int temp = numbers.get(0);
                                numbers.remove(0);
                                numbers.add(temp);
                            }
                            break;
                        case "right" :
                            for (int i = 0; i < times; i++) {
                                int temp = numbers.get(numbers.size() - 1);
                                numbers.remove(numbers.size() - 1);
                                numbers.add(0, temp);
                            }
                            break;
                    }
                    break;
            }
        }
        System.out.println(numbers.toString().replaceAll("\\[|,|\\]", ""));
    }
}
