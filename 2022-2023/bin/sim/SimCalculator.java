import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.*;
public class SimCalculator{
    private ArrayList <Sim> lista;
    public SimCalculator() {
        lista = new ArrayList<Sim>();
    }
    public SimCalculator(ArrayList<Sim>s) {
        lista = new ArrayList<Sim>();
        if(s != null) {
            for(Sim sim : s){
                lista.add(new Sim(sim));
            }
        }
    }
    public void start() {
        descriviApp();
        inputDati();
        visualizzaRisultati();
        scriviFile();
    }
    public void descriviApp() {
    String out = "";
    out += "L'applicazione prende i dati delle sim, ";
    out += "elabora il costo al minuto di ogni sim, ";
    out += "e li scrive su file.";
    System.out.println(out);
    }
    public void inputDati() {
        Scanner input = new Scanner(System.in);
        System.out.println("Dammi il nome del file con i dati: ");
        String file;
        file = input.next();
        if(file!=null) {
            leggiFile(file);
        }
    }
    public void visualizzaRisultati() {
        double ris;
        for(Sim s : lista){
            ris = s.costoMinuto();
            System.out.println("I valori della sim sono: \n" + s.toString() + "\n");
            System.out.println("Il costo dei minuti risulta: " + ris + "\n");
        }
    }
    public void leggiFile(String fileName){
        String data;
        String[] valori;
        File file;
        if (fileName != null) {
            try {
                file = new File(fileName);
                Scanner myReader = new Scanner(file);
                while (myReader.hasNext()) {
                    data = myReader.next();
                    valori = data.split(";");
                    memorizzaSim(valori);
                }
            } catch (FileNotFoundException e) {
                System.out.println("An erroroccurred");
            }
        }
    }
    public void scriviFile() {
        Scanner input = new Scanner(System.in);
        FileWriter fileOut = null;
        double inp;
        System.out.println("dammi il nome del file con i dati storici");
        String fileN;
        fileN = input.next();
        if (fileN != null) {
            try {
                fileOut = new FileWriter(fileN);    
                String  str;
                for (Sim s : this.lista) {
                    str = "" + s.costoMinuto();
                    fileOut.write(str);
                }
                fileOut.close();
            } catch (Exception e) {
                System.out.println("An erroroccurred.");
            }
        }
    }
    public void memorizzaSim(String[] v) {
        Sim sim = new Sim();
        if (v != null) {
            sim.setMinuti(Double.parseDouble(v[0]));
            sim.setServizio(Double.parseDouble(v[1]));
            this.lista.add(sim);
        }
    }
}
