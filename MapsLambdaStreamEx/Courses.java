package S_MapsLambdaStreamEx;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input;

        while (!"end".equals(input = scanner.nextLine())) {
            String[] command = input.split(" : ");

            courses.putIfAbsent(command[0], new ArrayList<>());
            courses.get(command[0]).add(command[1]);
        }

        courses.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());

            return sort;
        }).forEach(e -> {
            System.out.println(String.format("%s: %d", e.getKey(), e.getValue().size()));
            e.getValue().sort((e1, e2) -> e1.compareTo(e2));
            for (String name : e.getValue()) {
                System.out.println("-- " + name);
            }
                });
    }
}
