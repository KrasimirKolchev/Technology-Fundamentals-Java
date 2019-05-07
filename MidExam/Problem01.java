package MidExam;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tripDays = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int peopleGroup = Integer.parseInt(scanner.nextLine());
        double fuelKM = Double.parseDouble(scanner.nextLine());
        double foodPerson = Double.parseDouble(scanner.nextLine());
        double roomNightPerson = Double.parseDouble(scanner.nextLine());

        double currentExpenses = 0;

        currentExpenses += peopleGroup * foodPerson * tripDays;
        double nights = peopleGroup * roomNightPerson * tripDays;
        if (peopleGroup > 10) {
            nights = nights - (nights * 0.25);
        }
        currentExpenses += nights;

        for (int i = 1; i <= tripDays; i++) {
            double kilometers = Double.parseDouble(scanner.nextLine());
            currentExpenses += kilometers * fuelKM;

            if (i % 3 == 0 || i % 5 == 0) {
                currentExpenses += currentExpenses * 0.4;
            }
            //if (i % 5 == 0) {
             //   currentExpenses += currentExpenses * 0.4;
            //}
            if (i % 7 == 0) {
                currentExpenses -= currentExpenses / peopleGroup;
            }

            if (budget < currentExpenses) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", currentExpenses - budget);
                break;
            }
        }
        if (budget >= currentExpenses) {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - currentExpenses);
        }

    }
}
