package N_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QuestsJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> quests = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Retire!")) {
                break;
            }

            String[] command = input.split(" - ");
            String quest = command[1];

            switch (command[0]) {
                case "Start" :
                    if (quests.contains(quest)) {
                        break;
                    }
                    quests.add(quest);
                    break;
                case "Complete" :
                    if (quests.contains(quest)) {
                        quests.remove(quest);
                    }
                    break;
                case "Side Quest" :
                    String[] twoQuests = command[1].split(":");
                    quest = twoQuests[0];
                    String sideQuest = twoQuests[1];
                    if (quests.contains(quest) && !quests.contains(sideQuest)) {
                        int index = quests.indexOf(quest);
                        if (index + 1 < quests.size()) {
                            quests.add((index + 1), sideQuest);
                        } else {
                            quests.add(sideQuest);
                        }
                    }

                    break;
                case "Renew" :
                    if (quests.contains(quest)) {
                        quests.remove(quest);
                        quests.add(quest);
                    }
                    break;
            }
        }
        System.out.println(quests.toString().replaceAll("\\[|\\]", ""));
    }

}
