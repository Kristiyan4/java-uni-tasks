package vtora;

public class SickPatient extends Patient
{
    private String epicriza;
    private String status;
    private int dayOfSickness;

    public SickPatient()
    {
        super();
    }

    public SickPatient(String name, String address, String egn, String epicriza, String status, int dayOfSickness)
    {
        super(name, address, egn);
        this.epicriza = epicriza;
        this.status = status;
        this.dayOfSickness = dayOfSickness;
    }

    public String getEpicriza()
    {
        return epicriza;
    }

    public void setEpicriza(String epicriza)
    {
        this.epicriza = epicriza;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getDayOfSickness()
    {
        return dayOfSickness;
    }

    public void setDayOfSickness(int dayOfSickness)
    {
        this.dayOfSickness = dayOfSickness;
    }

    @Override
    public void cure(String medicine, double dose)
    {
        epicriza += "\nПрието лекарство: " + medicine + ", доза: " + dose + " mg.";
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Епикриза: " + epicriza);
        System.out.println("Статус: " + status);
        System.out.println("Ден на заболяване: " + dayOfSickness);
    }
}

