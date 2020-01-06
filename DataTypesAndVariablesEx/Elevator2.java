package E_DataTypesAndVariablesEx;

import java.util.Scanner;

public class Elevator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int courses = people / capacity;
        if ((double) people % capacity != 0) {
            courses += 1;
        }
        System.out.println(courses);
    }
}
