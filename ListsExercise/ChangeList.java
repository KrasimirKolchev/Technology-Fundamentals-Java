package N_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Delete" :
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i).equals(Integer.parseInt(command[1]))) {
                            numbers.remove(i);
                            i = -1;
                        }
                    }
                    break;
                case "Insert" :
                    int numberToInsert = Integer.parseInt(command[1]);
                    int index = Integer.parseInt(command[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, numberToInsert);
                        break;
                    }
                    break;
                    default:
                        break;
            }
        }
        System.out.println(numbers.toString().replaceAll("\\[|,|\\]", ""));
    }
}
