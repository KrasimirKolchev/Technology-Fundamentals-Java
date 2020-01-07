package S_MapsLambdaStreamEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MeTubeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> videoViews = new LinkedHashMap<>();
        Map<String, Integer> videoLikes = new LinkedHashMap<>();

        String command;

        while (!"stats time".equals(command = scanner.nextLine())) {

            if (command.contains("-")) {
                String[] input = command.split("-");
                videoViews.putIfAbsent(input[0], 0);
                videoViews.put(input[0], videoViews.get(input[0]) + Integer.parseInt(input[1]));
                videoLikes.putIfAbsent(input[0], 0);
            } else if (command.contains(":")) {
                String[] input = command.split(":");

                if (videoViews.containsKey(input[1])) {
                    if (input[0].equals("like")) {
                        videoLikes.put(input[1], videoLikes.get(input[1]) + 1);
                    } else if (input[0].equals("dislike")) {
                        videoLikes.put(input[1], videoLikes.get(input[1]) - 1);
                    }
                }
            }
        }

        command = scanner.nextLine();

        if (command.equals("by views")) {
            videoViews.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).
                    forEach(e ->
                            System.out.println(String.format("%s - %d views - %d likes",
                                                                e.getKey(),
                                                                e.getValue(),
                                                                videoLikes.get(e.getKey()))));
        } else if (command.equals("by likes")) {
            videoLikes.entrySet().stream().sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                    .forEach(s ->
                            System.out.println(String.format("%s - %d views - %d likes",
                                                                s.getKey(),
                                                                videoViews.get(s.getKey()),
                                                                s.getValue())));
        }
    }
}
