package S_MapsLambdaStreamEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SantaNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> childAmount = new LinkedHashMap<>();
        Map<String, Integer> toyAmount = new LinkedHashMap<>();

        String command;

        while(!"END".equals(command = scanner.nextLine())) {
            String[] input = command.split("->");

            if (!input[0].equals("Remove")) {
                childAmount.putIfAbsent(input[0], 0);
                toyAmount.putIfAbsent(input[1], 0);
                childAmount.put(input[0], childAmount.get(input[0]) + Integer.parseInt(input[2]));
                toyAmount.put(input[1], toyAmount.get(input[1]) + Integer.parseInt(input[2]));
            } else {
                childAmount.remove(input[1]);
            }
        }

        System.out.println("Children:");
        childAmount.entrySet().stream().sorted((a,b) -> {
            int sort = Integer.compare(b.getValue(), a.getValue());

            if (sort == 0) {
                sort = a.getKey().compareTo(b.getKey());
            }
            return sort;
        }).forEach(s -> System.out.println(String.format("%s -> %d", s.getKey(), s.getValue())));

        System.out.println("Presents:");
        toyAmount.forEach((key, value) -> System.out.println(String.format("%s -> %d", key, value)));
    }
}
