package treta;

public class TestVehicles
{
    public static void main(String[] args)
    {
        Car car = new Car(220, "BMW X5", 95000, 250);
        Hovercraft hovercraft = new Hovercraft(120, "HoverJet 3000", 120000, 10);
        Ship ship = new Ship(60, "Poseidon", 5000000, 20000);

        System.out.println(car);
        car.enterLand();

        System.out.println("\n" + hovercraft);
        hovercraft.enterLand();
        hovercraft.enterSea();

        System.out.println("\n" + ship);
        ship.enterSea();
    }
}

