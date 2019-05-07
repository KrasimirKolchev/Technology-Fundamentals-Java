package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String bigNumber = scanner.nextLine();
        int multiplyNumber = scanner.nextInt();
        int rest = 0;

        if (bigNumber.isEmpty()) {
            bigNumber = "0";
        }
        if (multiplyNumber == 0) {
            System.out.println(0);
            return;
        }

        for (int i = bigNumber.length() - 1; i >= 0; i--) {

            int number = bigNumber.charAt(i) - 48;
            int multiply = (number * multiplyNumber) + rest;
            int numAdd = 0;

            if (multiply < 10) {
                rest = 0;
                numAdd = multiply;
            }  else {
                rest = multiply / 10;
                numAdd = multiply - (rest * 10);
            }


            sb = sb.append(numAdd);

            if (i == 0) {
                if (multiply > 9) {
                    sb = sb.append(multiply / 10);
                    break;
                }
            }
        }

        System.out.println(sb.reverse().toString());
    }
}
