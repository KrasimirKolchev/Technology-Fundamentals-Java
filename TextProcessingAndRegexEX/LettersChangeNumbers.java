package T_TextProcessingAndRegexEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double total = 0;

        for (String item : input) {
            String regex = "^[A-Za-z](?<n>[\\d]+)[A-Za-z]$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(item);


            while (matcher.find()) {
                int first = item.charAt(0);
                double number = Long.parseLong(matcher.group("n"));
                int last = item.charAt(item.length() - 1);

                if (first >= 65 && first <= 90) {
                    number = number / (first - 64);
                } else {
                    number = number * (first - 96);
                }

                if (last >= 97 && last <= 122) {
                    number = number + (last - 96);
                } else {
                    number = number - (last - 64);
                }

                total += number;
            }
        }

        System.out.printf("%.2f", total);

    }
}
