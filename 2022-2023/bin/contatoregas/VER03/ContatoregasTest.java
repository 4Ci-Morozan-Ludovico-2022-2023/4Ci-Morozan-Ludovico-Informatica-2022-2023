import java.util.*;
public class ContatoregasTest{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        Contatoregas cont = new Contatoregas("samsung", "xvnd", "F51");
        System.out.print("\n"+cont.toString());
        //02
        cont.accendi();
        System.out.print("\n" + cont.toString());
        cont.spegni();
        System.out.print("\n" + cont.toString());
        //03
        cont.setMarca("samsung");
        System.out.print("\n" + cont.getMarca());
    }
}
