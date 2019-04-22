package B_OverviewExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int i = 0;
        int reminder = 0;
        int sum = 0;
        int factorial = 0;
        int temp = number;

        while (temp > 0) {
            factorial = 1;
            i = 1;
            reminder = temp % 10;
            while (i <= reminder) {
                factorial = factorial * i;
                i++;
            }
            sum = sum + factorial;
            temp = temp / 10;
        }
        if (number == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
