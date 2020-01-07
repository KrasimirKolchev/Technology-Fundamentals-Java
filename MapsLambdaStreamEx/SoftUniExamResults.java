package S_MapsLambdaStreamEx;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> usersPoints = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languageSubmissions = new LinkedHashMap<>();

        String command;

        while (!"exam finished".equals(command = scanner.nextLine())) {
            String[] input = command.split("-");
            String user = input[0];

            if (input[1].equals("banned")) {
                usersPoints.remove(user);
                break;
            }

            String language = input[1];
            int examRes = Integer.parseInt(input[2]);

            usersPoints.putIfAbsent(user, 0);

            if (examRes > usersPoints.get(user)) {
                usersPoints.put(user, examRes);
            }

            languageSubmissions.putIfAbsent(language, 0);
            languageSubmissions.put(language, languageSubmissions.get(language) + 1);
        }
        System.out.println("Results:");
        usersPoints.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue(), e1.getValue());
            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).forEach(e -> System.out.println(String.format("%s | %d", e.getKey(), e.getValue())));
        System.out.println("Submissions:");
        languageSubmissions.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue(), e1.getValue());
            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).forEach(e -> System.out.println(String.format("%s - %d", e.getKey(), e.getValue())));
    }
}
