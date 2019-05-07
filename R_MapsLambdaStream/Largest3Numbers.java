package R_MapsLambdaStream;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).sorted((e1, e2) -> e2.compareTo(e1)).collect(Collectors.toList());

        int size;
        if (numbers.size() > 3) {
            size = 3;
        } else {
            size = numbers.size();
        }

        for (int i = 0; i < size; i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
