package A_Overview;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());
        int counter = 1;

        if (times <= 10) {
            while (times <= 10) {
                System.out.println(String.format("%d X %d = %d", number, times, number * times));
                times++;
                counter++;
            }
        } else {
            System.out.println(String.format("%d X %d = %d", number, times, number * times));
        }
    }
}
