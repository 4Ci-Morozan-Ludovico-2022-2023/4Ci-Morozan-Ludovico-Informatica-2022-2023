import java.util.*;
public class TelevisoreTest{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        Televisore tv = new Televisore(27, "8k", "black");
        System.out.print(tv.toString());
    }
}
