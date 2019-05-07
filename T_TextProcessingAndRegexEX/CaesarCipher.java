package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String text = scanner.nextLine();


        for (int i = 0; i < text.length(); i++) {
            int symbol = text.charAt(i) + 3;
            char symbol2 = (char)symbol;
            sb = sb.append(symbol2);
        }
        System.out.println(sb.toString());
    }
}
