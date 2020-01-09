package T_TextProcessingAndRegexEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String emailtext = scanner.nextLine();

        String regex = "\\s(?<user>([A-Za-z0-9][\\w.-]*)@[A-Za-z-]+(\\.[A-Za-z-]+)+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailtext);

        while (matcher.find()) {
            String user = matcher.group("user");
            System.out.println(user);
        }
    }
}


