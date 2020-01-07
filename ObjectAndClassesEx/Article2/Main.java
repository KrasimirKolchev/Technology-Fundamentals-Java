package Q_ObjectAndClassesEx.Article2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        List<Article2> article2 = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] input = reader.readLine().split(", ");

            String title2 = input[0];
            String content2 = input[1];
            String author2 = input[2];

            Article2 article22 = new Article2(title2, content2, author2);

            article2.add(article22);
        }
        String command = reader.readLine();

        switch (command) {
            case "title" :
                article2.stream().sorted((a1,a2) -> a1.getTitle2().compareTo(a2.getTitle2())).
                        forEach(e -> System.out.println(e.toString()));
                break;
            case "content" :
                article2.stream().sorted((a1,a2) -> a1.getContent2().compareTo(a2.getContent2())).
                        forEach(e -> System.out.println(e.toString()));
                break;
            case "author" :
                article2.stream().sorted((a1,a2) -> a1.getAuthor2().compareTo(a2.getAuthor2())).
                        forEach(e -> System.out.println(e.toString()));
                break;
        }
    }
}
