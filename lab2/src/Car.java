
public class Car {
    private double x;
    private double fuel;
    private final int maxFuel;

    /**
     * Расход топлива в км/л.
     */
    private final double consumption;

    public Car(int maxFuel, double consumption) {
        if (consumption < 0 || maxFuel < 0)
            throw new RuntimeException("Consumption < 0!");
        x = 0;
        fuel = 0;
        this.maxFuel = maxFuel;
        this.consumption = consumption;
    }

    public Car(int maxFuel, double consumption, double fuel) {
        this(maxFuel, consumption);
        addFuel(fuel);
    }

    public Car(int maxFuel, double consumption, double fuel, double x) {
        this(maxFuel, consumption);
        this.x = x;
        addFuel(fuel);
    }

    public double getX() {
        return x;
    }

    public double getFuel() {
        return fuel;
    }

    public double getConsumption() {
        return consumption;
    }

    public boolean move(double x) {
        double length;
        double spendFuel = x / consumption;
        if (spendFuel < 0)
            spendFuel = -spendFuel;
        if (fuel <= spendFuel) {
            double s = fuel * consumption;
            fuel = 0;
            length = s;
        }
        else {
            fuel -= spendFuel;
            length = x;
        }
        if(x < 0)
            length = -length;
        x += length;
        return length == x;
    }

    public void addFuel(double fuel) {
        if (fuel + this.fuel > maxFuel)
            throw new RuntimeException("Too much fuel!");
        if (fuel + this.fuel < 0)
            throw new RuntimeException("Fuel < 0!");
        this.fuel += fuel;
    }

    public static void main(String[] args) {
        Car car = new Car(60, 10, 45);
        car.addFuel(15);
        System.out.println(car.getFuel());
        car.move(-1000);
        System.out.println(car.getFuel());
        System.out.println(car.getX());
    }
}
