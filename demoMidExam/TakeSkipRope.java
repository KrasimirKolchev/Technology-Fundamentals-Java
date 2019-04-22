package demoMidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        List<String> message = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < text.size(); i++) {
            String symbol = text.get(i);

            if (symbol.equals("0") || symbol.equals("1") || symbol.equals("2") || symbol.equals("3") ||
                    symbol.equals("4") || symbol.equals("5") || symbol.equals("6") ||
                    symbol.equals("7") || symbol.equals("8") || symbol.equals("9")) {

                numbers.add(Integer.parseInt(text.get(i)));
            } else {
                message.add(text.get(i));
            }
        }
        text.clear();
        int position = 0;
        int end = 0;
        for (int j = 0; j < numbers.size(); j++) {
            int item = numbers.get(j);
            if (j % 2 == 0) {
                end += item;
                for (int i = position; i < end; i++) {
                    if (i == message.size()) {
                        break;
                    }
                    text.add(message.get(i));
                }

            } else {
                end += item;

            }
            position += item;

        }
        for (String symbol : text) {
            System.out.print(symbol);
        }
    }
}
