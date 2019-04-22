package E_DataTypesAndVariablesEx;

import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int partyProfit = 0;
        int counter = 0;

        while (counter < days) {
            counter++;
            if (counter % 10 == 0) {
                partySize -= 2;
            }
            if (counter % 15 == 0) {
                partySize += 5;
            }
            if (counter % 5 == 0) {
                partyProfit += partySize * 20;
                if (counter % 3 == 0) {
                    partyProfit -= partySize * 2;
                }
            }
            if (counter % 3 == 0) {
                partyProfit -= partySize * 3;
            }
            partyProfit += 50 - (partySize * 2);

        }
        System.out.printf("%d companions received %d coins each.", partySize, (partyProfit / partySize));
    }
}
