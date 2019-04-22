package demoMidExam;

import java.util.Scanner;

public class SweetDessert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int guests = Integer.parseInt(scanner.nextLine());
        double bananaPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double kiloBerriesPrice = Double.parseDouble(scanner.nextLine());
        double berriesPrice = kiloBerriesPrice / 5;

        double portionPrice = (bananaPrice * 2) + (eggPrice * 4) + (berriesPrice);
        double total;

        if (guests % 6 == 0) {
            total = portionPrice * (guests / 6.0);
        } else {
            total = portionPrice * ((int)(guests / 6.0) + 1);
        }

        if (budget >= total) {
            System.out.printf("Ivancho has enough money - it would cost %.2flv.", total);
        } else {
            System.out.printf("Ivancho will have to withdraw money - he will need %.2flv more.", total - budget);
        }
    }
}
