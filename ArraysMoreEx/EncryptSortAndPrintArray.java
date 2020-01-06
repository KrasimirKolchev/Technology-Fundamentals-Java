package I_ArraysMoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[lines];

        for (int i = 0; i < lines; i++) {
            String text = scanner.nextLine();
            double textSum = 0;
            for (int j = 0; j < text.length(); j++) {
                char symbol = text.charAt(j);

                if (symbol == 'a' || symbol == 'e' || symbol == 'i'
                        || symbol == 'o' || symbol == 'u' || symbol == 'A' || symbol == 'E' || symbol == 'I'
                        || symbol == 'O' || symbol == 'U') {
                    textSum += text.charAt(j) * text.length();
                } else {
                    textSum += text.charAt(j) / text.length();
                }
            }
            numbers[i] = (int)textSum;
        }
        Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
