package T_TextProcessingAndRegexEX;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> demonsBook = new TreeMap<>();

        String[] demons = scanner.nextLine().split(",");


        for (String names : demons) {
            String name = names.replaceAll(" ", "");

            demonsBook.putIfAbsent(name, new ArrayList<>());
            double health = 0;

            String regexHealth = "(?<health>[^+\\-*\\/.\\d*])";

            Pattern patternHealth = Pattern.compile(regexHealth);
            Matcher matcherHealth = patternHealth.matcher(name);

            String symbols = "";
            while (matcherHealth.find()) {
                symbols += matcherHealth.group("health");
            }
            for (int i = 0; i < symbols.length(); i++) {
                int symbol = symbols.charAt(i);
                health += symbol;
            }

            demonsBook.get(name).add(health);

            String regex = "(?<damage>((?:-|\\+|)\\d+(?:\\.*?\\d+)*))";

            Pattern pattern1 = Pattern.compile(regex);
            Matcher matcher1 = pattern1.matcher(name);
            double damage = 0.0;

            while (matcher1.find()) {

                damage += Double.parseDouble(matcher1.group("damage"));
            }

            for (int i = 0; i < name.length(); i++) {

                if (name.charAt(i) == '*') {
                    damage = damage * 2;
                } else if (name.charAt(i) == '/') {
                    damage = damage / 2;
                }
            }

            demonsBook.get(name).add(damage);
        }
        demonsBook.entrySet().stream().forEach(e -> {
            double heal = e.getValue().get(0);
            int health = (int)heal;
                    System.out.println(String.format("%s - %d health, %.2f damage", e.getKey(), health, e.getValue().get(1)));
                });
    }
}
