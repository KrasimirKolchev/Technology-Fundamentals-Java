package T_TextProcessingAndRegexEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\|");
        List<Character> message = new ArrayList<>();
        List<Integer> wordLength = new ArrayList<>();


        String part = line[0];

        String regex = "\\$([A-Z]+)\\$|#([A-Z]+)#|%([A-Z]+)%|\\*([A-Z]+)\\*|&([A-Z]+)&";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(part);

        while (matcher.find()) {
            String word = matcher.group();
            word = word.substring(1, word.length() - 1);

            for (int j = 0; j < word.length(); j++) {
                message.add(word.charAt(j));
                wordLength.add(0);
            }
        }

        part = line[1];

        regex = "((?<a>[0-9]{2}):(?<b>[0-9]{2}))";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(part);

        while (matcher.find()) {
            int a = Integer.parseInt(matcher.group("a"));
            char symbol = (char)a;
            int length = Integer.parseInt(matcher.group("b"));

            if (message.contains(symbol)) {
                wordLength.add(message.indexOf(symbol), length + 1);
            }
        }

        String[] words = line[2].split(" ");

        for (int i = 0; i < message.size(); i++) {
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                char symbol = word.charAt(0);

                if (message.get(i) == symbol && wordLength.get(i) == word.length()) {
                    System.out.println(word);
                }
            }
        }

    }
}
