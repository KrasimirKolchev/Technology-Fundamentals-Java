package O_ListsMoreEx;

import java.util.*;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> initialDrums = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> currentDrums = new ArrayList<>(initialDrums);
        Collections.copy(currentDrums, initialDrums);
        String input;

        while(!"Hit it again, Gabsy!".equals(input = scanner.nextLine())) {
            int power = Integer.parseInt(input);

            for (int i = 0; i < currentDrums.size(); i++) {
                currentDrums.set(i, (currentDrums.get(i) - power));
            }
            for (int i = 0; i < currentDrums.size(); i++) {
                int drumPower = currentDrums.get(i);
                if (drumPower <= 0) {

                    if ((savings - initialDrums.get(i) * 3) > 0) {
                        currentDrums.set(i, (initialDrums.get(i)));
                        savings -= initialDrums.get(i) * 3;
                    } else {
                        currentDrums.remove(i);
                        initialDrums.remove(i);
                    }
                }
            }
        }
        System.out.println(currentDrums.toString().replaceAll("\\[|,|\\]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
