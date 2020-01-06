package F_DatatypesAndVariablesMEx;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            if (counter > 1 || counter < -1) {
                break;
            }
            if (input.contains("(")) {
                counter++;
            } else if (input.contains(")")) {
                counter--;
            }
        }
        if (counter == 0) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
