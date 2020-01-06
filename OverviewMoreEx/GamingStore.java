package C_OverviewMoreEx;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = Double.parseDouble(scanner.nextLine());
        double spent = 0;
        double price = 0;
        boolean flag = false;

        while (true) {
            String input = scanner.nextLine();
            if (balance == 0) {
                System.out.println("Out of money!");
                break;
            }
            if (input.equals("Game Time")) {
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, balance);
                break;
            } else {
                switch (input) {
                    case "OutFall 4" :
                        flag = true;
                        price = 39.99;
                        break;
                    case "CS: OG" :
                        flag = true;
                        price = 15.99;
                        break;
                    case "Zplinter Zell" :
                        flag = true;
                        price = 19.99;
                        break;
                    case "Honored 2" :
                        flag = true;
                        price = 59.99;
                        break;
                    case "RoverWatch" :
                        flag = true;
                        price = 29.99;
                        break;
                    case "RoverWatch Origins Edition" :
                        flag = true;
                        price = 39.99;
                        break;
                }
            }
            if (balance < price) {
                System.out.println("Too Expensive");
            } else if (flag) {
                System.out.println("Bought " + input);
                balance -= price;
                spent += price;
            } else {
                System.out.println("Not Found");
            }
        }
    }
}
