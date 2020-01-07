package L_MethodsMoreEx;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String value = scanner.nextLine();

        DataOutput(command, value);
    }
    private static void DataOutput(String command, String value) {

        switch (command) {
            case "int" :
                int number = Integer.parseInt(value);
                int result = number * 2;
                System.out.println(result);
                break;
            case "real" :
                double num = Double.parseDouble(value);
                double res = num * 1.5;
                System.out.printf("%.2f", res);
                break;
            case "string" :
                String text = "$" + value + "$";
                System.out.println(text);
                break;
        }
        return;
    }
}
