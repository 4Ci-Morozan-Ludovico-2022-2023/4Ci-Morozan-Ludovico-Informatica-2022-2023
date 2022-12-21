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
        //04
        frigo.setModello("f2000");
        System.out.print("\n" + frigo.getModello());
        //05
        frigo.setlitriFrigo(100);
        System.out.print("\n" + frigo.getlitriFrigo());
        //06
        frigo.setlitriFrigo(17);
        System.out.print("\n" + frigo.getlitriFrigo());
        //07
        frigo.setPrezzo(700.0);
        System.out.print("\n" + frigo.getPrezzo());
        //08
        frigo.setconsumokwat(2);
        System.out.print("\n" + frigo.getconsumokwat());
        //09
        frigo.settemperaturaFrigo(1);
        System.out.print("\n" + frigo.gettemperaturaFrigo());
        //10
        frigo.settemperaturaFrizer(-2);
        System.out.print("\n" + frigo.gettemperaturaFrizer());
    }
}
