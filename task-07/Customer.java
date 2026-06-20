public class Customer extends User {
    private final String clientNumber;

    public Customer(String id, String name, String clientNumber) {
        super(id, name, UserRole.CUSTOMER);
        this.clientNumber = clientNumber;
    }

    public String getClientNumber() {
        return clientNumber;
    }
}


