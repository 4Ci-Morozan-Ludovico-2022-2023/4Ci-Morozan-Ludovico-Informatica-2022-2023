import java.io.;
import java.util.;
public class ContatoreGasCalculator {
    private List<ContatoreGas> listaContatoriGas;
    public static final double COSTO_MC = 2.5;
    public ContatoreGasCalculator() {
        listaContatoriGas = new ArrayList<>();
    }
    public void start() {
        descrizioneApp();
        inputDati();
        visualizzaRisultati();
    }
    public void descrizioneApp() {
        System.out.println("Questa applicazione calcola le bollette del gas");
    }
    public void inputDati() {
        String nomeFile;
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci il nome e l'estensione del file");
        nomeFile = s.next();
        File f = null;
        try{
            if (nomeFile != null){
                f = new File(nomeFile);
            }
            if (f != null){
                Scanner in = new Scanner(f);
                while (in.hasNext()){
                    String linea = in.next();
                    String[] valori = linea.split(";");
                    double precedente = Double.parseDouble(valori[0]);
                    double attuale = Double.parseDouble(valori[1]);
                    listaContatoriGas.add(new ContatoreGas(precedente, attuale));
                }
            } 
        }catch (FileNotFoundException e){
            System.out.println("ERRORE");
            System.out.println(e.getMessage());
        }
    }
    public void visualizzaRisultati() {
        Scanner s = new Scanner(System.in);
        System.out.println("Elaborazione dati:");
        for (ContatoreGas contatore : listaContatoriGas) {
            double consumo = contatore.calcolaConsumo();
            double bolletta = contatore.calcolaBolletta();
            String out = "";
            out += "/nConsumo" + consumo + "al metrocubo";
            out += "/nBolletta" + bolletta + "euro";
            System.out.println(out);
        }
    }
}
