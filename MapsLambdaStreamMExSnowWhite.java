package S_MapsLambdaStreamEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Map<String, Integer> hatDwarfPhysic = new LinkedHashMap<>();

        while (!"Once upon a time".equals(input = scanner.nextLine())) {

            String regex = "(?<name>[^\\s<>:]+) <:> (?<hat>[^\\s<>:]+) <:> (?<ph>[\\d]+)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {

                String name = matcher.group("name");
                String hat = matcher.group("hat");
                String hatName = hat + " " + name;
                int physics = Integer.parseInt(matcher.group("ph"));

                hatDwarfPhysic.putIfAbsent(hatName, 0);


                if (hatDwarfPhysic.get(hatName) < physics) {
                    hatDwarfPhysic.put(hatName, physics);
                }
            }
        }


    }
}
