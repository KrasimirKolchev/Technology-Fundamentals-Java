package S_MapsLambdaStreamEx;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> companyUsers = new TreeMap<>();

        String command;

        while (!"End".equals(command = scanner.nextLine())) {
            String[] input = command.split(" -> ");

            companyUsers.putIfAbsent(input[0], new ArrayList<>());

            if (!companyUsers.get(input[0]).contains(input[1])) {
                companyUsers.get(input[0]).add(input[1]);
            }
        }

        companyUsers.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            for (String user : e.getValue()) {
                System.out.println(String.format("-- %s", user));
            }
                });
    }
}
