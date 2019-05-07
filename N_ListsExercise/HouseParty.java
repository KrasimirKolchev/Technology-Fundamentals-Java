package N_ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> partyList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            String name = command[0];
            switch (command[2]) {
                case "going!" :
                    if (CheckNameInPartyList(partyList, name)) {
                        System.out.printf("%s is already in the list!%n", name);
                        break;
                    }
                    partyList.add(name);
                    ((ArrayList<String>) partyList).trimToSize();
                    break;
                case "not" :
                    if (CheckNameInPartyList(partyList, name)) {
                        partyList.remove(name);
                        ((ArrayList<String>) partyList).trimToSize();
                        break;
                    }
                    System.out.printf("%s is not in the list!%n", name);
                    break;
                    default:
                        break;
            }
        }
        for (String name : partyList) {
            System.out.printf("%s%n", name);
        }
    }
    private static boolean CheckNameInPartyList(List<String> partyList, String name) {

        return partyList.contains(name);
    }
}
