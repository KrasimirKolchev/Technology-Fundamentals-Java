package T_TextProcessingAndRegex;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input;

        while (!"end".equals(input = scanner.nextLine())) {
            StringBuilder reversed = new StringBuilder();

            reversed.append(input);
            reversed = reversed.reverse();

            System.out.println(String.format("%s = %s", input, reversed));

        }
    }
}
