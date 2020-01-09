package T_TextProcessingAndRegexEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int dish = 0;
        int laund = 0;
        int cleaning = 0;
        String input;

        while (!"wife is happy".equals(input = scanner.nextLine())) {

            int time = 0;
            String regexD = "<(?<dishes>([a-z0-9]+))>";

            Pattern patternD = Pattern.compile(regexD);
            Matcher matcherD = patternD.matcher(input);

            while (matcherD.find()) {
                String dishes = matcherD.group("dishes");

                for (int i = 0; i < dishes.length(); i++) {

                    if (Character.isDigit(dishes.charAt(i))) {
                        time += dishes.charAt(i) - 48;
                    }
                }
                dish += time;
            }

            String regexC = "\\[(?<clean>([A-Z0-9]+))\\]";

            Pattern patternC = Pattern.compile(regexC);
            Matcher matcherC = patternC.matcher(input);

            while (matcherC.find()) {
                String clean = matcherC.group("clean");

                for (int i = 0; i < clean.length(); i++) {

                    if (Character.isDigit(clean.charAt(i))) {
                        time += clean.charAt(i) - 48;
                    }
                }
                cleaning += time;
            }

            String regexL = "\\{(?<laundry>([\\D0-9]+))}";

            Pattern patternL = Pattern.compile(regexL);
            Matcher matcherL = patternL.matcher(input);

            while (matcherL.find()) {
                String laundry = matcherL.group("laundry");

                for (int i = 0; i < laundry.length(); i++) {

                    if (Character.isDigit(laundry.charAt(i))) {
                        time += laundry.charAt(i) - 48;
                    }
                }
                laund += time;
            }
        }
        System.out.println(String.format("Doing the dishes - %d min.", dish));
        System.out.println(String.format("Cleaning the house - %d min.", cleaning));
        System.out.println(String.format("Doing the laundry - %d min.", laund));
        System.out.println(String.format("Total - %d min.", dish + cleaning + laund));
    }
}


