abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    abstract void calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm);
    }
}

interface GPS {
    public void getCurrentLocation();
    public void updateLocation();
}

class Car extends Vehicle implements GPS {
    Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    void calculateFare(double distance) {
        double fare = getRatePerKm() * distance;
        System.out.println("Car Fare for " + distance + " km: " + fare);
    }

    public void getCurrentLocation() {
        System.out.println("Car current location: Downtown");
    }

    public void updateLocation() {
        System.out.println("Car location updated.");
    }
}

class Bike extends Vehicle implements GPS {
    Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    void calculateFare(double distance) {
        double fare = getRatePerKm() * distance * 0.8;
        System.out.println("Bike Fare for " + distance + " km: " + fare);
    }

    public void getCurrentLocation() {
        System.out.println("Bike current location: Uptown");
    }

    public void updateLocation() {
        System.out.println("Bike location updated.");
    }
}

class Auto extends Vehicle implements GPS {
    Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    void calculateFare(double distance) {
        double fare = getRatePerKm() * distance + 10;
        System.out.println("Auto Fare for " + distance + " km: " + fare);
    }

    public void getCurrentLocation() {
        System.out.println("Auto current location: Central Market");
    }

    public void updateLocation() {
        System.out.println("Auto location updated.");
    }
}

public class Rides{
    public static void main(String[] args) {
        Vehicle v1 = new Car("PB1710", "Simran", 15);
        Vehicle v2 = new Bike("B369", "Jasmine", 10);
        Vehicle v3 = new Auto("A342", "Chris", 8);

        v1.getVehicleDetails();
        v1.calculateFare(12);
        ((GPS)v1).getCurrentLocation();
        ((GPS)v1).updateLocation();

        System.out.println();

        v2.getVehicleDetails();
        v2.calculateFare(12);
        ((GPS)v2).getCurrentLocation();
        ((GPS)v2).updateLocation();

        System.out.println();

        v3.getVehicleDetails();
        v3.calculateFare(12);
        ((GPS)v3).getCurrentLocation();
        ((GPS)v3).updateLocation();
    }
}
