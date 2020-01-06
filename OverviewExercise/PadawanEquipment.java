package B_OverviewExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceSabre = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());
        double freebelt = students / 6.0;
        if (freebelt == 0) {
            freebelt = 1;
        } else {
            freebelt = (int) freebelt;
        }
        double total = (((Math.ceil(students * 0.1) + students) * priceSabre)) + (students * priceRobe) + ((students - freebelt) * priceBelt);

        if (budget >= total) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", total - budget);
        }
    }
}
