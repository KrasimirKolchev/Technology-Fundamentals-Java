package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder(text);
        int length = sb.length() - 1;

        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb = sb.delete(i, i + 1);
                i -= 1;
                length -= 1;
            }
        }

        System.out.println(sb.toString());
    }
}
