package I_ArraysMoreEx;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0) {
            System.out.println("0");
            return;
        }
        long[] fibonaccies = new long[n + 1];
        fibonaccies[0] = 0;
        fibonaccies[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonaccies[i] = -1;
        }

        long fibRes = fibonacci(n, fibonaccies);
        System.out.println(fibRes);
    }

    public static long fibonacci(int n, long[] fibonaccies) {
        if (fibonaccies[n] != -1) {
            return fibonaccies[n];
        }

        long result = fibonacci(n - 1, fibonaccies) + fibonacci(n - 2, fibonaccies);
        fibonaccies[n] = result;

        return result;
    }
}
