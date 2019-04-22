package K_MethodsExercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        System.out.println(SubtractResult(num1, num2, num3));
    }

    static int SumNumbers(int num1, int num2) {
        int sumNumb = num1 + num2;
        return sumNumb;
    }

    static int SubtractResult(int num1, int num2, int num3) {
        int result = SumNumbers(num1, num2) - num3;

        return result;
    }
}
