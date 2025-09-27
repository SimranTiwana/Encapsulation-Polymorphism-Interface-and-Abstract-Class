abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    abstract void calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

interface MedicalRecord {
    public void addRecord();
    public void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private double treatmentCharge;
    private String record = "No record yet";

    InPatient(int patientId, String name, int age, double roomCharge, double treatmentCharge) {
        super(patientId, name, age);
        this.roomCharge = roomCharge;
        this.treatmentCharge = treatmentCharge;
    }

    void calculateBill() {
        double bill = roomCharge + treatmentCharge;
        System.out.println("In-Patient Bill: " + bill);
    }

    public void addRecord() {
        record = "Admitted for surgery";
        System.out.println("Record added for In-Patient");
    }

    public void viewRecords() {
        System.out.println("Medical Record: " + record);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String record = "No record yet";

    OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    void calculateBill() {
        System.out.println("Out-Patient Bill: " + consultationFee);
    }

    public void addRecord() {
        record = "Visited for fever consultation";
        System.out.println("Record added for Out-Patient");
    }

    public void viewRecords() {
        System.out.println("Medical Record: " + record);
    }
}

public class Hospital {
    public static void main(String[] args) {
        Patient p1 = new InPatient(101, "Simran", 25, 5000, 3000);
        Patient p2 = new OutPatient(102, "Rahul", 30, 800);

        p1.getPatientDetails();
        p1.calculateBill();
        ((MedicalRecord)p1).addRecord();
        ((MedicalRecord)p1).viewRecords();

        System.out.println();

        p2.getPatientDetails();
        p2.calculateBill();
        ((MedicalRecord)p2).addRecord();
        ((MedicalRecord)p2).viewRecords();
    }
}
