package S_MapsLambdaStreamEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinersTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String command;

        while (!"stop".equals(command = scanner.nextLine())) {


            int amount = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(command)) {
                resources.put(command, 0);
            }
            resources.put(command, resources.get(command) + amount);
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
