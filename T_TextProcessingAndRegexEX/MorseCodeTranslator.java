package T_TextProcessingAndRegexEX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> codeGenerator = new LinkedHashMap<>();
        codeGenerator.put(".-", 65); codeGenerator.put("-...", 66); codeGenerator.put("-.-.", 67);
        codeGenerator.put("-..", 68); codeGenerator.put(".", 69); codeGenerator.put("..-.", 70);
        codeGenerator.put("--.", 71); codeGenerator.put("....", 72); codeGenerator.put("..", 73);
        codeGenerator.put(".---", 74); codeGenerator.put("-.-", 75); codeGenerator.put(".-..", 76);
        codeGenerator.put("--", 77); codeGenerator.put("-.", 78); codeGenerator.put("---", 79);
        codeGenerator.put(".--.", 80); codeGenerator.put("--.-", 81); codeGenerator.put(".-.", 82);
        codeGenerator.put("...", 83); codeGenerator.put("-", 84); codeGenerator.put("..-", 85);
        codeGenerator.put("...-", 86); codeGenerator.put(".--", 87); codeGenerator.put("-..-", 88);
        codeGenerator.put("-.--", 89); codeGenerator.put("--..", 90); codeGenerator.put("|", 32);

        String[] MCMessage = scanner.nextLine().split(" ");
        StringBuilder message = new StringBuilder();

        for (String item : MCMessage) {
            int symbol = codeGenerator.get(item);
            message.append((char) symbol);
        }
        System.out.println(message.toString());
    }
}
