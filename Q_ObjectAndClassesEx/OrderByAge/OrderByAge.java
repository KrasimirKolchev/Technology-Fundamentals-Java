package Q_ObjectAndClassesEx.OrderByAge;

public class OrderByAge {
    private String name;
    private String personalID;
    private int age;

    public OrderByAge(String name, String personalID, int age) {
        this.name = name;
        this.personalID = personalID;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPersonalID() {
        return personalID;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", this.getName(), this.getPersonalID(), this.getAge());
    }
}
