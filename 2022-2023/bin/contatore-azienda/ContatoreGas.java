public class ContatoreGas {
    private double consumoPrecedente;
    private double consumoAttuale;
    public static final double MAX_VAL = 9999.999;
    public static final double COSTO_MC = 2.5;
    public ContatoreGas(double consumoPrecedente, double consumoAttuale) {
        this.consumoPrecedente = consumoPrecedente;
        this.consumoAttuale = consumoAttuale;
    }
    public void rilevazionePrecedente(double consumoPrecedente) {
        this.consumoPrecedente = consumoPrecedente;
    }
    public void rilevazioneAttuale(double consumoAttuale) {
        if (consumoAttuale >= 0.0){
            if (consumoAttuale > MAX_VAL){
                this.consumoAttuale = consumoAttuale - MAX_VAL; 
            } else {
                this.consumoAttuale = consumoAttuale;
            }
        }
    }
    public double calcolaConsumo() {
        return this.consumoAttuale - this.consumoPrecedente;
    }
    public double calcolaBolletta(){
        double consumo = calcolaConsumo();
        if (consumo < 0.0){
            consumo = (MAX_VAL - consumoPrecedente) + consumoAttuale;
        }
        return (consumo * COSTO_MC);
    }
}
