package J_Methods;

import java.util.Scanner;

public class CalculateRectangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int area = calcArea(width, height);

        System.out.println(area);
    }

    static int calcArea(int width, int height) {
    int result = width * height;

    return result;
    }
}
