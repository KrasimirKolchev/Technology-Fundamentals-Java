package Q_ObjectAndClassesEx.OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<OrderByAge> orderByAgeList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] inputData = input.split(" ");

            String name = inputData[0];
            String personalID = inputData[1];
            int age = Integer.parseInt(inputData[2]);

            OrderByAge orderByAge = new OrderByAge(name, personalID, age);

            orderByAgeList.add(orderByAge);

            input = scanner.nextLine();
        }
        orderByAgeList.stream().sorted(Comparator.comparing(OrderByAge::getAge)).
                forEach(orderByAge -> System.out.println(orderByAge));
    }
}
