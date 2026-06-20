package treta;

public class Car extends Vehicle implements IsLandVehicle
{
    private double kW;

    public Car(double maxSpeed, String model, double price, double kW)
    {
        super(maxSpeed, model, price);
        this.kW = kW;
    }

    public double getKW()
    {
        return kW;
    }

    public void setKW(double kW)
    {
        this.kW = kW;
    }

    @Override
    public double checkPromo()
    {
        return getPrice() * 0.80;
    }

    @Override
    public void enterLand()
    {
        System.out.println("Колата " + getModel() + " се движи по пътя със скорост " + getMaxSpeed() + " km/h.");
    }

    @Override
    public String toString()
    {
        return "Кола: " + getModel() + ", мощност: " + kW + " kW, цена: " + getPrice() +
                " лв, промо цена: " + checkPromo() + " лв.";
    }
}

