import java.util.*;
public class VenditaArticolo{
    private Articolo articolo;
    public VenditaArticolo(){
        this.articolo = new Articolo();
    }
    public void start(){
        this.describeProgram();
        this.getInput();
        this.itemSell();
        this.displayOutput();
    }
    public void describeProgram(){
        System.out.println("io descrivo il programma");
    }
    public void getInput(){
        System.out.println("io prendo in ingresso i dati");
        Scanner input = new Scanner(System.in);
        System.out.println("dammi il nome");
        articolo.setNome(input.nextLine());
        System.out.println("dammi lo sconto");
        articolo.setSconto(input.nextDouble());
        System.out.println("dammi il prezzo");
        articolo.setPrezzo(input.nextDouble());
    }
    public void itemSell(){
        System.out.println("io calcolo gli acquisti"); // da completare
    }
    public void displayOutput(){
        System.out.println("io visualizzo i risultati"); // da completare
    }
}
