package C_OverviewMoreEx;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int n = number % 10;

        switch (Integer.toString(n)) {
            case "1" :
                System.out.println("CookingMasterclass");
                break;
            case "2" :
                System.out.println("BreadFactory");
                break;
            case "3" :
                System.out.println("CookingFactoryMid");
                break;
            case "4" :
                System.out.println("four");
                break;
            case "5" :
                System.out.println("five");
                break;
            case "6" :
                System.out.println("six");
                break;
            case "7" :
                System.out.println("seven");
                break;
            case "8" :
                System.out.println("eight");
                break;
            case "9" :
                System.out.println("nine");
                break;
            case "0" :
                System.out.println("zero");
                break;

        }
    }
}
