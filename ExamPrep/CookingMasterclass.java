package demoMidExam;

import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        int freeFlour = students / 5;

        double totalFlour = (students - freeFlour) * flourPrice;
        double totalEggs = students * (eggPrice * 10);
        double totalApron = Math.ceil((students * 0.2) + students) * apronPrice;

        double totalPrice = totalFlour + totalEggs + totalApron;

        if (totalPrice <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalPrice);
        } else {
            double needed = totalPrice - budget;
            System.out.printf("%.2f$ more needed.", needed);
        }

    }
}
