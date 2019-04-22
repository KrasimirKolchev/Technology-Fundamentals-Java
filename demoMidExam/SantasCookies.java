package demoMidExam;


import java.util.Scanner;

public class SantasCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int batches = Integer.parseInt(scanner.nextLine());
        int totalBoxes = 0;

        for (int i = 0; i < batches; i++) {
            int flourGrams = Integer.parseInt(scanner.nextLine());
            int sugarGrams = Integer.parseInt(scanner.nextLine());
            int cocoaGrams = Integer.parseInt(scanner.nextLine());

            int cups = flourGrams / 140;
            int bigSpoon = sugarGrams / 20;
            int smallSpoon = cocoaGrams / 10;
            int box = 0;

            if (cups <= 0 || bigSpoon <= 0 || smallSpoon <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
                continue;
            }

            double cookies = ((140 + 20 + 10) * Math.min(Math.min(cups, bigSpoon), smallSpoon)) / 25.0;
            box = (int)Math.ceil(cookies) / 5;

            totalBoxes += box;
            System.out.printf("Boxes of cookies: %d%n", box);

        }
        System.out.printf("Total boxes: %d", totalBoxes);
    }
}
