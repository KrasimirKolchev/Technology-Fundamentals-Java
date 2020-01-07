package Q_ObjectAndClassesEx.Students3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Students3> students3 = new ArrayList<>();
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split(" ");

            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);

            Students3 student = new Students3(firstName, lastName, grade);

            students3.add(student);
        }
        students3.stream().sorted(Comparator.comparing(Students3::getGrade).reversed()).
                forEach(s -> System.out.println(s));
    }
}
