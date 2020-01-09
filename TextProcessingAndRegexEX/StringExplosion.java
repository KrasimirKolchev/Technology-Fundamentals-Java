package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String explosionText = scanner.nextLine();
        String textOut = "";
        int power = 0;

        for (int i = 0; i < explosionText.length(); i++) {

            textOut += explosionText.charAt(i);

            if (explosionText.charAt(i) == '>') {
                power += Integer.parseInt(String.valueOf(explosionText.charAt(i + 1)));
            }

            while (power > 0) {
                power--;
                i++;

                if (i + 1 == explosionText.length() || explosionText.charAt(i + 1) == '>') {
                    break;
                }
            }
        }
        System.out.println(textOut);
    }
}
