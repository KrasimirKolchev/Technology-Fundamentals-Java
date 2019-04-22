package B_OverviewExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        String logIn = new StringBuffer(userName).reverse().toString();
        int counter = 1;

        while (true) {
            String password = scanner.nextLine();

            if (!password.equals(logIn)) {
                if (counter == 4) {
                    System.out.printf("User %s blocked!", userName);
                    break;
                } else {
                    System.out.println("Incorrect password. Try again.");
                    counter++;
                }
            }
            if (password.equals(logIn)) {
                System.out.printf("User %s logged in.", userName);
                break;
            }
        }
    }
}
