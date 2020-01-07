package S_MapsLambdaStreamEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("");

        Map<String, Integer> charsCount = new LinkedHashMap<>();

        for (int i = 0; i < text.length; i++) {
            if (!text[i].equals(" ")) {
                if (!charsCount.containsKey(text[i])) {
                    charsCount.put(text[i], 0);
                }
                charsCount.put(text[i], charsCount.get(text[i]) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : charsCount.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
