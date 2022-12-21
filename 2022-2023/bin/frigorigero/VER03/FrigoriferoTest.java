import java.util.*;
public class FrigoriferoTest{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        Frigorifero frigo = new Frigorifero("Samsung", "D2022", 30.0);
        System.out.print("\n"+frigo.toString());
        //02
        frigo.accendi();
        System.out.print("\n" + frigo.toString());
        frigo.spegni();
        System.out.print("\n" + frigo.toString());
         //03
        frigo.setMarca("samsung");
        System.out.print("\n" + frigo.getMarca());
    }
}
