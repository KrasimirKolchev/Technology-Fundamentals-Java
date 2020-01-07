package R_MapsLambdaStream;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String wordLowercase = word.toLowerCase();
            if (counts.containsKey(wordLowercase)) {
                counts.put(wordLowercase, counts.get(wordLowercase) + 1);
            } else {
                counts.put(wordLowercase, 1);
            }
        }
        ArrayList<String> oddWords = new ArrayList<>();

        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddWords.add(entry.getKey());
            }
        }
        for (int i = 0; i < oddWords.size(); i++) {
            System.out.print(oddWords.get(i));
            if (i < oddWords.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
