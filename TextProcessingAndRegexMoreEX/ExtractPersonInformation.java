package T_TextProcessingAndRegexEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            String regexName = "@(?<name>[A-Za-z]+)\\|";
            String regexAge = "#(?<age>[\\d]+)";

            Pattern patternName = Pattern.compile(regexName);
            Pattern patternAge = Pattern.compile(regexAge);
            Matcher matcherName = patternName.matcher(line);
            Matcher matcherAge = patternAge.matcher(line);

            String name = "";
            int age = 0;
            while (matcherName.find() && matcherAge.find()) {
                name = matcherName.group("name");
                age = Integer.parseInt(matcherAge.group("age"));
                System.out.println(String.format("%s is %d years old.", name, age));
            }
        }
    }
}
