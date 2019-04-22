package demoMidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MemoryView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> memory = new ArrayList<>();
        String input;

        while (!"Visual Studio crash".equals(input = scanner.nextLine())) {
            int[] list = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int item : list) {
                memory.add(item);
            }
        }

        for (int i = 0; i < memory.size(); i++) {

            if (memory.get(i).equals(32656) && memory.get(i + 1).equals(19759)
                    && memory.get(i + 2).equals(32763)) {

                int index = memory.get(i + 4);
                int end = i + 6 + index;
                String text = "";

                for (int j = i + 6; j < end; j++) {
                    int value = memory.get(j);
                    text += (char)value;
                }
                i = end - 1;
                System.out.println(text);
            }
        }
    }
}
