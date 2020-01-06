package E_DataTypesAndVariablesEx;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firsNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int sum = firsNumber + secondNumber;
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        sum /= thirdNumber;
        int fourthNumber = Integer.parseInt(scanner.nextLine());
        sum *= fourthNumber;
        System.out.println(sum);
    }
}
