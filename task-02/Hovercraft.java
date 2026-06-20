package treta;

public class Hovercraft extends Vehicle implements IsLandVehicle, IsSeaVessel
{
    private int passengers;

    public Hovercraft(double maxSpeed, String model, double price, int passengers)
    {
        super(maxSpeed, model, price);
        this.passengers = passengers;
    }

    public int getPassengers()
    {
        return passengers;
    }

    public void setPassengers(int passengers)
    {
        this.passengers = passengers;
    }

    @Override
    public double checkPromo()
    {
        return getPrice() * 0.97;
    }

    @Override
    public void enterLand()
    {
        System.out.println("Ховъркрафтът " + getModel() + " се движи по суша.");
    }

    @Override
    public void enterSea()
    {
        System.out.println("Ховъркрафтът " + getModel() + " се плъзга по вода.");
    }

    @Override
    public String toString()
    {
        return "Ховъркрафт: " + getModel() + ", пътници: " + passengers +
                ", цена: " + getPrice() + " лв, промо цена: " + checkPromo() + " лв.";
    }
}

