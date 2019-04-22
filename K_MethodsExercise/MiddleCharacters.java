package K_MethodsExercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        PrintMiddleChar(text);
    }

    static void PrintMiddleChar(String text) {

        int length = text.length();

        if (length % 2 != 0) {
            System.out.printf("%c", text.charAt(length / 2));
        } else {
            System.out.printf("%c%c", text.charAt((length / 2) - 1), text.charAt(length / 2));
        }
    }
}
