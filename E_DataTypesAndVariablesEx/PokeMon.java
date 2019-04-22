package E_DataTypesAndVariablesEx;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yield = Integer.parseInt(scanner.nextLine());
        int spiceExtracted = 0;
        int days = 0;
        while (yield > 99) {
            int spiceMined = yield;
            spiceExtracted += spiceMined - 26;
            yield -= 10;
            days++;
        }
        if (days != 0) {
            spiceExtracted -= 26;
        }
        System.out.printf("%d\n%d", days, spiceExtracted);
    }
}
