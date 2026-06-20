package purva;

public class Pochivka extends BroiNoshtuvki.Pateshestvie
{
    private String hotel;

    public Pochivka(String destinacia, int broiDni, double cena, String hotel)
    {
        super(destinacia, broiDni, cena);
        this.hotel = hotel;
    }

    public String getHotel()
    {
        return hotel;
    }

    public void setHotel(String hotel)
    {
        this.hotel = hotel;
    }

    @Override
    public double fixPrice()
    {
        return getCena() * 1.40;
    }

    @Override
    public String toString()
    {
        return "Почивка в " + getDestinacia() +
                " (" + hotel + "), " +
                getBroiDni() + " дни, крайна цена: " + fixPrice() + " лв.";
    }
}

