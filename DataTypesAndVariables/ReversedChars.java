package D_DataTypesAndVariables;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.next().charAt(0);
        char second = scanner.next().charAt(0);
        char third = scanner.next().charAt(0);

        String result = new StringBuilder().append(first).append(second).append(third).toString();
        String reverse = new StringBuffer(result).reverse().toString();

        for (int i = 0; i < reverse.length(); i++) {
            System.out.print(reverse.charAt(i) + " ");
        }
    }
}
