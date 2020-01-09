package demoMidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrainsOfSand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> grains = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String input;

        while (!"Mort".equals(input = scanner.nextLine())) {
            String[] command = input.split(" ");
            int value = Integer.parseInt(command[1]);

            switch (command[0]) {
                case "Add" :
                    grains.add(Integer.parseInt(command[1]));
                    break;
                case"Remove" :
                    if (grains.contains(value)) {
                        for (int i = 0; i < grains.size(); i++) {
                            if (grains.get(i).equals(value)) {
                                grains.remove(i);
                                break;
                            }
                        }
                    } else if (value >= 0 && value < grains.size()) {
                        grains.remove(value);
                        break;
                    } else {
                        break;
                    }
                    break;
                case "Replace" :
                    if (grains.contains(value)) {
                        for (int i = 0; i < grains.size(); i++) {
                            if (grains.get(i).equals(value)) {
                                grains.set(i, (Integer.parseInt(command[2])));
                                break;
                            }
                        }
                    }
                    break;
                case "Increase" :
                    int increase = 0;
                    if (grains.contains(value)) {
                        for (int i = 0; i < grains.size(); i++) {
                            if (grains.get(i) >= value) {
                                increase = grains.get(i);
                                break;
                            }
                        }
                        for (int i = 0; i < grains.size(); i++) {
                            int amount = grains.get(i);
                            grains.set(i, (amount + increase));
                        }
                    } else {
                        increase = grains.get(grains.size() - 1);
                        for (int i = 0; i < grains.size(); i++) {
                            int amount = grains.get(i);
                            grains.set(i, (amount + increase));
                        }
                    }
                    break;
                case "Collapse" :
                    for (int i = 0; i < grains.size(); i++) {
                        int value2 = grains.get(i);
                        if (value2 < value) {
                            grains.remove(i);
                            i = -1;
                        }
                    }
                    break;
            }
        }
        System.out.println(grains.toString().replaceAll("\\[|,|\\]", ""));
    }
}
