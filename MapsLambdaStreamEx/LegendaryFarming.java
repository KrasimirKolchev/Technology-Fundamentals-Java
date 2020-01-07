package S_MapsLambdaStreamEx;

import java.util.*;


public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String needed = "";

        Map<String, Integer> resources = new LinkedHashMap<>();
        resources.put("fragments", 0);
        resources.put("shards", 0);
        resources.put("motes", 0);
        Map<String, Integer> junkRes = new TreeMap<>();

        while (needed.equals("")) {
            String[] line = scanner.nextLine().split(" ");

            for (int i = 0; i < line.length; i++) {
                String resource = line[i + 1].toLowerCase();
                int value = Integer.parseInt(line[i]);

                if (resource.equals("shards") || resource.equals("fragments") || resource.equals("motes")) {
                    if (!resources.containsKey(resource)) {
                        resources.put(resource, 0);
                    }
                    resources.put(resource, resources.get(resource) + value);
                    if (resources.get(resource) >= 250) {
                        resources.put(resource, resources.get(resource) - 250);
                        needed = resource;
                        break;
                    }
                } else {
                    if (!junkRes.containsKey(resource)) {
                        junkRes.put(resource, 0);
                    }
                    junkRes.put(resource, junkRes.get(resource) + value);
                }
                i += 1;
            }
        }
        String item = "";
        switch (needed) {
            case "shards" :
                item = "Shadowmourne";
                break;
            case "fragments" :
                item = "Valanyr";
                break;
            case "motes" :
                item = "Dragonwrath";
                break;
        }
        System.out.println(item + " obtained!");
        resources.entrySet().stream().sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue(), e1.getValue());
            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
        junkRes.entrySet().stream().
            sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e -> {
            System.out.println(String.format("%s: %d", e.getKey(), e.getValue()));
        });

    }
}

