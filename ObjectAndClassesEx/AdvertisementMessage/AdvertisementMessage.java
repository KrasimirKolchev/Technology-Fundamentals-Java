package Q_ObjectAndClassesEx.AdvertisementMessage;

import java.util.Random;

public class AdvertisementMessage {
    private String[] phrases = {"Excellent product.", "Such a great product.", "I_ArraysMoreEx always use that product.",
            "Best product of its category.", "Exceptional product.", "I_ArraysMoreEx can’t live without this product."};
    private String[] events = {"Now I_ArraysMoreEx feel good.", "I_ArraysMoreEx have succeeded with this product.",
            "Makes miracles. I_ArraysMoreEx am happy of the results!", "I_ArraysMoreEx cannot believe but now I_ArraysMoreEx feel awesome.",
            "Try it yourself, I_ArraysMoreEx am very satisfied .", "I_ArraysMoreEx feel great!"};
    private String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
    private String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    private Random random = new Random();

    public String randomMessage() {
        return String.format("%s %s %s – %s%n", phrases[random.nextInt(phrases.length)],
                events[random.nextInt(events.length)],
                authors[random.nextInt(authors.length)],
                cities[random.nextInt(cities.length)]);
    }

}

