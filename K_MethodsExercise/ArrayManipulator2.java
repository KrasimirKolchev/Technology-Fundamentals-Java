package K_MethodsExercise;

import java.util.*;

public class ArrayManipulator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");

            switch (command[0]){
                case "exchange" :
                    int times = Integer.parseInt(command[1]);

                    if (times < 0 || times > numbers.length - 1) {
                        System.out.println("Invalid index");
                        break;
                    } else {

                        for (int i = 0; i <= times; i++) {
                            int temp = numbers[0];

                            for (int j = 0; j < numbers.length - 1; j++) {
                                numbers[j] = numbers[j + 1];
                            }
                            numbers[numbers.length - 1] = temp;
                        }
                    }
                case "max" :
                    MaxEvenMaxOdd(numbers, command);
                    break;
                case "min" :
                    MinEvenMinOdd(numbers, command);
                    break;
                case "first" :
                    int command1 = Integer.parseInt(command[1]);
                    if (command1 > numbers.length) {
                        System.out.println("Invalid count");
                        break;
                    } else {
                        FirstEvenFirstOdd(numbers, command);
                        break;
                    }
                case "last" :
                    int command2 = Integer.parseInt(command[1]);
                    if (command2 > numbers.length) {
                        System.out.println("Invalid count");
                        break;
                    } else {
                        LastEvenLastOdd(numbers, command);
                        break;
                    }
            }

            input = scanner.nextLine();
        }
        String text = "";
        for (int i = 0; i < numbers.length; i++) {
            text += numbers[i];
            if (i < numbers.length - 1) {
                text += ", ";
            } else {
                break;
            }
        }
        System.out.println("[" + text + "]");
    }

    static void MaxEvenMaxOdd(int[] numbers, String[] command) {
        int index = -1;
        switch (command[1]) {
            case "even":
                int evenMax = Integer.MIN_VALUE;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 == 0) {
                        if (numbers[i] >= evenMax) {
                            evenMax = numbers[i];
                            index = i;
                        }
                    }
                }
                if (evenMax == Integer.MIN_VALUE) {
                    System.out.println("No matches");
                    break;
                } else {
                    System.out.println(index);
                    break;
                }
            case "odd" :
                int oddMax = Integer.MIN_VALUE;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 != 0) {
                        if (numbers[i] >= oddMax) {
                            oddMax = numbers[i];
                            index = i;
                        }
                    }
                }
                if (oddMax == Integer.MIN_VALUE) {
                    System.out.println("No matches");
                    break;
                } else {
                    System.out.println(index);
                    break;
                }
                default:
                    break;
        }
    }

    static void MinEvenMinOdd(int[] numbers, String[] command) {
        int index = -1;
        switch (command[1]){
            case "even" :
            int evenMin = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    if (numbers[i] <= evenMin) {
                        evenMin = numbers[i];
                        index = i;
                    }
                }
            }
            if (evenMin == Integer.MAX_VALUE) {
                System.out.println("No matches");
                break;
            } else {
                System.out.println(index);
                break;
            }
            case "odd" :
            int oddMin = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0) {
                    if (numbers[i] <= oddMin) {
                        oddMin = numbers[i];
                        index = i;
                    }
                }
            }
            if (oddMin == Integer.MAX_VALUE) {
                System.out.println("No matches");
                break;
            } else {
                System.out.println(index);
                break;
            }
        }
    }

    static void FirstEvenFirstOdd(int[] numbers, String[] command) {
        List<Integer> output = new ArrayList<> ();
        int times = Integer.parseInt(command[1]);
        int counter = 0;
        switch (command[2]) {
            case "even" :
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 == 0) {
                        output.add(numbers[i]);
                        counter++;
                        if (counter == times) {
                            break;
                        }
                    }
                }
                System.out.println(output);
                break;

            case "odd" :
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] % 2 != 0) {
                        output.add(numbers[i]);
                        counter++;
                        if (counter == times) {
                            break;
                        }
                    }
                }
                System.out.println(output);
                break;
        }

    }

    static void LastEvenLastOdd(int[] numbers, String[] command) {
        List<Integer> output = new ArrayList<> ();
        int times = Integer.parseInt(command[1]);
        int counter = 0;
        switch (command[2]) {
            case "even" :
                for (int i = numbers.length - 1; i >= 0; i--) {
                    if (numbers[i] % 2 == 0) {
                        output.add(numbers[i]);
                        counter++;
                        if (counter == times) {
                            break;
                        }
                    }
                }
                Collections.reverse(output);
                System.out.println(output);
                break;

            case "odd" :
                for (int i = numbers.length - 1; i >= 0; i--) {
                    if (numbers[i] % 2 != 0) {
                        output.add(numbers[i]);
                        counter++;
                        if (counter == times) {
                            break;
                        }
                    }
                }
                Collections.reverse(output);
                System.out.println(output);
                break;

        }

    }
}
