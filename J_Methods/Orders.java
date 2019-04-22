package J_Methods;

import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String orderedProduct = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        productPrice(orderedProduct, quantity);
    }

    static void productPrice(String orderedProduct, int quantity) {

        double result;

        switch (orderedProduct) {
            case "coffee" :
                result = quantity * 1.5;
                System.out.printf("%.2f", result);
                break;
            case "water" :
                result = quantity * 1.0;
                System.out.printf("%.2f", result);
                break;
            case "coke" :
                result = quantity * 1.40;
                System.out.printf("%.2f", result);
                break;
            case "snacks" :
                result = quantity * 2.0;
                System.out.printf("%.2f", result);
                break;
                default:
                    break;
        }

    }
}
