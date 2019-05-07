package T_TextProcessingAndRegexEX;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input;

        while (!"end".equals(input = scanner.nextLine())){

            String regex = "^(?<artist>[A-Z][a-z ']+):(?<song>[A-Z ]+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String artist = matcher.group("artist");
                String song = matcher.group("song");

                int artistKey = artist.length();
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < artist.length(); i++) {
                    
                    char symbol = artist.charAt(i);
                    
                    if (symbol == '\'' || symbol == ' ') {
                        sb.append(symbol);
                    } else {
                        int num = symbol + artistKey;

                        if (num > 90 && i == 0) {
                            num = (num - 90) + 64;
                        } else if (num > 122 && i != 0) {
                            num = (num - 122) + 96;
                        }
                        sb.append((char)num);
                    }
                }
                sb.append('@');

                for (int i = 0; i < song.length(); i++) {
                    char symbol = song.charAt(i);

                    if (symbol == '\'' || symbol == ' ') {
                        sb.append(symbol);
                    } else {
                        int num = symbol + artistKey;

                        if (num > 90) {
                            num = (num - 90) + 64;
                        }
                        sb.append((char)num);
                    }
                }
                System.out.println("Successful encryption: " + sb.toString());
            } else {
                System.out.println("Invalid input!");
            }
        }

    }
}
