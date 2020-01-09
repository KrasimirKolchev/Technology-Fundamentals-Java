package T_TextProcessingAndRegexEX;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String regex = "(?<s>[\\D]+)(?<n>[\\d]+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuilder output = new StringBuilder();

        while (matcher.find()) {

            String line = matcher.group("s");
            int times = Integer.parseInt(matcher.group("n"));

            for (int i = 0; i < times; i++) {
                output.append(line.toUpperCase());
            }

        }
        System.out.printf("Unique symbols used: %d%n", output.chars().distinct().count());
        System.out.println(output.toString());
    }
}
