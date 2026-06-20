package vtora;

import java.util.Scanner;

public abstract class Patient
{
    private String name;
    private String address;
    private String egn;

    public Patient()
    {

    }

    public Patient(String name, String address, String egn)
    {
        this.name = name;
        this.address = address;
        this.egn = egn;
    }

    public void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Въведете име: ");
        name = sc.nextLine();
        System.out.print("Въведете адрес: ");
        address = sc.nextLine();
        System.out.print("Въведете ЕГН: ");
        egn = sc.nextLine();
    }

    public void display()
    {
        System.out.println("Име: " + name);
        System.out.println("Адрес: " + address);
        System.out.println("ЕГН: " + egn);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEgn()
    {
        return egn;
    }

    public void setEgn(String egn)
    {
        this.egn = egn;
    }
    public abstract void cure(String medicine, double dose);
}

