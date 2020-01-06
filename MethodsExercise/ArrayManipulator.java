package K_MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");


            if (command[0].equals("exchange")) {
                int times = Integer.parseInt(command[1]);

                if (times < 1 && times > numbers.length - 2) {
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

            } else if (command[0].equals("max")) {
                if (command[1].equals("even")) {
                    int evenMax = Integer.MIN_VALUE;
                    int index = -1;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 == 0) {
                            if (numbers[i] > evenMax) {
                                evenMax = numbers[i];
                                index = i;
                            }
                        }
                    }
                    if (evenMax == Integer.MIN_VALUE) {
                        System.out.println("No matches");

                    } else {
                        System.out.println(index);

                    }

                } else {
                    int oddMax = Integer.MIN_VALUE;
                    int index = -1;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 != 0) {
                            if (numbers[i] > oddMax) {
                                oddMax = numbers[i];
                                index = i;
                            }
                        }
                    }
                    if (oddMax == Integer.MIN_VALUE) {
                        System.out.println("No matches");

                    } else {
                        System.out.println(index);

                    }
                }
            } else if (command[0].equals("min")) {
                if (command[1].equals("even")) {
                    int evenMin = Integer.MAX_VALUE;
                    int index = -1;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 == 0) {
                            if (numbers[i] < evenMin) {
                                evenMin = numbers[i];
                                index = i;
                            }
                        }
                    }
                    if (evenMin == Integer.MAX_VALUE) {
                        System.out.println("No matches");

                    } else {
                        System.out.println(index);

                    }
                } else {
                    int oddMin = Integer.MAX_VALUE;
                    int index = -1;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 != 0) {
                            if (numbers[i] < oddMin) {
                                oddMin = numbers[i];
                                index = i;
                            }
                        }
                    }
                    if (oddMin == Integer.MAX_VALUE) {
                        System.out.println("No matches");

                    } else {
                        System.out.println(index);

                    }
                }
            } else if (command[0].equals("first")) {
                if (command[2].equals("even")) {
                    String text = "";
                    int times = Integer.parseInt(command[1]);
                    int counter = 0;
                    if (counter >= times) {
                        System.out.println(text);
                        break;
                    } else {
                        for (int i = 0; i < numbers.length; i++) {
                            if (numbers[i] % 2 == 0) {
                                text += numbers[i] + ", ";
                                counter++;
                            }
                        }
                        System.out.println(text);
                    }

                } else {
                    String text = "";
                    int times = Integer.parseInt(command[1]);
                    int counter = 0;
                    while (counter < times) {
                        for (int number : numbers) {
                            if (number % 2 != 0) {
                                text += number + ", ".trim();
                                counter++;
                            }
                        }
                    }
                    System.out.println(text);
                }

            } else if (command[0].equals("last")) {
                if (command[2].equals("even")) {
                    String text = "";
                    int times = Integer.parseInt(command[1]);
                    int counter = 0;
                    while (counter < times) {
                        for (int i = numbers.length - 1; i >= 0; i--) {
                            if (numbers[i] % 2 == 0) {
                                text += numbers[i] + ", ".trim();
                                counter++;
                            }
                        }
                    }
                    System.out.println(text);
                } else {
                    String text = "";
                    int times = Integer.parseInt(command[1]);
                    int counter = 0;
                    while (counter < times) {
                        for (int i = numbers.length - 1; i >= 0; i--) {
                            if (numbers[i] % 2 != 0) {
                                text += numbers[i] + ", ".trim();
                                counter++;
                            }
                        }
                    }
                    System.out.println(text);
                }

            }
            input = scanner.nextLine();
        }

    }

}
