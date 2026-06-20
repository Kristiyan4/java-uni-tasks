package vtora;

public class TestPatient
{
    public static void main(String[] args)
    {
        SickPatient p1 = new SickPatient(
                "Иван Петров",
                "гр. София, ул. Липа 5",
                "9901012345",
                "Болест: Грип. Приети лекарства: Парацетамол 500mg.",
                "болен",
                23
        );

        System.out.println("Преди лечението:");
        p1.display();

        p1.cure("Амоксицилин", 250);

        System.out.println("\nСлед приемане на лекарство:");
        p1.display();
    }
}

