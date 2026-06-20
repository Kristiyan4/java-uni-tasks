import java.util.ArrayList;

public class PresentStore {
    ArrayList<GetProductsTo> products = new ArrayList<>();
    ArrayList<DeliveryAPI> devApi = new ArrayList<>();

    public ArrayList<GetProductsTo> getProductsByMaxPrice(double maxPrice) throws NoProductsFoundException {
        ArrayList<GetProductsTo> result = new ArrayList<>();
        for (GetProductsTo p : products) {
            if (p.getPrice() < maxPrice) result.add(p);
        }
        if (result.isEmpty()) throw new NoProductsFoundException("No products under given price");
        return result;
    }

    public ArrayList<String> getProductsByProvider(int providerId) throws ProviderNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        boolean found = false;

        for (DeliveryAPI d : devApi) {
            if (d.getIdOfProvider() == providerId) {
                found = true;
                int num = d.getNumber(providerId);
                String type = d.getType(providerId);
                result.add(type + " " + num);
            }
        }

        if (!found) throw new ProviderNotFoundException("Provider not found");
        return result;
    }
}

