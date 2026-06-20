package purva;

public abstract class Pateshestvie
{
    private String destinacia;
    private int broiDni;
    private double cena;

    public Pateshestvie(String destinacia, int broiDni, double cena)
    {
        this.destinacia = destinacia;
        this.broiDni = broiDni;
        this.cena = cena;
    }

    public String getDestinacia()
    {
        return destinacia;
    }

    public void setDestinacia(String destinacia)
    {
        this.destinacia = destinacia;
    }

    public int getBroiDni()
    {
        return broiDni;
    }

    public void setBroiDni(int broiDni)
    {
        this.broiDni = broiDni;
    }

    public double getCena()
    {
        return cena;
    }

    public void setCena(double cena)
    {
        this.cena = cena;
    }


    public abstract double fixPrice();
}

