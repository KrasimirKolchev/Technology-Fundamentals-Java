package S_MapsLambdaStreamEx;

import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> usernameContest = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> statistics = new LinkedHashMap<>();

        String command;
        while (!"no more time".equals(command = scanner.nextLine())) {
            String[] input = command.split(" -> ");

            String contest = input[1];
            String user = input[0];
            int points = Integer.parseInt(input[2]);

            usernameContest.putIfAbsent(contest, new TreeMap<>());
            usernameContest.get(contest).putIfAbsent(user, 0);
            statistics.putIfAbsent(user, 0);
            if (usernameContest.get(contest).get(user) < points) {
                usernameContest.get(contest).put(user, points);
            }

        }

        for (String contest : usernameContest.keySet()) {
            for (String name : usernameContest.get(contest).keySet()) {
                statistics.put(name, statistics.get(name) + usernameContest.get(contest).get(name));
            }
        }

        Map<String, Integer> sorted = new LinkedHashMap<>();
        usernameContest.entrySet().stream().forEach(e -> {
            System.out.println(String.format("%s: %d participants", e.getKey(), e.getValue().size()));

            usernameContest.get(e.getKey()).entrySet().stream().sorted((s1, s2) -> {
                int sort = Integer.compare(s2.getValue(), s1.getValue());
                if (sort == 0) {
                    sort = s1.getKey().compareTo(s2.getKey());
                }
                return sort;
            }).forEach(s -> {
                sorted.put(s.getKey(), s.getValue());
            });
            int i = 1;
            for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
                System.out.println(String.format("%d. %s <::> %d", i, entry.getKey(), entry.getValue()));
                i++;
            }
            sorted.clear();
        });
        System.out.println("Individual standings:");
        statistics.entrySet().stream().sorted((a1, a2) -> {
            int sort = Integer.compare(a2.getValue(), a1.getValue());
            if (sort == 0) {
                sort = a1.getKey().compareTo(a2.getKey());
            }
            return sort;
        }).forEach(a -> {
            sorted.put(a.getKey(), a.getValue());
        });
        int i = 1;
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(String.format("%d. %s -> %d", i, entry.getKey(), entry.getValue()));
            i++;
        }
    }
}
