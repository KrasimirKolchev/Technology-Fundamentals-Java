package H_ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] houseNumber = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        int position = 0;
        int size = houseNumber.length - 1;
        String input;

        while (!(input = scanner.nextLine()).equals("Merry Xmas!")) {
            String[] command = input.split(" ");
            int jumpLength = Integer.parseInt(command[1]);


            while (true) {
                if (position + jumpLength <= size) {
                    if (houseNumber[position + jumpLength] <= 0) {
                        System.out.printf("House %d will have a Merry Christmas.\n", houseNumber[position + jumpLength]);
                        break;
                    } else {
                        houseNumber[position + jumpLength] -= 2;
                        position += jumpLength;
                        break;
                    }
                } else if (position + jumpLength > houseNumber.length){

                    if ((position + jumpLength) - houseNumber.length < houseNumber.length) {
                        position = (position + jumpLength) - houseNumber.length;
                        houseNumber[position] -= 2;
                        break;
                    } else if ((position + jumpLength) - houseNumber.length >= houseNumber.length ) {
                        int newPosition = (position + jumpLength) % houseNumber.length;
                        houseNumber[newPosition] -= 2;
                        break;
                    }
                }
            }
        }
        int check = 0;
        for (int number : houseNumber) {
            if (number > 0) {
                check++;
            }
        }
        if (check == 0) {
            System.out.printf("Santa's last position was %d.\nMission was successful.", position);
        } else {
            System.out.printf("Santa's last position was %d.\nSanta has failed %d houses.", position, check);
        }
    }
}
