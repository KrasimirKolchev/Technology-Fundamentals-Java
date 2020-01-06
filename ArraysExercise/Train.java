package H_ArraysExercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagonsCount = Integer.parseInt(scanner.nextLine());
        int wagonCapacity = 0;
        int[] wagonTotal = new int[wagonsCount];

        for (int i = 0; i < wagonsCount; i++) {
            int wagon = Integer.parseInt(scanner.nextLine());
            wagonCapacity += wagon;
            wagonTotal[i] += wagon;
        }
        for (int wagon : wagonTotal) {
            System.out.print(wagon + " ");
        }
        System.out.print("\n" + wagonCapacity);
    }
}
