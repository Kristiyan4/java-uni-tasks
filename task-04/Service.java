import java.io.*;
import java.util.ArrayList;

public class Service {
    private ArrayList<Device> healthyDevices = new ArrayList<>();
    private ArrayList<BrokenDevice> brokenDevices = new ArrayList<>();

    private final String healthyFile = "healthy.dat";
    private final String brokenFile = "broken.dat";

    public Service() {
        loadData();
    }

    @SuppressWarnings("unchecked")
    private void loadData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(healthyFile));
            healthyDevices = (ArrayList<Device>) ois.readObject();
            ois.close();
        } catch (Exception ignored) {}

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(brokenFile));
            brokenDevices = (ArrayList<BrokenDevice>) ois.readObject();
            ois.close();
        } catch (Exception ignored) {}
    }

    private void saveData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(healthyFile));
            oos.writeObject(healthyDevices);
            oos.close();
        } catch (Exception e) { e.printStackTrace(); }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(brokenFile));
            oos.writeObject(brokenDevices);
            oos.close();
        } catch (Exception e) { e.printStackTrace(); }
    }





    public void addDevice(Device d) {
        healthyDevices.add(d);
        saveData();
    }

    public void addBrokenDevice(BrokenDevice bd) {
        brokenDevices.add(bd);
        saveData();
    }

    public void repairDevice(int index) {
        if (index >= 0 && index < brokenDevices.size()) {
            BrokenDevice bd = brokenDevices.remove(index);
            Device d = new Device(bd.getBrand(), bd.getModel(), bd.getPrice());
            healthyDevices.add(d);
            saveData();
        }
    }

    public void printDevicesBySymptom(String symptom) {
        for (BrokenDevice bd : brokenDevices) {
            if (bd.getSymptoms().equalsIgnoreCase(symptom)) {
                bd.print();
                System.out.println();
            }
        }
    }

    public double totalPrice() {
        double sum = 0;
        for (Device d : healthyDevices) sum += d.getPrice();
        for (BrokenDevice bd : brokenDevices) sum += bd.getPrice();
        return sum;
    }

    public double repairIncome(double pricePerDay) {
        double income = 0;
        for (BrokenDevice bd : brokenDevices) {
            income += pricePerDay * bd.getRepairDays();
        }
        return income;
    }

    public void print() {
        System.out.println("--------- Healthy Devices ---------");
        for (Device d : healthyDevices) d.print();

        System.out.println("\n--------- Broken Devices ---------");
        for (BrokenDevice bd : brokenDevices) bd.print();
    }
}
