package T_TextProcessingAndRegexEX;

import java.util.Scanner;

public class HTMLgenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String article = scanner.nextLine();
        System.out.printf("<h1>%n    %s%n</h1>%n", article);
        System.out.println(article);
        String content = scanner.nextLine();
        System.out.printf("<article>%n    %s%n</article>", content);
        String line;

        while (!"end of comments".equals(line = scanner.nextLine())) {
            System.out.printf("%n<div>%n    %s%n</div>", line);
        }

    }
}
