package E_DataTypesAndVariablesEx;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int powerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionY = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int power = powerN;

        while (powerN > 0) {

            if (powerN < distanceM) {
                break;
            }
            if ((powerN - distanceM) < powerN) {
                powerN -= distanceM;
                counter++;
            }
            if ((power / 2) == powerN) {
                if (exhaustionY != 0) {
                    powerN /= exhaustionY;
                }
            }
        }
        System.out.printf("%d\n%d", powerN, counter);
    }
}
