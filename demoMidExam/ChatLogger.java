package demoMidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chatList = new ArrayList<>();
        String input;

        while (!"end".equals(input = scanner.nextLine())) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Chat" :
                    chatList.add(command[1]);
                    break;
                case "Delete" :
                    chatList.remove(command[1]);
                    break;
                case "Edit" :
                    chatList.set(chatList.indexOf(command[1]), command[2]);
                    break;
                case "Pin" :
                    chatList.remove(command[1]);
                    chatList.add(command[1]);
                    break;
                case "Spam" :
                    for (int i = 1; i < command.length; i++) {
                        chatList.remove(command[i]);
                    }
                    for (int i = 1; i < command.length; i++) {
                        chatList.add(command[i]);
                    }
                    break;
            }
        }
        for (String item : chatList) {
            System.out.println(item);
        }
    }
}
