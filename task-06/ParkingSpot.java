public class ParkingSpot
{
   private int id;
   private int num;
   private boolean isTaken;
   private String name;

   public ParkingSpot(int id, int num){
       this.id = id;
       this.num = num;
       this.isTaken = false;
       this.name = "";
   }
   public int getId()
   {
        return id;
   }
   public synchronized boolean isTaken(){
       return isTaken;
    }
    public synchronized boolean take(String name)
    {
        if(isTaken==true)
        {
            return false;
        }
        isTaken = true;
        this.name = name;
        return true;
    }
    public synchronized boolean free() {
        if (!isTaken == true)
        {
            return false;
        }
        isTaken = false;
        this.name = " ";
        return true;
    }
}

