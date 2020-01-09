package T_TextProcessingAndRegexEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();
        String command;

        while(!"end".equals(command = scanner.nextLine())) {
            StringBuilder message = new StringBuilder();

            for (int i = 0; i < command.length(); i++) {
                int symbol = command.charAt(i) - key;
                message.append((char)symbol);
            }

            String regex = "^[\\w\\W]*@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<beh>(G|N))![\\w\\W]*$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {

                if (matcher.group("beh").equals("G_Arrays")) {
                    names.add(matcher.group("name"));
                }
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
