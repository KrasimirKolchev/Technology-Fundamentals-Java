package M_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] command = input.split(" ");

            switch (command[0]) {
                case "Contains" :
                    if (ContainsNumber(numbers, command)) {
                        System.out.println("Yes");
                        break;
                    }
                    System.out.println("No such number");
                    break;
                case "Print" :
                    PrintEvenPrintOdd(numbers, command);
                    break;
                case "Get" :
                    int sum = 0;
                    for (int num : numbers) {
                        sum += num;
                    }
                    System.out.println(sum);
                    break;
                case "Filter" :
                    FilterListByNumber(numbers, command);
                    break;
            }
        }
    }

    private static void FilterListByNumber(List<Integer> numbers, String[] command) {
        List<Integer> newList = new ArrayList<>();
        int numberFilter = Integer.parseInt(command[2]);

        switch (command[1]) {
            case "<" :
                for (int num : numbers) {
                    if(num < numberFilter) {
                        newList.add(num);
                    }
                }
                break;
            case ">" :
                for (int num : numbers) {
                    if(num > numberFilter) {
                        newList.add(num);
                    }
                }
                break;
            case "<=" :
                for (int num : numbers) {
                    if(num <= numberFilter) {
                        newList.add(num);
                    }
                }
                break;
            case ">=" :
                for (int num : numbers) {
                    if(num >= numberFilter) {
                        newList.add(num);
                    }
                }
                break;
        }
        System.out.println(newList.toString().replaceAll("\\[|\\]|,", ""));
    }

    private static void PrintEvenPrintOdd(List<Integer> numbers, String[] command) {
        List<Integer> newList = new ArrayList<>();

        if (command[1].equals("even")) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 == 0) {
                    newList.add(numbers.get(i));
                }
            }
        } else if (command[1].equals("odd")) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 != 0) {
                    newList.add(numbers.get(i));
                }
            }
        }
        System.out.println(newList.toString().replaceAll("[\\[\\],]", ""));
    }

    private static boolean ContainsNumber(List<Integer> numbers, String[] command) {
        int number = Integer.parseInt(command[1]);

        return numbers.contains(number);
    }
}
