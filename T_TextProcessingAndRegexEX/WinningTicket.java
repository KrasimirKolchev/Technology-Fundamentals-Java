package T_TextProcessingAndRegexEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("\\s*,\\s*");

        for (String ticket : tickets) {

            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String firstPart = ticket.substring(0, 10);
                String secondPart = ticket.substring(10, 20);

                String regex = "([@]{6,10}|[#]{6,10}|[$]{6,10}|[\\^]{6,10})";

                Pattern pattern = Pattern.compile(regex);

                Matcher matcherFirst = pattern.matcher(firstPart);
                Matcher matcherSecond = pattern.matcher(secondPart);

                StringBuilder sb = new StringBuilder();
                sb.append('"');
                sb.append(ticket);
                sb.append('"');

                if (matcherFirst.find() && matcherSecond.find()) {
                    String first = matcherFirst.group();
                    String second = matcherSecond.group();

                    if (first.length() > second.length()) {
                        first = first.substring(0, second.length());
                    } else if (first.length() < second.length()) {
                        second = second.substring(0, first.length());
                    }

                    if (first.equals(second) && (first.length() >= 6 && first.length() <= 9)) {
                        System.out.println(String.format("ticket %s - %d%s",
                                sb, first.length(), first.charAt(0)));

                    } else if (first.equals(second) && (first.length() == 10)) {
                        System.out.println(String.format("ticket %s - %d%s Jackpot!",
                                sb, first.length(), first.charAt(0)));
                    } else {
                        System.out.println(String.format("ticket %s - no match", sb));
                    }
                } else {
                    System.out.println(String.format("ticket %s - no match", sb));
                }
            }
        }
    }
}
