package Q_ObjectAndClassesEx.VehicleCatalogue;

public class VehicleCatalogue {
    private String typeOfVehicle;
    private String model;
    private String color;
    private int horsepower;

    public VehicleCatalogue(String typeOfVehicle, String model, String color, int horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %s",
                this.typeOfVehicle, this.model, this.color, this.horsepower);
    }
}