package S_MapsLambdaStreamEx;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestPassword = new LinkedHashMap<>();
        Map<String, Integer> userPoints = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> userContestPoints = new TreeMap<>();

        String input;

        while (!"end of contests".equals(input = scanner.nextLine())) {
            String[] command = input.split(":");

            String contest = command[0];
            String password = command[1];

            contestPassword.put(contest, password);
        }

        while (!"end of submissions".equals(input = scanner.nextLine())) {
            String[] command = input.split("=>");
            String contest = command[0];
            String password = command[1];
            String user = command[2];
            int points = Integer.parseInt(command[3]);

            if (contestPassword.containsKey(contest) && contestPassword.get(contest).equals(password)) {
                userContestPoints.putIfAbsent(user, new LinkedHashMap<>());
                userContestPoints.get(user).putIfAbsent(contest, 0);

                if (userContestPoints.get(user).get(contest) < points) {
                    userContestPoints.get(user).put(contest, points);
                }
            }
        }

        userContestPoints.entrySet().stream().forEach(e -> {
            for (Map.Entry<String, Integer> entry : e.getValue().entrySet()) {
                userPoints.putIfAbsent(e.getKey(), 0);
                userPoints.put(e.getKey(), userPoints.get(e.getKey()) + entry.getValue());
            }
        });

        userPoints.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue(), e1.getValue());
            return sort;
        }).limit(1).forEach(e ->
                System.out.println(String.format("Best candidate is %s with total %d points.%nRanking:", e.getKey(), e.getValue())));

        userContestPoints.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());

            e.getValue().entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue())).
                    forEach(s -> {
                        System.out.println(String.format("#  %s -> %d", s.getKey(), s.getValue()));
                    });

        });
    }
}
