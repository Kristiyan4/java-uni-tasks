import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PresentStore store = new PresentStore();

        Product1 p1 = new Product1("Toy", 20.5, 1, 50);
        Product2 p2 = new Product2("Book", 10.9, 2, 30);
        Product3 p3 = new Product3("Doll", 35.0, 1, 15);

        store.products.add(p1);
        store.products.add(p2);
        store.products.add(p3);

        store.devApi.add(p1);
        store.devApi.add(p2);
        store.devApi.add(p3);

        try {
            ArrayList<GetProductsTo> cheap = store.getProductsByMaxPrice(25);
            for (GetProductsTo c : cheap) {
                System.out.println(c.getType() + " " + c.getPrice());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            ArrayList<String> prov = store.getProductsByProvider(1);
            for (String info : prov) {
                System.out.println(info);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

