public class ContoCorrente {
    private String titolare;
    private double saldo;
    private final int pin;
    private boolean aperto;

    // Costruttore
    public ContoCorrente(String titolare, int pin, double saldo) {
        this.titolare = titolare;
        if(pin > 0){
            this.pin = pin;
        }else{
            this.pin = 0;
        }
        if(saldo >= 0){
            this.saldo = saldo;
        }else{
            this.saldo = 0.0;
        }
        /*this.aperto = false;*/
    }
    
    public ContoCorrente(ContoCorrente conto) {
        this.titolare = conto.titolare;
        this.pin = conto.pin;
        this.saldo = conto.saldo;
    }

    
    // Metodo per aprire il conto
    public void apriConto() {
        aperto = true;
        System.out.println("aperto conto a nome: " + titolare);
    }

    // Metodo per chiudere il conto
    public void chiudiConto() {
        aperto = false;
        saldo = 0.0;
        System.out.println("chiuso conto a nome:  " + titolare);
    }
    
    // Metodo per ottenere il saldo attuale del conto
    public double getSaldo() {
        return saldo;
    }

    // Metodo per impostare il saldo del conto
    public void setSaldo(double saldo) {
        if(saldo >= 0.0){
            this.saldo = saldo;
        }
    }
    
    public int getPin(){
        return pin;
    }
    
    //Metodo per ottenere il titolare
    public String getTitolare() {
        return titolare;
    }
    
    //Metodo per impostare il titolare
    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    // Metodo per prelevare una determinata quantità dal conto
    public void preleva(double importo) {
        saldo -= importo;
    }

    // Metodo per depositare una determinata quantità nel conto
    public void deposita(double deposito) {
        saldo += deposito;
    }
    
    public String toString() {
        String out = "";
        out += titolare + ";";
        out += pin + ";";
        out += saldo;
        return out;
    }
}
