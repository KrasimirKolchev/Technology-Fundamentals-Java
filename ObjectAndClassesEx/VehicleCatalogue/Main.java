package Q_ObjectAndClassesEx.VehicleCatalogue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<VehicleCatalogue> catalogue = new ArrayList<>();
        String command = reader.readLine();

        while (!command.equals("End")) {
            String[] inputInfo = command.split(" ");

            String type = "";
            if (inputInfo[0].equalsIgnoreCase("car")) {
                type = "Car";
            } else {
                type = "Truck";
            }
            String typeOfVehicle = type;
            String model = inputInfo[1];
            String color = inputInfo[2];
            int horsepower = Integer.parseInt(inputInfo[3]);

            VehicleCatalogue vehicleCatalogue = new VehicleCatalogue(typeOfVehicle, model, color, horsepower);
            catalogue.add(vehicleCatalogue);

            command = reader.readLine();
        }

        command = reader.readLine();

        while (!command.equals("Close the Catalogue")) {
            String checkModel = command;

            catalogue.stream().filter(e -> e.getModel().equals(checkModel)).
                    forEach(e -> System.out.println(e.toString()));

            command = reader.readLine();
        }

        double carPower = sumCarHorsepower(catalogue);
        double truckPower = sumTruckHorsepower(catalogue);
        int carCount = 0;
        int truckCount = 0;

        for (VehicleCatalogue catalogue1 : catalogue) {
            if (catalogue1.getTypeOfVehicle().equals("Car")) {
                carCount++;
            } else {
                truckCount++;
            }
        }

        double carsPower = carPower / carCount;
        double trucksPower = truckPower / truckCount;

        if (carCount == 0) {
            carsPower = 0.0;
        }
        if (truckCount == 0) {
            trucksPower = 0.0;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", carsPower);
        System.out.printf("Trucks have average horsepower of: %.2f.", trucksPower);
    }


    public static double sumCarHorsepower(List<VehicleCatalogue> catalogue) {
        return catalogue.stream().filter(e -> e.getTypeOfVehicle().equals("Car")).
                mapToInt(VehicleCatalogue::getHorsepower).sum();
    }
    public static double sumTruckHorsepower(List<VehicleCatalogue> catalogue) {
        return catalogue.stream().filter(e -> e.getTypeOfVehicle().equals("Truck")).
                mapToInt(VehicleCatalogue::getHorsepower).sum();
    }
}

