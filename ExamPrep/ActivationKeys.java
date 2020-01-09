package T_TextProcessingAndRegexEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("&+");
        List<String> keySet = new ArrayList<>();

        for (String key : line) {

            String regex = "[A-Za-z0-9]+";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(key);

            while(matcher.find()) {
                String keyLine = matcher.group();

                if (keyLine.length() == 16) {
                    keySet.add(keyLine);
                } else if (keyLine.length() == 25) {
                    keySet.add(keyLine);
                }
            }
        }

        for (int i = 0; i < keySet.size(); i++) {
            String key = keySet.get(i);
            StringBuilder sb = new StringBuilder();

            if (key.length() == 16) {
                for (int j = 0; j < key.length(); j++) {
                    if (j % 4 == 0 && j != 0 & j != key.length() - 1) {
                        sb.append('-');
                    }

                    char symbol = key.charAt(j);

                    if (Character.isDigit(symbol)) {
                        int num = (57 - symbol);
                        sb.append(num);
                    } else {
                        sb.append(symbol);
                    }
                }
            } else {
                for (int j = 0; j < key.length(); j++) {
                    if (j % 5 == 0 && j != 0 & j != key.length() - 1) {
                        sb.append('-');
                    }

                    char symbol = key.charAt(j);

                    if (Character.isDigit(symbol)) {
                        int num = (57 - symbol);
                        sb.append(num);
                    } else {
                        sb.append(symbol);
                    }
                }
            }
            keySet.set(i, sb.toString().toUpperCase());
        }
        System.out.println(keySet.toString().replaceAll("\\[|\\]", ""));
    }
}
