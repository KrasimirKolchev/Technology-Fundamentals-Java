package MidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\|")).
                collect(Collectors.toList());

        double budget = Double.parseDouble(scanner.nextLine());
        double sum = 0;
        double budgetsum = budget;
        List<Double> newItems = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String input = list.get(i);
            String[] command = input.split("->");
            double price = 0;

            switch (command[0]) {
                case "Clothes" :
                    price = Double.parseDouble(command[1]);
                    if (price > 50.0) {
                        break;
                    }
                    if (budget - price >= 0) {
                        budget -= price;
                        double newPrice = price + (price * 0.4);
                        sum += price * 0.4;
                        newItems.add(newPrice);
                    }
                    break;
                case "Shoes" :
                    price = Double.parseDouble(command[1]);
                    if (price > 35.0) {
                        break;
                    }
                    if (budget - price >= 0) {
                        budget -= price;
                        double newPrice = price + (price * 0.4);
                        sum += price * 0.4;
                        newItems.add(newPrice);
                    }
                    break;
                case "Accessories" :
                    price = Double.parseDouble(command[1]);
                    if (price > 20.50) {
                        break;
                    }
                    if (budget - price >= 0) {
                        budget -= price;
                        double newPrice = price + (price * 0.4);
                        sum += price * 0.4;
                        newItems.add(newPrice);
                    }
                    break;
            }
        }
        double newbudget = 0;
        for (int i = 0; i < newItems.size(); i++) {
            double item = newItems.get(i);
            newbudget += item;
            System.out.printf("%.2f ", item);
        }
        newbudget += budget;
        System.out.printf("%nProfit: %.2f%n", sum);
        if (newbudget > 150.0) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }
}
