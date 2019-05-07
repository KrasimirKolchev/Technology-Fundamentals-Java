package T_TextProcessingAndRegexEX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total = 0;

        List<String> itemsBought = new ArrayList<>();

        String regex = "(>{2})(?<p>([A-Za-z ]+))(<{2})(?<pr>(\\d+|\\d*\\.\\d+))(!)(?<q>[\\d]+)";
        String purchase;

        while (!"Purchase".equals(purchase = scanner.nextLine())) {

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(purchase);

            if (matcher.find()) {
                String product = matcher.group("p");
                double price = Double.parseDouble(matcher.group("pr"));
                int quantity = Integer.parseInt(matcher.group("q"));

                total += price * quantity;
                itemsBought.add(product);
            }
        }

        System.out.println("Bought furniture:");
        for (String item : itemsBought) {
            System.out.println(item);
        }

        System.out.printf("Total money spend: %.2f",total);
    }
}
