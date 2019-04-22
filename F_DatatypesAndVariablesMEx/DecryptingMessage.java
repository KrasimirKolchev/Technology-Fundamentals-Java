package F_DatatypesAndVariablesMEx;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        String decryptedMessage = "";

        for (int i = 0; i < length; i++) {
            char input = scanner.next().charAt(0);
            int symbol = input + key;
            String decryptedSymbol = new StringBuffer().append((char)symbol).toString();
            decryptedMessage = decryptedMessage.concat(decryptedSymbol);
        }
        System.out.println(decryptedMessage);
    }
}
