package B_OverviewExercise;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int divider = Integer.MIN_VALUE;

        if (number % 10 == 0 || number % 7 == 0 || number % 6 == 0 || number % 3 == 0 || number % 2 == 0) {
            if (number % 2 == 0) {
                divider = 2;
            }
            if (number % 3 == 0) {
                divider = 3;
            }
            if (number % 6 == 0) {
                divider = 6;
            }
            if (number % 7 == 0) {
                divider = 7;
            }
            if (number % 10 == 0) {
                divider = 10;
            }
            System.out.println("The number is divisible by " + divider);
        } else {
            System.out.println("Not divisible");
        }
    }
}
