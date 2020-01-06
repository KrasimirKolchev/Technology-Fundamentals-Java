package K_MethodsExercise;

import java.util.Scanner;

public class CharacterInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int symbol1 = (int)scanner.nextLine().charAt(0);
        int symbol2 = (int)scanner.nextLine().charAt(0);


        if (symbol1 < symbol2) {
            CharactersInRange(symbol1, symbol2);
        } else {
            CharactersInRangeRev(symbol1, symbol2);
        }
    }

    static void CharactersInRange(int symbol1, int symbol2) {

        for (int i = symbol1 + 1; i < symbol2; i++) {
            System.out.print((char)i + " ");
        }

    }

    static void CharactersInRangeRev(int symbol1, int symbol2) {
        for (int i = symbol2 + 1; i < symbol1; i++) {
            System.out.print((char)i + " ");
        }

    }

}
