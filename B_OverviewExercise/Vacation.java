package B_OverviewExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String period = scanner.nextLine();
        double snglPrice = 0;
        double sum = 0;
        double total = 0;

        switch (group) {
            case "Students" :
                switch (period) {
                    case "Friday" :
                        snglPrice = 8.45;
                        break;
                    case "Saturday" :
                        snglPrice = 9.80;
                        break;
                    case "Sunday" :
                        snglPrice = 10.46;
                        break;
                }
                break;
            case "Business" :
                switch (period) {
                    case "Friday" :
                        snglPrice = 10.90;
                        break;
                    case "Saturday" :
                        snglPrice = 15.60;
                        break;
                    case "Sunday" :
                        snglPrice = 16;
                        break;
                }
                break;
            case "Regular" :
                switch (period) {
                    case "Friday" :
                        snglPrice = 15;
                        break;
                    case "Saturday" :
                        snglPrice = 20;
                        break;
                    case "Sunday" :
                        snglPrice = 22.50;
                        break;
                }
                break;
        }
        if (group.equals("Students") && people >= 30) {
            sum = people * snglPrice;
            total = sum - (sum * 0.15);
        } else if (group.equals("Business") && people >= 100) {
            total = (people - 10) * snglPrice;
        } else if (group.equals("Regular") && people >= 10 && people <= 20) {
            sum = people * snglPrice;
            total = sum - (sum * 0.05);
        } else {
            total = people * snglPrice;
        }
        System.out.printf("Total price: %.2f", total);
    }
}
