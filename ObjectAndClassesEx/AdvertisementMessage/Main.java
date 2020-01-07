package Q_ObjectAndClassesEx.AdvertisementMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        AdvertisementMessage message = new AdvertisementMessage();

        for (int i = 0; i < n; i++) {
            System.out.print(message.randomMessage());
        }
    }
}
