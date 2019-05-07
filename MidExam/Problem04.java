package MidExam;

import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterDayPerson = Double.parseDouble(scanner.nextLine());
        double foodDayPerson = Double.parseDouble(scanner.nextLine());
        double waterGroup = waterDayPerson * players * days;
        double foodGroup = foodDayPerson * players * days;

        for (int i = 1; i <= days; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            groupEnergy -= energyLoss;

            if (groupEnergy < 0) {
                break;
            }

            if (i % 2 == 0) {
                groupEnergy += groupEnergy * 0.05;
                waterGroup -= waterGroup * 0.3;
            }
            if (i % 3 == 0) {
                groupEnergy += groupEnergy * 0.1;
                foodGroup -= foodGroup / players;
            }

        }

        if (groupEnergy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", foodGroup, waterGroup);
        }
    }
}
