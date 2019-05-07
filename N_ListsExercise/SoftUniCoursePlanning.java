package N_ListsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("course start")) {
                break;
            }

            String[] command = input.split(":");

            switch (command[0]) {
                case "Add" :
                    if (lessons.contains(command[1])) {
                        break;
                    }
                    lessons.add(command[1]);
                    break;
                case "Insert" :
                    if (lessons.contains(command[1])) {
                        break;
                    }
                    lessons.add((Integer.parseInt(command[2])), command[1]);
                    break;
                case "Remove" :
                    if (lessons.contains(command[1])) {
                        lessons.remove(command[1]);
                    }
                    if (lessons.contains(command[1] + "-Exercise")) {
                        lessons.remove(command[1] + "-Exercise");
                    }
                    break;
                case "Swap" :
                    if (lessons.contains(command[1]) && (lessons.contains(command[2]))) {
                        Collections.swap(lessons, (lessons.indexOf(command[1])), (lessons.indexOf(command[2])));
                    }
                    if (lessons.contains(command[1] + "-Exercise")) {
                        int index = lessons.indexOf(command[1]);
                        lessons.remove((command[1] + "-Exercise"));
                        lessons.add((index + 1), (command[1] + "-Exercise"));
                    } else if (lessons.contains(command[2] + "-Exercise")) {
                        int index = lessons.indexOf(command[2]);
                        lessons.remove((command[2] + "-Exercise"));
                        lessons.add((index + 1), (command[2] + "-Exercise"));
                    }
                    break;
                case "Exercise" :
                    if (lessons.contains(command[1])) {
                        if (lessons.contains(command[1] + "-Exercise")) {
                            break;
                        } else {
                            int index = lessons.indexOf(command[1]);
                            if ((index + 1) >= lessons.size()) {
                                lessons.add(command[1] + "-Exercise");
                            } else {
                                lessons.add((index + 1), command[1] + "-Exercise");
                            }
                        }
                    } else {
                        String exercise = command[1] + "-Exercise";
                        lessons.add(command[1]);
                        lessons.add(exercise);
                    }
                    break;
            }
        }


        for (int i = 0; i < lessons.size(); i++) {
            String lesson = lessons.get(i);
            System.out.printf("%d.%s%n", i + 1, lesson);
        }
    }


}
