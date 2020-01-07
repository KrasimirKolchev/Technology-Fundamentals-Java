package T_TextProcessingAndRegex;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String remove = scanner.nextLine();
        String text = scanner.nextLine();
        int index = text.indexOf(remove);

        while(index != -1) {
            text = text.replace(remove, "");
            index = text.indexOf(remove);
        }
        System.out.println(text);
    }
}
