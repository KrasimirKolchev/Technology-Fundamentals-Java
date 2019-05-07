package O_ListsMoreEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        int lenght = (numbers.size() - 1) / 2;
        double leftRacer = 0;
        double rightRacer = 0;

        for (int i = 0; i < lenght; i++) {
            int num = numbers.get(i);
            if (num == 0) {
                leftRacer -= leftRacer * 0.2;
            }
            leftRacer += num;
        }

        for (int i = numbers.size() - 1; i > lenght; i--) {
            int num = numbers.get(i);
            if (num == 0) {
                rightRacer -= rightRacer * 0.2;
            }
            rightRacer += num;
        }

        if (leftRacer > rightRacer) {
            System.out.printf("The winner is right with total time: %.1f", rightRacer);
        } else {
            System.out.printf("The winner is left with total time: %.1f", leftRacer);
        }
    }
}
