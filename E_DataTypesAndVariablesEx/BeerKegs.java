package E_DataTypesAndVariablesEx;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String biggestKegOut = "";
        double biggestKegVolume = 0.0;

        for (int i = 0; i < n; i++) {
            String kegModel = scanner.nextLine();
            double radiusKeg = Double.parseDouble(scanner.nextLine());
            int heightKeg = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * (Math.pow(radiusKeg, 2)) * heightKeg;

            if (volume > biggestKegVolume) {
                biggestKegVolume = volume;
                biggestKegOut = kegModel;
            }
        }
        System.out.println(biggestKegOut);
    }
}
