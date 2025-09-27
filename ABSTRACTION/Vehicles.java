abstract class Vehicle {
    String vehicleNumber;
    String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public double getRate() {
        return rentalRate;
    }

    public void setRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    abstract void calculateRentalCost(int days);

    public void display() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: " + rentalRate);
    }
}

interface Insurable {
    public void calculateInsurance();
    public void getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    String policy = "CAR123";

    Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    void calculateRentalCost(int days) {
        double cost = getRate() * days;
        System.out.println("Rental cost for " + days + " days: " + cost);
    }

    public void calculateInsurance() {
        System.out.println("Car Insurance: 500");
    }

    public void getInsuranceDetails() {
        System.out.println("Policy Number: " + policy);
    }
}

class Bike extends Vehicle implements Insurable {
    String policy = "BIKE456";

    Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    void calculateRentalCost(int days) {
        double cost = getRate() * days * 0.8;
        System.out.println("Rental cost for " + days + " days: " + cost);
    }

    public void calculateInsurance() {
        System.out.println("Bike Insurance: 200");
    }

    public void getInsuranceDetails() {
        System.out.println("Policy Number: " + policy);
    }
}

class Truck extends Vehicle implements Insurable {
    String policy = "TRUCK789";

    Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    void calculateRentalCost(int days) {
        double cost = getRate() * days + 1000;
        System.out.println("Rental cost for " + days + " days: " + cost);
    }

    public void calculateInsurance() {
        System.out.println("Truck Insurance: 1000");
    }

    public void getInsuranceDetails() {
        System.out.println("Policy Number: " + policy);
    }
}

public class Vehicles {
    public static void main(String[] args) {
        Vehicle v1 = new Car("C101", 1000);
        Vehicle v2 = new Bike("B202", 500);
        Vehicle v3 = new Truck("T303", 2000);

        v1.display();
        v1.calculateRentalCost(5);
        ((Insurable)v1).calculateInsurance();
        ((Insurable)v1).getInsuranceDetails();

        System.out.println();

        v2.display();
        v2.calculateRentalCost(5);
        ((Insurable)v2).calculateInsurance();
        ((Insurable)v2).getInsuranceDetails();

        System.out.println();

        v3.display();
        v3.calculateRentalCost(5);
        ((Insurable)v3).calculateInsurance();
        ((Insurable)v3).getInsuranceDetails();
    }
}
