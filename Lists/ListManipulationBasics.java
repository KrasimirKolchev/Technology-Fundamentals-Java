package M_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")){
                break;
            }
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Add" :
                    int numberToAdd = Integer.parseInt(command[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Remove" :
                    int numberToRemove = Integer.parseInt(command[1]);
                    numbers.remove(numberToRemove);
                    break;
                case "RemoveAt" :
                    int numberToRemoveAt = Integer.parseInt(command[1]);
                    numbers.remove(numberToRemoveAt);
                    break;
                case "Insert" :
                    int numberToInsert = Integer.parseInt(command[1]);
                    int indexToInsert = Integer.parseInt(command[2]);
                    numbers.add(indexToInsert, numberToInsert);
                    break;
                    default:
                        break;
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

    }

}
