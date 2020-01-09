package T_TextProcessingAndRegexEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] keySequence = scanner.nextLine().split("\\s+");

        String line;

        while(!"find".equals(line = scanner.nextLine())) {
            StringBuilder message = new StringBuilder();
            int pos = 0;

            if (keySequence.length > 1) {
                for (int i = 0; i < line.length(); i++) {
                    int symbol = line.charAt(i);
                    int num = Integer.parseInt(keySequence[pos]);
                    int newSymbol = symbol - num;
                    message.append((char)newSymbol);
                    pos++;

                    if (pos == keySequence.length) {
                        pos = 0;
                    }
                }
            } else {
                for (int i = 0; i < line.length(); i++) {
                    int symbol = line.charAt(i);
                    int num = Integer.parseInt(keySequence[pos]);
                    int newSymbol = symbol - num;
                    message.append((char)newSymbol);

                }
            }

            String regexType = "&(?<type>\\w+)&";
            String regexCoord = "<(?<coordinates>[A-Za-z\\d ]+)>";

            Pattern patternType = Pattern.compile(regexType);
            Pattern patternCoord = Pattern.compile(regexCoord);
            Matcher matcherType = patternType.matcher(message);
            Matcher matcherCoord = patternCoord.matcher(message);

            while (matcherType.find() && matcherCoord.find()) {
                String type = matcherType.group("type");
                String coordinates = matcherCoord.group("coordinates");
                System.out.println(String.format("Found %s at %s", type, coordinates));
            }

        }
    }
}
