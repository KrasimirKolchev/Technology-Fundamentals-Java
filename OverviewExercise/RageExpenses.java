package B_OverviewExercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        double total = 0;
        int counter = 0;

        for (int i = 0; i <= lostGames; i++) {
            if ((i % 2 == 0) && (i != 0)) {
                total += headsetPrice;
            }
            if ((i % 3 == 0) && (i != 0)) {
                total += mousePrice;
            }
            if (((i % 2 == 0) && (i % 3 == 0) && (i != 0))) {
                total += keyboardPrice;
                counter++;
            }
            if ((counter % 2 == 0) && (counter != 0)) {
                total += displayPrice;
                counter = 0;
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
