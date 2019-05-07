package N_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }
            String[] command = input.split(" ");

            if (command[0].equals("Add")) {
                wagons.add(Integer.parseInt(command[1]));
            } else {
                int newPassengers = Integer.parseInt(command[0]);

                for (int i = 0; i < wagons.size(); i++) {
                    int passengers = wagons.get(i);
                    if ((passengers + newPassengers) <= maxCapacity) {
                        wagons.set(i, (passengers + newPassengers));
                        break;
                    }
                }
            }
        }
        System.out.println(wagons.toString().replaceAll("\\[|,|\\]", ""));
    }
}
