package I_ArraysMoreEx;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pascalNumber = Integer.parseInt(scanner.nextLine());

        PascalTrianglePrint(pascalNumber);
    }

    static void PascalTrianglePrint(int n) {

        for (int i = 1; i <= n; i++) {
            int pascal = 1;

            for (int j = 1; j <= i; j++) {
                System.out.print(pascal + " ");
                pascal = pascal * (i - j) / j;
            }
            System.out.println();

        }
    }
}
