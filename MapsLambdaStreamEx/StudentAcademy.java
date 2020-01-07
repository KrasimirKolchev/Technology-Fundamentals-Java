package S_MapsLambdaStreamEx;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);

        }
        Map<String, Double> studentRes = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            studentRes.putIfAbsent(student.getKey(), CalcAverage(student.getValue()));
        }
        studentRes.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).
                filter(e -> e.getValue() >= 4.5).
                forEach(e -> System.out.println(String.format("%s -> %.2f", e.getKey(), e.getValue())));
    }

    public static double CalcAverage(List<Double> values) {
        double result = 0.0;
        for (Double value : values) {
            result += value;
        }
        return result / values.size();
    }
}
