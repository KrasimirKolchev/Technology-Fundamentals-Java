package F_DatatypesAndVariablesMEx;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            long number1 = scanner.nextLong();
            long number2 = scanner.nextLong();
            long sum = 0;
            
            if (number1 > number2) {
                while (number1 != 0) {
                    sum += number1 % 10;
                    number1 /= 10;
                }
            } else {
                while (number2 != 0) {
                    sum += number2 % 10;
                    number2 /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}
