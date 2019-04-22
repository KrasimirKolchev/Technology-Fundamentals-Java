package A_Overview;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        minutes += 30;

        if (minutes >= 60) {
            minutes = minutes % 60;
            hours = hours + 1;
        }
        String minFormat = "";
        if (minutes < 10) {
            minFormat = "0" + minutes;
        }
        else {
            minFormat = "" + minutes;
        }
        if (hours >= 24) {
            hours = hours - 24;
        }
        System.out.printf("%d:%s", hours, minFormat);
    }
}
