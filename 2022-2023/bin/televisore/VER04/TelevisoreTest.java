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
    }
}
