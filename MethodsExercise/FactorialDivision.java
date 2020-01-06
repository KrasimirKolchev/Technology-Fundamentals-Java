package K_MethodsExercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.2f",Factorial(num1, num2));
    }

    static double Factorial(double num1, double num2) {
        double result;

        for (double i = num1 - 1; i > 0; i--) {
            num1 *= i;
        }

        for (double i = num2 - 1; i > 0; i--) {
            num2 *= i;
        }

        result = num1 / num2;

        return result;
    }
}
