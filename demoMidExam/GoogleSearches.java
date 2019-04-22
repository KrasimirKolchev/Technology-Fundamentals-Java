package demoMidExam;

import java.util.Scanner;

public class GoogleSearches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int users = Integer.parseInt(scanner.nextLine());
        double moneyPerSearch = Double.parseDouble(scanner.nextLine());
        double totalMoney = 0;

        for (int i = 1; i <= users; i++) {
            int words = Integer.parseInt(scanner.nextLine());
            double money = 0;

            if (words > 5) {
                continue;
            } else if (words > 1) {
                money += moneyPerSearch;
                if (i % 3 == 0) {
                    money = money * 3;
                }
            }
            if (words == 1) {
                money = moneyPerSearch * 2;
                if (i % 3 == 0) {
                    money = money * 3;
                }
            }

            totalMoney += money * days;
        }
        System.out.printf("Total money earned for %d days: %.2f", days, totalMoney);
    }
}
