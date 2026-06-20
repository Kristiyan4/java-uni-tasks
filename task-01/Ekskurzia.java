package purva;

public class Ekskurzia extends Pateshestvie implements BroiNoshtuvki
{
    private int broiHoteli;

    public Ekskurzia(String destinacia, int broiDni, double cena, int broiHoteli)
    {
        super(destinacia, broiDni, cena);
        this.broiHoteli = broiHoteli;
    }

    public int getBroiHoteli()
    {
        return broiHoteli;
    }

    public void setBroiHoteli(int broiHoteli)
    {
        this.broiHoteli = broiHoteli;
    }

    @Override
    public double fixPrice()
    {
        return getCena() * 1.10;
    }

    @Override
    public int opredeliNoshtuvki(int dni)
    {
        if (dni > 2)
        {
            return dni - 2;
        } else
        {
            return 0;
        }
    }

    @Override
    public String toString()
    {
        return "Екскурзия до " + getDestinacia() +
                " за " + getBroiDni() + " дни, " +
                "хотели: " + broiHoteli +
                ", крайна цена: " + fixPrice() + " лв., " +
                "нощувки: " + opredeliNoshtuvki(getBroiDni());
    }
}
