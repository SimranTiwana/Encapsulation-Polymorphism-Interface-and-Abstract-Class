abstract class Employee {
    String name;
    int id;
    private double basesalary;

    Employee(String name, int id, double basesalary) {
        this.name = name;
        this.id = id;
        this.basesalary = basesalary;
    }

    public double getInfo() {
        return basesalary;
    }

    public void setInfo(double basesalary) {
        this.basesalary = basesalary;
    }

    abstract void calculateSalary();

    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + basesalary);
    }
}

interface Department {
    public void assignDepartment();
    public void getdetails();
}

class Fulltime extends Employee implements Department {
    String dept = "CA";
    int tenure;
    double fixsal;

    Fulltime(String name, int id, double basesalary, int tenure) {
        super(name, id, basesalary);
        this.tenure = tenure;
        this.fixsal = basesalary;  
    }

    void calculateSalary() {
        if (tenure > 25) {
            fixsal += 2000;
        }
        System.out.println("Total salary for this month: " + fixsal);
    }

    public void assignDepartment() {
        System.out.println("Dept is: " + dept);
    }

    public void getdetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Parttime extends Employee implements Department {
    String dept = "CSE";
    int hours = 40;
    int rate = 200;

    Parttime(String name, int id, double basesalary) {
        super(name, id, basesalary);
    }

    void calculateSalary() {
        double result = hours * rate;
        System.out.println("Total hours: " + hours + " at rate: " + rate +
                " Total salary: " + result);
    }

    public void assignDepartment() {
        System.out.println("Dept is: " + dept);
    }

    public void getdetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

public class Employees {
    public static void main(String[] args) {
        Employee e1 = new Fulltime("SIMRAN", 1, 50000, 30);
        Employee e2 = new Parttime("CHRISTOPHER", 2, 4000);

        e1.display();
        e1.calculateSalary();
        ((Department)e1).assignDepartment();

        System.out.println();

        e2.display();
        e2.calculateSalary();
        ((Department)e2).assignDepartment();
    }
}
