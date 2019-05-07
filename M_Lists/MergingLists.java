package M_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> newNums = new ArrayList<>();

        for (int i = 0; i < Math.min(numbers1.size(), numbers2.size()); i++) {
            newNums.add(numbers1.get(i));
            newNums.add(numbers2.get(i));
        }
        if (numbers1.size() > numbers2.size()) {
            newNums.addAll(RemainingNumbers(numbers1, numbers2));
        } else if (numbers1.size() < numbers2.size()) {
            newNums.addAll(RemainingNumbers(numbers2, numbers1));
        }

        System.out.println(newNums.toString().replaceAll("[\\[\\],]", ""));
    }

    public static List<Integer> RemainingNumbers(List<Integer> longerList, List<Integer> shorterList) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = shorterList.size(); i < longerList.size(); i++) {
            numbers.add(longerList.get(i));
        }
        return numbers;
    }
}
