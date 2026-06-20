public class Product2 implements GetProductsTo, DeliveryAPI {
    private final String type;
    private final double price;
    private final int idOfProvider;
    private final int number;

    public Product2(String type, double price, int idOfProvider, int number) {
        this.type = type;
        this.price = price;
        this.idOfProvider = idOfProvider;
        this.number = number;
    }

    public double getPrice() { return price; }
    public String getType() { return type; }
    public int getIdOfProvider() { return idOfProvider; }

    public int getNumber(int idOfProvider) {
        if (this.idOfProvider == idOfProvider) return number;
        return 0;
    }

    public String getType(int idOfProvider) {
        if (this.idOfProvider == idOfProvider) return type;
        return null;
    }
}

