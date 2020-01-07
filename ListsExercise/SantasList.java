package N_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantasList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> kidsNames = Arrays.stream(scanner.nextLine().
                split("&")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Finished!")) {
            String[] input = command.split(" ");

            switch (input[0]) {
                case "Bad" :
                    if (CheckKidName(kidsNames, input)) {
                        break;
                    }
                    kidsNames.add(0, input[1]);
                    break;
                case "Good" :
                    if (CheckKidName(kidsNames, input)) {
                        kidsNames.remove(input[1]);
                    }
                    break;
                case "Rename" :
                    if (CheckKidName(kidsNames, input)) {
                        for (int i = 0; i < kidsNames.size(); i++) {
                            if (input[1].equals(kidsNames.get(i))) {
                                kidsNames.set(i, input[2]);
                                break;
                            }
                        }
                    }
                    break;
                case "Rearrange" :
                    if (CheckKidName(kidsNames, input)) {
                        kidsNames.remove(input[1]);
                        kidsNames.add(input[1]);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println(kidsNames.toString().replaceAll("\\[|\\]", ""));
    }

    public static boolean CheckKidName(List<String> kidsNames, String[] input) {
        return kidsNames.contains(input[1]);
    }
}
