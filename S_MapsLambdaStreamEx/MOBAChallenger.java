package S_MapsLambdaStreamEx;

import java.util.*;
import java.util.stream.Collectors;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> plPosPoint = new LinkedHashMap<>();

        String command;

        while (!"Season end".equals(command = scanner.nextLine())) {
            List<String> input = Arrays.stream(command.split(" -> ")).collect(Collectors.toList());


            if (input.size() == 3) {
                String player = input.get(0);
                String position = input.get(1);
                int points = Integer.parseInt(input.get(2));

                plPosPoint.putIfAbsent(player, new LinkedHashMap<>());
                plPosPoint.get(player).putIfAbsent(position, 0);

                if (plPosPoint.get(player).containsKey(position) && plPosPoint.get(player).get(position) < points) {
                    plPosPoint.get(player).put(position, points);

                }

            } else {
                input.clear();
                input = Arrays.stream(command.split(" vs ")).collect(Collectors.toList());

                String player1 = input.get(0);
                String player2 = input.get(1);

                if (plPosPoint.containsKey(player1) && plPosPoint.containsKey(player2) &&
                        CommonPosition(plPosPoint, player1, player2)) {

                    for (Map.Entry<String, Integer> game1 : plPosPoint.get(player1).entrySet()) {
                        if (plPosPoint.containsKey(player1) && plPosPoint.containsKey(player2)) {
                            for (Map.Entry<String, Integer> game2 : plPosPoint.get(player2).entrySet()) {
                                if (game1.getKey().contains(game2.getKey())) {
                                    if (game1.getValue() > game2.getValue()) {
                                        plPosPoint.remove(player2);
                                        break;
                                    } else if (game1.getValue() < game2.getValue()) {
                                        plPosPoint.remove(player1);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Map<String, Integer> playerPoints = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : plPosPoint.entrySet()) {
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                playerPoints.putIfAbsent(entry.getKey(), 0);
                playerPoints.put(entry.getKey(), playerPoints.get(entry.getKey()) + entry1.getValue());
            }
        }

        playerPoints.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue(), e1.getValue());
            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).forEach(e -> {
            System.out.println(String.format("%s: %d skill", e.getKey(), e.getValue()));

            plPosPoint.get(e.getKey()).entrySet().stream().sorted((s1, s2) -> {
                    int sort = Integer.compare(s2.getValue(), s1.getValue());
                    if (sort == 0) {
                        sort = s1.getKey().compareTo(s2.getKey());
                    }
                    return sort;
            }).forEach(s -> System.out.println(String.format("- %s <::> %d", s.getKey(), s.getValue())));
        });

    }

    private static boolean CommonPosition(Map<String, Map<String, Integer>> plPosPoint, String player1, String player2) {

        for (String key1 : plPosPoint.get(player1).keySet()) {
            for (String key2 : plPosPoint.get(player2).keySet()) {

                if (key1.equals(key2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
