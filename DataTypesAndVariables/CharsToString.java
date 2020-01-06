package D_DataTypesAndVariables;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.next().charAt(0);
        char second = scanner.next().charAt(0);
        char third = scanner.next().charAt(0);

        String result = new StringBuilder().append(first).append(second).append(third).toString();
        System.out.println(result);
    }
}
