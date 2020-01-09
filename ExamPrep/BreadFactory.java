package demoMidExam;

import java.util.Scanner;

public class BreadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] events = scanner.nextLine().split("\\|");

        int energy = 100;
        int coins = 100;

        for (int i = 0; i < events.length; i++) {
            String[] commands = events[i].split("-");

            //String command = commands[0];
            int value = Integer.parseInt(commands[1]);

            switch (commands[0]) {
                case "rest" :
                    if (energy == 100) {
                        System.out.println("You gained 0 energy.");
                        System.out.println("Current energy: 100.");
                    } else if (energy + value >= 100) {
                        System.out.printf("You gained %d energy.%n", 100 - energy);
                        energy = 100;
                        System.out.printf("Current energy: %d.%n", energy);
                    } else {
                        System.out.printf("You gained %d energy.%n", value);
                        energy += value;
                        System.out.printf("Current energy: %d.%n", energy);
                    }
                    break;
                case "order" :
                    if (energy - 30 >= 0) {
                        coins += value;
                        energy -= 30;
                        System.out.printf("You earned %d coins.%n", value);
                    } else {
                        energy += 50;
                        System.out.println("You had to rest!");
                    }
                    break;
                default:
                    if (coins - value > 0) {
                        coins -= value;
                        System.out.printf("You bought %s.%n", commands[0]);
                    } else {
                        System.out.printf("Closed! Cannot afford %s.%n", commands[0]);
                        return;
                    }
                    break;
            }

        }
        System.out.printf("Day completed!%nCoins: %d%nEnergy: %d", coins, energy);
    }
}
