import java.util.*;
import java.io.*;

public class Calculator{
    private ArrayList<ContoCorrente> conti; 
    public void start() throws FileNotFoundException{
        this.leggiFile();
    }
    
    public Calculator(){
        this.conti = new ArrayList<ContoCorrente>();
    }
    
    public void leggiFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("archivio.txt"));
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }else{
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (!linea.isEmpty()) {
                    String[] fields = linea.split(";");
                    if (fields.length >= 2) {
                        String titolare = fields[0];
                        int pin = Integer.parseInt(fields[1]);
                        double saldo = Double.parseDouble(fields[2]);
                        ContoCorrente conto = new ContoCorrente(titolare, pin, saldo);
                        conti.add(conto);
                    }
                }
            }

            scanner.close();
        }
    }

    public boolean nonEsiste(ContoCorrente newConto){
        for(ContoCorrente conto : conti){
            System.out.println(conto.getTitolare());
            if(newConto.getTitolare().equals(conto.getTitolare())){
                return false;
            }
        }
        return true;
    }
    
    public void aggiungiConto(ContoCorrente newConto) throws IOException{
        conti.add(newConto);
        FileWriter out = new FileWriter("archivio.txt");
        for(ContoCorrente conto : conti){
            out.write(conto.toString() + "\n");
        }
        out.close();
    }
    
    public boolean controlloPin(ContoCorrente selectedConto){
        boolean controllo = false;
        for(ContoCorrente conto : conti){
            if(conto.getTitolare().equals(selectedConto.getTitolare())){
                if(conto.getPin() == selectedConto.getPin()){
                    controllo = true;
                }
            }
        }
        return controllo;
    }
    
    public void cancellaConto(ContoCorrente selectedConto) throws IOException {
        Iterator<ContoCorrente> iter = conti.iterator();
        while(iter.hasNext()) {
            ContoCorrente conto = iter.next();
            if(conto.getTitolare().equals(selectedConto.getTitolare())) {
                iter.remove();
            }
        }
        FileWriter out = new FileWriter("archivio.txt", false);
        for(ContoCorrente conto : conti){
            out.write(conto.toString() + "\n");
        }
        out.close();
    }
    
    public boolean controlloDisponibilità(ContoCorrente selectedConto){
        boolean controllo = false;
        for(ContoCorrente conto : conti){
            if(conto.getTitolare().equals(selectedConto.getTitolare())){
                if(conto.getSaldo() >= selectedConto.getSaldo()){
                    return true;
                }
            }
        }
        return controllo;
    }
    
    public void preleva(ContoCorrente selectedConto) throws IOException {
        for(ContoCorrente conto : conti){
            if(conto.getTitolare().equals(selectedConto.getTitolare())){
                conto.preleva(selectedConto.getSaldo());
            }
        }
        FileWriter out = new FileWriter("archivio.txt", false);
        for(ContoCorrente conto : conti){
            out.write(conto.toString() + "\n");
        }
        out.close();
    }
    
    public void deposita(ContoCorrente selectedConto) throws IOException {
        for(ContoCorrente conto : conti){
            if(conto.getTitolare().equals(selectedConto.getTitolare())){
                conto.deposita(selectedConto.getSaldo());
            }
        }
        FileWriter out = new FileWriter("archivio.txt", false);
        for(ContoCorrente conto : conti){
            out.write(conto.toString() + "\n");
        }
        out.close();
    }
    
    public String getSaldo(ContoCorrente selectedConto){
        String out = "";
        for(ContoCorrente conto : conti){
            if(conto.getTitolare().equals(selectedConto.getTitolare())){
                out = Double.toString(conto.getSaldo());
            }
        }
        return out;
    }
}
