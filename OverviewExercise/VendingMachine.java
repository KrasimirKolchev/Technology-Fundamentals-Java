package B_OverviewExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double coins = 0;
        double sum = 0;
        double price = 0;
        boolean flag = false;
        String product = "";
        String input = "";

        while (true) {
            input = scanner.nextLine();
            if (input.equals("Start")) {
                break;
            }
            coins = Double.parseDouble(input);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                sum += coins;
            } else {
                System.out.println("Cannot accept " + coins);
            }
        }
        while (true) {
            product = scanner.nextLine();
            switch (product) {
                case "Nuts" :
                    price = 2;
                    flag = true;
                    break;
                case "Water" :
                    price = 0.7;
                    flag = true;
                    break;
                case "Crisps" :
                    price = 1.5;
                    flag = true;
                    break;
                case "Soda" :
                    price = 0.8;
                    flag = true;
                    break;
                case "Coke" :
                    price = 1;
                    flag = true;
                    break;
            }
            if (product.equals("End")) {
                break;
            }
            if (sum < price) {
                System.out.println("Sorry, not enough money");
            } else if (flag) {
                System.out.println("Purchased " + product);
                sum -= price;
            } else {
                System.out.println("Invalid product");
            }
        }
        System.out.printf("Change: %.2f", sum);
    }
}
