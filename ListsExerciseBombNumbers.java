package N_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scanner.nextLine().split(" ");
        int bombNumber = Integer.parseInt(input[0]);
        int bombPower = Integer.parseInt(input[1]);


        for (int j = 0; j < numbers.size(); j++) {
            if (numbers.get(j).equals(bombNumber)) {
                int index = j;
                int startIndex = index - bombPower;
                int endIndex = index + bombPower;
                if (startIndex >= 0 && endIndex < numbers.size()) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        numbers.remove(i);
                        i -= 1;
                        endIndex -= 1;
                    }
                } else if (startIndex < 0 && endIndex < numbers.size()) {
                    startIndex = 0;
                    for (int i = startIndex; i <= endIndex; i++) {
                        numbers.remove(i);
                        i -= 1;
                        endIndex -= 1;
                    }
                } else if (startIndex >= 0 && endIndex >= numbers.size() - 1) {
                    endIndex = numbers.size() - 1;
                    for (int i = startIndex; i <= endIndex; i++) {
                        numbers.remove(i);
                        i -= 1;
                        endIndex -= 1;
                    }
                } else if (startIndex < 0 && endIndex >= numbers.size() - 1) {
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.remove(i);
                        i -= 1;
                    }
                }
                j = -1;
            }
        }

        int sum = 0;
        for (int number : numbers) {

            sum += number;
        }
        System.out.println(sum);
    }
}
