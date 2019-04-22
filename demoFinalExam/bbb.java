package demoFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bbb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] key = scanner.nextLine().split(" ");

        String regex = "^[d-z#}{|]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String text = "";

            for (int i = 0; i < matcher.group().length(); i++) {
                int symbol = matcher.group().charAt(i) - 3;
                char newsymbol = (char)symbol;
                text += newsymbol;
            }

            int index = text.indexOf(key[0]);

            while (index != -1) {
                text = text.replace(key[0], key[1]);
                index = text.indexOf(key[0]);
            }

            System.out.println(text);

        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }
}
