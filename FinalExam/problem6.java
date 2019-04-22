package FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> unfedAnimals = new LinkedHashMap<>();

        String line;
        while (!"Last Info".equals(line = scanner.nextLine())) {
            String[] info = line.split(":");

            if (info[0].equals("Add")) {
                unfedAnimals.putIfAbsent(info[3], new LinkedHashMap<>());
                unfedAnimals.get(info[3]).putIfAbsent(info[1], 0);
                unfedAnimals.get(info[3]).put(info[1], unfedAnimals.get(info[3]).get(info[1]) + Integer.parseInt(info[2]));

            } else if (info[0].equals("Feed")) {
                unfedAnimals.get(info[3]).put(info[1], unfedAnimals.get(info[3]).get(info[1]) - Integer.parseInt(info[2]));

                if (unfedAnimals.get(info[3]).get(info[1]) <= 0) {
                    unfedAnimals.get(info[3]).remove(info[1]);
                    if (unfedAnimals.get(info[3]).size() == 0) {
                        unfedAnimals.remove(info[3]);
                    }
                    System.out.println(String.format("%s was successfully fed", info[1]));
                }
            }
        }

        System.out.println("Areas with hungry animals:");
        unfedAnimals.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(String.format("%s : %d", e.getKey(), e.getValue().size()));

                });
    }
}
