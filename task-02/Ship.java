package treta;

public class Ship extends Vehicle implements IsSeaVessel
{
    private double deadweight;

    public Ship(double maxSpeed, String model, double price, double deadweight)
    {
        super(maxSpeed, model, price);
        this.deadweight = deadweight;
    }

    public double getDeadweight()
    {
        return deadweight;
    }

    public void setDeadweight(double deadweight)
    {
        this.deadweight = deadweight;
    }

    @Override
    public double checkPromo()
    {
        return getPrice() * 0.997;
    }

    @Override
    public void enterSea()
    {
        System.out.println("Корабът " + getModel() + " плава в морето.");
    }

    @Override
    public String toString()
    {
        return "Кораб: " + getModel() + ", дедуейт: " + deadweight +
                " тона, цена: " + getPrice() + " лв, промо цена: " + checkPromo() + " лв.";
    }
}

