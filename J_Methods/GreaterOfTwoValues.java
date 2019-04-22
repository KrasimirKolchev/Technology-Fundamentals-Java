package J_Methods;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String valueType = scanner.nextLine();

        if ("int".equals(valueType)) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(num1, num2));
        } else if ("char".equals(valueType)) {
            char char1 = scanner.nextLine().charAt(0);
            char char2 = scanner.nextLine().charAt(0);
            System.out.println(getMax(char1, char2));
        } else if ("String".toLowerCase().equals(valueType)) {
            String text1 = scanner.nextLine();
            String text2 = scanner.nextLine();
            System.out.println(getMax(text1, text2));
        }

    }

    static int getMax(int num1, int num2) {

        if (num1 > num2) {
            return num1;
        }
        return num2;
    }

    static char getMax(char char1, char char2) {

        if ((int)char1 > (int)char2) {
            return char1;
        }
        return char2;
    }

    static String getMax(String text1, String text2) {

        if (text1.compareTo(text2) >= 0) {
            return text1;
        }
        return text2;
    }

}
