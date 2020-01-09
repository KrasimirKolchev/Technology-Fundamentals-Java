package T_TextProcessingAndRegexEX;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Character> special = new ArrayList<>();
        special.add('s');
        special.add('t');
        special.add('a');
        special.add('r');
        Map<String, List<String>> planets = new TreeMap<>();
        planets.put("A_Overview", new ArrayList<>());
        planets.put("D_DataTypesAndVariables", new ArrayList<>());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int count = 0;

            String decrypt = line.toLowerCase();
            for (int j = 0; j < decrypt.length(); j++) {

                if (special.contains(decrypt.charAt(j))) {
                    count++;
                }
            }

            StringBuilder message = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {
                int value = line.charAt(j);
                char symbol = (char)(value - count);
                message.append(symbol);
            }


            String regex = "@(?<planet>[A-Za-z]+)([^@\\-!:>]*)?:" +
                    "(?<pop>[\\d]+)([^@\\-!:>]*)!(?<side>A|D)!([^@\\-!:>]*)->(?<sold>[\\d]+)([^@\\-!:>]*)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                String side = matcher.group("side");
                String planet = matcher.group("planet");

                planets.get(side).add(planet);
            }
        }

        planets.entrySet().stream().forEach(e -> {
            e.getValue().sort(String::compareTo);
            if (e.getKey().equals("A_Overview")) {
                System.out.println("Attacked planets: " + e.getValue().size());
            } else {
                System.out.println("Destroyed planets: " + e.getValue().size());
            }

            for (String planet : e.getValue()) {
                System.out.println("-> " + planet);
            }
        });
    }
}
