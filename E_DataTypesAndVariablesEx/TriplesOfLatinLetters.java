package E_DataTypesAndVariablesEx;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char firstChar = 'a';
        char secondChar = 'a';
        char thirdChar = 'a';

        for (int i = 0; i < n; i++) {
            firstChar = (char) ('a' + i);
            for (int j = 0; j < n; j++) {
                secondChar = (char) ('a' + j);
                for (int k = 0; k < n; k++) {
                    thirdChar = (char) ('a' + k);
                    System.out.printf("%c%c%c\n", firstChar, secondChar, thirdChar);
                }
            }
        }
    }
}
