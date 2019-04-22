package J_Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double num2 = Double.parseDouble(scanner.nextLine());

        double result = Calculate(num1, operator, num2);
        System.out.println(new DecimalFormat("0.##").format(Calculate(num1, operator, num2)));
    }

    private static double Calculate(double num1, String operator, double num2) {
        double result = 0.0;

        switch (operator) {
            case "/" :
                result = num1 / num2;
                break;
            case "*" :
                result = num1 * num2;
                break;
            case "+" :
                result = num1 + num2;
                break;
            case "-" :
                result = num1 - num2;
                break;
            default:
                break;
        }
        return result;
    }
}
