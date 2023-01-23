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
        //04
        cont.setModello("f2000");
        System.out.print("\n" + cont.getModello());
        //05
        cont.setClasse("G25");
        System.out.print("\n" + cont.getClasse());
        //06
        cont.setAnnodifabbr(2011);
        System.out.print("\n" + cont.getAnnodifabbr());
        //07
        cont.setPortataminima(3.9);
        System.out.print("\n" + cont.getPortataminima());
        //08
        cont.setPortatamassima(6.8);
        System.out.print("\n" + cont.getPortatamassima());
    }
}
