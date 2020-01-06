package J_Methods;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        int result = GetMultiplyEvenByOdd(number);
        System.out.println(result);
    }

    private static int GetMultiplyEvenByOdd(int number) {
        int evenSum = MultiplyEvenSum(number);
        int oddSum = MultiplyOddSum(number);

        return evenSum * oddSum;
    }

    private static int MultiplyEvenSum(int number) {

        int evenSum = 0;
        while (number > 0) {
            int num = number % 10;
            number /= 10;
            if (num % 2 == 0) {
                evenSum += num;
            }

        }
        return evenSum;
    }

    private static int MultiplyOddSum(int number) {

        int oddSum = 0;
        while (number > 0) {
            int num = number % 10;
            number /= 10;
            if (num % 2 != 0) {
                oddSum += num;
            }

        }
        return oddSum;
    }
}
