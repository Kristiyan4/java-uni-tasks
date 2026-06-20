public class BrokenDevice extends Device {
    private String symptoms;
    private int repairDays;

    public BrokenDevice() {

    }

    public BrokenDevice(String brand, String model, double price, String symptoms, int repairDays) {
        super(brand, model, price);
        this.symptoms = symptoms;
        this.repairDays = repairDays;
    }
    public String getSymptoms() { return symptoms; }
    public int getRepairDays() { return repairDays; }

    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public void setRepairDays(int repairDays) { this.repairDays = repairDays; }

    @Override
    public void read(java.util.Scanner sc) {
        super.read(sc);
        System.out.print("Symptoms: ");
        this.symptoms = sc.nextLine();

        System.out.print("Days needed for repair: ");
        this.repairDays = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Symptoms: " + symptoms +
                ", Repair days: " + repairDays);
    }
}

