package S_MapsLambdaStreamEx;

import java.util.*;
import java.util.stream.Collectors;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> forces = new LinkedHashMap<>();

        String command;

        while (!"Lumpawaroo".equals(command = scanner.nextLine())) {
            List<String> check = Arrays.stream(command.split("")).collect(Collectors.toList());

            String force;
            String player;
            if (check.contains("|")) {
                String[] input = command.split(" \\| ");
                force = input[0];
                player = input[1];

                if (!forces.containsKey(force)) {
                    forces.put(force, new ArrayList<>());
                }
                if (!forces.get(force).contains(player)) {
                    forces.get(force).add(player);
                }
            } else {
                String[] input = command.split(" -> ");
                force = input[1];
                player = input[0];

                forces.entrySet().stream().forEach(e -> e.getValue().remove(player));
                forces.get(force).add(player);
                System.out.println(String.format("%s joins the %s side!", player, force));


            }
        }
        forces.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());
            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).forEach(e -> {
            if (e.getValue().size() != 0) {
                System.out.println(String.format("Side: %s, Members: %d", e.getKey(), e.getValue().size()));
                e.getValue().sort(String::compareTo);
                for (String name : e.getValue()) {
                    System.out.println("! " + name);
                }
            }
        });
    }
}
