package A_Overview;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int times = 0;

        while (times++ < 10) {
            System.out.println(String.format("%d X %d = %d", number, times, number * times));
        }
    }
}
