package MidExam;

import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fireCells = scanner.nextLine().split("#");
        String[] cells = new String[fireCells.length];

        int water = Integer.parseInt(scanner.nextLine());
        double effort = 0;
        int totalFire = 0;

        for (int i = 0; i < fireCells.length; i++) {
            String[] command = fireCells[i].split(" = ");
            int value = Integer.parseInt(command[1]);
            if (water >= value && water > 0) {

                switch (command[0]) {
                    case "High" :
                        if (value > 80 && value <= 125) {
                            water -= value;
                            totalFire += value;
                            effort += value / 4.0;
                            cells[i] = command[1];
                        } else {
                            cells[i] = "no";
                        }
                        break;
                    case "Medium" :
                        if (value > 50 && value <= 80) {
                            water -= value;
                            totalFire += value;
                            effort += value / 4.0;
                            cells[i] = command[1];
                        } else {
                            cells[i] = "no";
                        }
                        break;
                    case "Low" :
                        if (value >= 1 && value <= 50) {
                            water -= value;
                            totalFire += value;
                            effort += value / 4.0;
                            cells[i] = command[1];
                        } else {
                            cells[i] = "no";
                        }
                        break;
                        default:
                            cells[i] = "no";
                            break;
                }
            } else {
                cells[i] = "no";
            }
        }
        System.out.println("Cells:");
        for (String cell : cells) {
            if (!cell.equals("no")) {
                System.out.println(" - " + cell);
            }
        }
        System.out.printf("Effort: %.2f%nTotal Fire: %d", effort, totalFire);
    }
}
