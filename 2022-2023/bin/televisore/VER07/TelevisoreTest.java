import java.util.*;
public class TelevisoreTest{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        Televisore tv = new Televisore(27, "8k", "black");
        System.out.print(tv.toString());
        //
        tv.accendi();
        System.out.print("\n"+ tv.toString());
        tv.spegni();
        System.out.print("\n"+ tv.toString());
        //
        tv.setPollici(27);
        System.out.print("\n\n"+ tv.getPollici());
        //
        tv.setSchermo("8k");
        System.out.print("\n\n"+ tv.getSchermo());
        //
        tv.setColore("black");
        System.out.print("\n\n"+ tv.getColore());
        //
        tv.setCanale(41);
        System.out.print("\n\n"+ tv.getCanale());
        tv.aumentaCanale();
        System.out.print("\n"+ tv.getCanale());
        tv.diminuisciCanale();
        System.out.print("\n"+ tv.getCanale());
        //
        tv.setVolume(33);
        System.out.print("\n\n"+ tv.getVolume());
        tv.aumentaVolume();
        System.out.print("\n"+ tv.getVolume());
        tv.diminuisciVolume();
        System.out.print("\n"+ tv.getVolume());
    }
}
