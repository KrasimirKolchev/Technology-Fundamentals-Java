package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstSymbol = scanner.nextLine();
        String secondSymbol = scanner.nextLine();
        String text = scanner.nextLine();

        int first = firstSymbol.charAt(0);
        int second = secondSymbol.charAt(0);
        int sum = 0;

        if (first > second) {
            int temp = first;
            first = second;
            second = temp;
        }

        for (int i = 0; i < text.length(); i++) {
            int symbol = text.charAt(i);

            if (symbol > first && symbol < second) {
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
