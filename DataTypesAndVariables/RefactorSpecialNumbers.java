package D_DataTypesAndVariables;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            boolean isSpecial = false;
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecial) {
                System.out.printf("%d -> True\n", num);
            } else {
                System.out.printf("%d -> False\n", num);
            }
            i = num;
        }
    }
}
