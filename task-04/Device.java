public class Device {
    private String brand;
    private String model;
    private double price;

    public Device() {}

    public Device(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setPrice(double price) { this.price = price; }

    public void read(java.util.Scanner sc) {
        System.out.print("Brand: ");
        this.brand = sc.nextLine();

        System.out.print("Model: ");
        this.model = sc.nextLine();

        System.out.print("Price: ");
        this.price = Double.parseDouble(sc.nextLine());
    }

    public void print() {
        System.out.println("Brand: " + brand +
                ", Model: " + model +
                ", Price: " + price);
    }
}

