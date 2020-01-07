package S_MapsLambdaStreamEx;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine().split(", ");
        Map<String, Double> games = new LinkedHashMap<>();
        Map<String, Double> gamesDLC = new LinkedHashMap<>();

        for (String gameInfo : inputLine) {

            if (gameInfo.contains("-")) {
                String[] input = gameInfo.split("-");
                games.put(input[0], Double.parseDouble(input[1]));
            } else {
                String[] input = gameInfo.split(":");
                if (games.containsKey(input[0])) {
                    String newGame = input[0] + " - " + input[1];
                    gamesDLC.put(newGame, games.get(input[0]) * 1.2);
                    games.remove(input[0]);
                }
            }
        }

        gamesDLC.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).
                forEach(e -> System.out.println(String.format("%s - %.2f", e.getKey(), e.getValue() / 2)));
        games.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).
                forEach(e -> System.out.println(String.format("%s - %.2f", e.getKey(), e.getValue() - (e.getValue() / 5))));
    }
}
