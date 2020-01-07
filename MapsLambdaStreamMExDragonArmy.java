package S_MapsLambdaStreamEx;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<Integer>>> statistic = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] dragon = scanner.nextLine().split(" ");

            if (dragon[2].equals("null")) {
                dragon[2] = "45";
            }
            if (dragon[3].equals("null")) {
                dragon[3] = "250";
            }
            if (dragon[4].equals("null")) {
                dragon[4] = "10";
            }
            statistic.putIfAbsent(dragon[0], new LinkedHashMap<>());
            statistic.get(dragon[0]).putIfAbsent(dragon[1], new ArrayList<>());

            if (statistic.get(dragon[0]).get(dragon[1]).isEmpty()) {
                statistic.get(dragon[0]).get(dragon[1]).add(Integer.parseInt(dragon[2]));
                statistic.get(dragon[0]).get(dragon[1]).add(Integer.parseInt(dragon[3]));
                statistic.get(dragon[0]).get(dragon[1]).add(Integer.parseInt(dragon[4]));
            } else {
                statistic.get(dragon[0]).get(dragon[1]).set(0, Integer.parseInt(dragon[2]));
                statistic.get(dragon[0]).get(dragon[1]).set(1, Integer.parseInt(dragon[3]));
                statistic.get(dragon[0]).get(dragon[1]).set(2, Integer.parseInt(dragon[4]));
            }
        }

        for (Map.Entry<String, Map<String, List<Integer>>> group : statistic.entrySet()) {
            double averageDamage = 0.0;
            double averageHealth = 0.0;
            double averageArmor = 0.0;

            for (Map.Entry<String, List<Integer>> name : statistic.get(group.getKey()).entrySet()) {
                averageDamage += name.getValue().get(0);
                averageHealth += name.getValue().get(1);
                averageArmor += name.getValue().get(2);
            }

            averageDamage = averageDamage / group.getValue().size();
            averageHealth = averageHealth / group.getValue().size();
            averageArmor = averageArmor / group.getValue().size();
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                    group.getKey(), averageDamage, averageHealth, averageArmor));
            group.getValue().entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())).
                    forEach(e -> System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
                            e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2))));
        }
    }
}
