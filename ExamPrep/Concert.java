package S_MapsLambdaStreamEx;

import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> bandNames = new LinkedHashMap<>();
        Map<String, Integer> bandTime = new LinkedHashMap<>();

        String command;
        long totalTime = 0;

        while(!"start of concert".equals(command = scanner.nextLine())) {
            String[] lineInfo = command.split("; ");

            if (lineInfo[0].equals("Add")) {
                bandNames.putIfAbsent(lineInfo[1], new ArrayList<>());
                String[] members = lineInfo[2].split(", ");

                for (String name : members) {

                    if (!bandNames.get(lineInfo[1]).contains(name)) {
                        bandNames.get(lineInfo[1]).add(name);
                    }
                }
            } else if (lineInfo[0].equals("Play")) {
                bandTime.putIfAbsent(lineInfo[1], 0);
                int time = Integer.parseInt(lineInfo[2]);
                bandTime.put(lineInfo[1], bandTime.get(lineInfo[1]) + time);
                totalTime += Long.parseLong(lineInfo[2]);
            }
        }
        System.out.println("Total time: " + totalTime);
        bandTime.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue(), e1.getValue());

            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).
                forEach(e -> System.out.println(String.format("%s -> %d", e.getKey(), e.getValue())));

        command = scanner.nextLine();
        System.out.println(command);

        for (String member : bandNames.get(command)) {
            System.out.println("=> " + member);
        }
    }
}
