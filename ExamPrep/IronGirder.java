package S_MapsLambdaStreamEx;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.ToIntFunction;

public class IronGirder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> townTime = new LinkedHashMap<>();
        Map<String, Integer> townPassengers = new LinkedHashMap<>();

        String command;

        while (!"Slide rule".equals(command = scanner.nextLine())) {
            String[] input = command.split(":|->");

            String town = input[0];
            int people = Integer.parseInt(input[2]);

            if (input[1].equals("ambush")) {

                if (townTime.containsKey(town) && townPassengers.containsKey(town)) {
                    townTime.put(town, 0);
                    townPassengers.put(town, townPassengers.get(town) - people);
                }

            } else {
                int time = Integer.parseInt(input[1]);
                townTime.putIfAbsent(town, 0);

                if (townTime.get(town) == 0) {
                    townTime.put(town, time);
                } else if (townTime.get(town) > time && townTime.get(town) != 0) {
                    townTime.put(town, time);
                }
                townPassengers.putIfAbsent(town, 0);
                townPassengers.put(town, townPassengers.get(town) + people);
            }
        }

        townTime.entrySet().stream().sorted(Comparator.comparingInt
                ((ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue).thenComparing(Map.Entry::getKey)).
                forEach(e -> {
                    if (e.getValue() != 0 && townPassengers.get(e.getKey()) != 0) {
                        System.out.println(String.format("%s -> Time: %d -> Passengers: %d",
                                e.getKey(), e.getValue(), townPassengers.get(e.getKey())));
                    }
                });
    }
}
