package D_DataTypesAndVariables;

import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ukPounds = Double.parseDouble(scanner.nextLine());

        double usDollars = ukPounds * 1.31;
        System.out.printf("%.3f", usDollars);

    }
}
