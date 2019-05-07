package MidExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> paintings = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String input;

        while (!"END".equals(input = scanner.nextLine())) {
            String[] command = input.split(" ");
            int number1 = 0;

            switch (command[0]) {
                case "Change" :
                    number1 = Integer.parseInt(command[1]);
                    if (paintings.contains(number1)) {

                        for (int i = 0; i < paintings.size(); i++) {
                            if (paintings.get(i).equals(number1)) {
                                paintings.set(i, Integer.parseInt(command[2]));
                                break;
                            }
                        }
                    }
                    break;
                case "Hide" :
                    number1 = Integer.parseInt(command[1]);
                    if (paintings.contains(number1)) {
                        int ind = paintings.indexOf(number1);
                        paintings.remove(ind);
                    }
                    break;
                case "Switch" :
                    number1 = Integer.parseInt(command[1]);
                    int number2 = Integer.parseInt(command[2]);
                    int index = paintings.indexOf(number1);
                    if (paintings.contains(number1) && paintings.contains(number2)) {
                        paintings.set(paintings.indexOf(number2), number1);
                        paintings.set(index, number2);
                    }
                    break;
                case "Insert" :
                    number1 = Integer.parseInt(command[1]);
                    if (number1 + 1 < paintings.size() && number1 + 1 >= 0) {
                        paintings.add(number1 + 1, Integer.parseInt(command[2]));
                    }
                    break;
                case "Reverse" :
                    Collections.reverse(paintings);
                    break;
            }
        }
        System.out.println(paintings.toString().replaceAll("\\[|,|\\]", ""));
    }
}
