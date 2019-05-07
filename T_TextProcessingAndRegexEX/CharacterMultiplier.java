package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String word1 = text.substring(0, text.indexOf(' '));
        String word2 = text.substring(text.lastIndexOf(' ') + 1).trim();

        System.out.println(MultiplyCharacters(word1, word2));
    }

    private static int MultiplyCharacters(String word1, String word2) {
        int minLength = Math.min(word1.length(), word2.length());
        int total = 0;

        for (int i = 0; i < minLength; i++) {
            total += word1.charAt(i) * word2.charAt(i);
        }

        String maxLength = word1.length() < word2.length() ? word2 : word1;

        for (int i = minLength; i < maxLength.length(); i++) {
            total += maxLength.charAt(i);
        }
        return total;
    }
}
