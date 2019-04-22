package demoFinalExam;

import java.util.*;

public class aaa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> wordsDictionary = new TreeMap<>();

        String[] input = scanner.nextLine().split(" \\| ");

        for (int i = 0; i < input.length; i++) {
            String[] wordDefinition = input[i].split(": ");

            wordsDictionary.putIfAbsent(wordDefinition[0], new ArrayList<>());
            wordsDictionary.get(wordDefinition[0]).add(wordDefinition[1]);
        }

        String[] keyWords = scanner.nextLine().split(" \\| ");

        for (String key : keyWords) {

            if (wordsDictionary.containsKey(key)) {
                System.out.println(key);
                wordsDictionary.get(key).stream().sorted((e1,e2) -> Integer.compare(e2.length(), e1.length())).
                        forEach(e -> System.out.println(" -" + e));
            }
        }

        String command = scanner.nextLine();

        if (command.equals("List")) {
            wordsDictionary.entrySet().stream().forEach(e -> System.out.print(e.getKey() + " "));

        }
    }
}
