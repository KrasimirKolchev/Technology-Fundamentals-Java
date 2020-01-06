package H_ArraysExercise;

import java.util.Scanner;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int coins = 0;
        int bestRoom = 0;
        int bestValue = 0;

        String[] levels = scanner.nextLine().split("\\|");

        for (int i = 0; i < levels.length; i++) {
            String[] game = levels[i].split(" ");
            String command = game[0];
            int value = Integer.parseInt(game[1]);

            if (value > bestValue) {
                bestRoom = i;
            }

            switch (command) {
                case "chest" :
                    System.out.printf("You found %d coins.\n", value);
                    coins += value;
                    break;
                case "potion" :
                    if (health + value >= 100) {
                        System.out.printf("You healed for %d hp.\n", (100 - health));
                        health = 100;
                        System.out.printf("Current health: %d hp.\n", health);
                        break;
                    } else {
                        System.out.printf("You healed for %d hp.\n", value);
                        health += value;
                        System.out.printf("Current health: %d hp.\n", health);
                        break;
                    }
                default:
                    health -= value;
                    if (health > 0) {
                        System.out.printf("You slayed %s.\n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.\n", command);
                        System.out.printf("Best room: %d", bestRoom + 1);
                        return;
                    }
                }
            if (i == levels.length - 1) {
                System.out.printf("You've made it!\nCoins: %d\nHealth: %d", coins, health);
            }
        }
    }
}
