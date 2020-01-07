package S_MapsLambdaStreamEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> orderPrice = new LinkedHashMap<>();
        Map<String, Integer> ordersQuantity = new LinkedHashMap<>();


        String input;
        while (!"buy".equals(input = scanner.nextLine())) {
            String[] command = input.split("\\s+");

            String product = command[0];
            double price = Double.parseDouble(command[1]);
            int quantity = Integer.parseInt(command[2]);

            if (!orderPrice.containsKey(product)) {
                orderPrice.put(product, price);
                ordersQuantity.put(product, 0);
                ordersQuantity.put(product, ordersQuantity.get(product) + quantity);
            } else {
                orderPrice.put(product, price);
                ordersQuantity.put(product, ordersQuantity.get(product) + quantity);
            }
        }
        for (Map.Entry<String, Double> entry : orderPrice.entrySet()) {
            String product = entry.getKey();
            double result = entry.getValue() * ordersQuantity.get(product);
            System.out.println(String.format("%s -> %.2f", product, result));
        }
    }
}
