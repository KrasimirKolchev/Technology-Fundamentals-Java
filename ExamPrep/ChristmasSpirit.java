package demoMidExam;

import java.util.Scanner;

public class ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int spirit = 0;
        int sum = 0;

        for (int i = 1; i <= days; i++) {


            if (i % 11 == 0) {
                quantity += 2;
            }
            if (i % 2 == 0) {
                sum += quantity * 2;
                spirit += 5;
            }
            if (i % 3 == 0) {
                sum += (quantity * 5) + (quantity * 3);
                spirit += 13;
            }
            if (i % 5 == 0) {
                if (i % 15 == 0) {
                    spirit += 30;
                }
                sum += quantity * 15;
                spirit += 17;
            }
            if (i % 10 == 0) {
                spirit -= 20;
                sum += 5 + 3 + 15;
                if (i == days) {
                    spirit -= 30;
                }
            }

        }
        System.out.printf("Total cost: %d%nTotal spirit: %d", sum, spirit);

    }
}


//Ornament Set – 2$ a piece
//Tree Skirt – 5$ a piece
//Tree Garlands – 3$ a piece
//Tree Lights – 15$ a piece
