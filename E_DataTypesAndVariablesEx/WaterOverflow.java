package E_DataTypesAndVariablesEx;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int capacityTank = 255;
        int litersLeft = capacityTank;

        for (int i = 0; i < n; i++) {
            int litersFlow = Integer.parseInt(scanner.nextLine());
            if (litersLeft - litersFlow >= 0) {
                litersLeft -= litersFlow;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        int tankLiters = capacityTank - litersLeft;
        System.out.println(tankLiters);
    }
}
