package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] userNames = scanner.nextLine().split(", ");

        for (String username : userNames) {
            if (ValidateUsername(username)) {
                System.out.println(username);
            }
        }

    }

    private static boolean ValidateUsername(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }


        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetterOrDigit(username.charAt(i))
                    && username.charAt(i) != '-'
                    && username.charAt(i) != '_') {
                return false;
            }
        }
        return true;
    }
}
