package T_TextProcessingAndRegexEX;

import java.util.*;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] game = scanner.nextLine().split(", ");
        Map<String, Integer> racers = new LinkedHashMap<>();

        for (String player : game) {
            racers.putIfAbsent(player, 0);
        }

        String input;

        while (!"end of race".equals(input = scanner.nextLine())) {


            String numbers = "";
            String player = "";

            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);

                if (Character.isDigit(symbol)) {
                    numbers += input.charAt(i);
                } else if (Character.isAlphabetic(input.charAt(i))) {
                    player += input.charAt(i);
                }
            }

            int sum = 0;

            for (int i = 0; i < numbers.length(); i++) {
                int num = numbers.charAt(i) - 48;
                sum += num;
            }
            if (racers.containsKey(player)) {
                racers.put(player, racers.get(player) + sum);
            }
        }
        List<String> names = new ArrayList<>();
        racers.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).
                limit(3).forEach(e -> names.add(e.getKey()));



        System.out.println(String.format("1st place: %s%n2nd place: %s%n3rd place: %s",
                names.get(0), names.get(1), names.get(2)));

    }
}
