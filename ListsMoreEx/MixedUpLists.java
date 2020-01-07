package O_ListsMoreEx;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers1 = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numbers2);

        List<Integer> newNumbers = new ArrayList<>();

        while (numbers1.size() > 0 && numbers2.size() > 0) {
            newNumbers.add(numbers1.get(0));
            newNumbers.add(numbers2.get(0));
            numbers1.remove(0);
            numbers2.remove(0);
        }
        int num1 = 0;
        int num2 = 0;

        if (!numbers1.isEmpty()) {
            num1 = numbers1.get(0);
            num2 = numbers1.get(1);
            numbers1.clear();
        } else {
            num1 = numbers2.get(0);
            num2 = numbers2.get(1);
            numbers2.clear();
        }

        if (num1 > num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        List<Integer> numbersToPrint = new ArrayList<>();
        for (int item : newNumbers) {
            if (item > num1 && item < num2) {
                numbersToPrint.add(item);
            }
        }
        Collections.sort(numbersToPrint);
        System.out.println(numbersToPrint.toString().replaceAll("[\\[\\],]", ""));
    }
}
