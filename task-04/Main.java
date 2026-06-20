import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add healthy device");
            System.out.println("2. Add broken device");
            System.out.println("3. Repair device");
            System.out.println("4. Print all");
            System.out.println("5. Print by symptom");
            System.out.println("6. Total price");
            System.out.println("7. Repair income");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            int ch = Integer.parseInt(sc.nextLine());

            if (ch == 0) break;

            switch (ch) {
                case 1 -> {
                    Device d = new Device();
                    d.read(sc);
                    service.addDevice(d);
                }
                case 2 -> {
                    BrokenDevice bd = new BrokenDevice();
                    bd.read(sc);
                    service.addBrokenDevice(bd);
                }
                case 3 -> {
                    System.out.print("Index of broken device: ");
                    int index = Integer.parseInt(sc.nextLine());
                    service.repairDevice(index);
                }
                case 4 -> service.print();
                case 5 -> {
                    System.out.print("Symptom: ");
                    String s = sc.nextLine();
                    service.printDevicesBySymptom(s);
                }
                case 6 -> {
                    System.out.println("Total price = " + service.totalPrice());
                }
                case 7 -> {
                    System.out.print("Price per repair day: ");
                    double p = Double.parseDouble(sc.nextLine());
                    System.out.println("Expected income = " + service.repairIncome(p));
                }
            }
        }

        sc.close();
    }
}
