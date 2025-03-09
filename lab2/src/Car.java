
public class Car {
    private final double fuelEfficiency; // Расход топлива (км/л)
    private double fuelLevel; // Уровень топлива в баке (литры)
    private double distanceTraveled; // Пройденное расстояние от начала координат (км)

    public Car(double fuelEfficiency) {
        if(fuelEfficiency <= 0) {
            throw new IllegalArgumentException("Fuel efficiency should be > 0");
        }
        this.fuelEfficiency = fuelEfficiency;
        this.fuelLevel = 0;
        this.distanceTraveled = 0;
    }

    public void drive(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("The distance cannot be negative");
        }
        double maxDistance = fuelLevel * fuelEfficiency;
        if (distance <= maxDistance) {
            distanceTraveled += distance;
            fuelLevel -= distance / fuelEfficiency;
        }
        else {
            distanceTraveled += maxDistance;
            fuelLevel = 0;
            System.out.println("Not enough fuel to cover the entire distance");
        }
    }

    public void refuel(double liters) {
        if (liters < 0)
            throw new IllegalArgumentException("The amount of fuel cannot be negative");
        fuelLevel += liters;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    @Override
    public String toString() {
        return String.format("Car: completed %.2f km, fuel tank: %.2f l, consumption: %.2f km/l",
                distanceTraveled, fuelLevel, fuelEfficiency);
    }

    public static void main(String[] args) {
        try {
            Car car = new Car(10);

            car.refuel(30);
            System.out.println(car);

            // Едем 100 км
            car.drive(100);
            System.out.println(car);

            // Едем еще 250 км (должно не хватить топлива)
            car.drive(250);
            System.out.println(car);

            car.refuel(20);
            System.out.println(car);

            car.drive(-50);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Car invalidCar = new Car(-5);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}