package T_TextProcessingAndRegex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsLettersAndOther {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String digits = "";
        String alphab = "";
        String someSymbols = "";

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (Character.isDigit(symbol)) {
                digits += text.charAt(i);
            } else if (Character.isAlphabetic(text.charAt(i))) {
                alphab += text.charAt(i);
            } else {
                someSymbols += text.charAt(i);
            }
        }

        System.out.printf("%s%n%s%n%s", digits, alphab, someSymbols);
    }
}
