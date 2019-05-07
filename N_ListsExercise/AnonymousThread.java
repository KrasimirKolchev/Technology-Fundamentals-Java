package N_ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("3:1")) {
                break;
            }

            String[] command = input.split(" ");

            switch (command[0]) {
                case "merge" :
                    MergeData(data, command);
                    break;
                case "divide" :
                    DivideData(data, command);
                    break;
            }
        }
        System.out.println(data.toString().replaceAll("\\[|,|\\]", ""));
    }

    private static List<String> DivideData(List<String> data, String[] command) {
        int firstIndex = 0;
        List<String> dividedData = new ArrayList<>();
        String textToDivide = data.get(Integer.parseInt(command[1]));
        double textLength = textToDivide.length();
        double partSize = Math.round(textLength / (Integer.parseInt(command[2])));
        if (partSize < 1) {
            partSize = 1;
        }
        if (partSize == 1) {
            textLength -=1;
        }
        int counter = 0;

        if ((Integer.parseInt(command[2])) > 0) {
            while (counter < (Integer.parseInt(command[2]))) {

                String part = textToDivide.substring(firstIndex, (int)(firstIndex + partSize));
                firstIndex += partSize;
                if (firstIndex + partSize > textLength) {
                    part += textToDivide.substring(firstIndex, textToDivide.length());
                    dividedData.add(part);
                    break;
                }
                dividedData.add(part);
                counter++;
            }

            data.remove(Integer.parseInt(command[1]));
            for (int i = 0; i < dividedData.size(); i++) {
                data.add((Integer.parseInt(command[1]) + i), (dividedData.get(i)));
            }
        }

        return data;
    }

    private static List<String> MergeData(List<String> data, String[] command) {
        int startIndex = Integer.parseInt(command[1]);
        int endIndex = Integer.parseInt(command[2]);
        List <String> mergedData = new ArrayList<>();

        if (startIndex >= 0 && endIndex < data.size()) {
            for (int i = startIndex; i <= endIndex; i++) {
                mergedData.add(data.get(i));
            }
            data.removeAll(mergedData);
            data.add(startIndex, (mergedData.toString().replaceAll("\\[|,|\\]| ", "")));
        } else if (startIndex >= data.size() - 1 && endIndex > data.size()) {
            return data;
        } else if (startIndex < 0 && endIndex < data.size()) {
            for (int i = 0; i <= endIndex; i++) {
               mergedData.add(data.get(i));
            }
            data.removeAll(mergedData);
            data.add(0, (mergedData.toString().replaceAll("\\[|,|\\]| ", "")));
        } else if (startIndex >= 0 && endIndex >= data.size() - 1) {
            for (int i = startIndex; i < data.size(); i++) {
               mergedData.add(data.get(i));
            }
            data.removeAll(mergedData);
            data.add(startIndex, (mergedData.toString().replaceAll("\\[|,|\\]| ", "")));
        } else if (startIndex < 0 && endIndex >= data.size() - 1) {
            for (int i = 0; i < data.size(); i++) {
                mergedData.add(data.get(i));
            }
            data.removeAll(mergedData);
            data.add(mergedData.toString().replaceAll("\\[|,|\\]| ", ""));
        }
        return data;
    }
}
