public class Sim{
    private static final double COSTO_MINUTO = 0.20;
    private double consumi;
    private double min_disponibili;
    private double min_servizio;
    public Sim(){
        this.min_disponibili= 0.0;
        this.consumi = 0.0;
        this.min_servizio = 0.0;
    }
    public Sim(double min_disp, double min_ser){
        this.consumi = 0.0;
        if(min_disp>0.0){
            this.min_disponibili = min_disp;
        }else{
            this.min_disponibili = 0.0;
        }
        if(min_ser>0.0){
            this.min_servizio = min_ser;
        }else{
            this.min_servizio = 0.0;
        }
    }
    public Sim(Sim sim){
        if(sim!=null){
            this.setConsumi(sim.consumi);
            this.setMinuti(sim.min_disponibili);
            this.setServizio(sim.min_servizio);
        }
    }
    public void setMinuti(double min_disp){
        if(min_disp>0.0){
            this.min_disponibili = min_disp;
        }else{
            this.min_disponibili = 0.0;
        }
    }
    public double getMinuti(){
        return this.min_disponibili;
    }
    public void setConsumi(double c){
        if(c>0.0){
            this.consumi = c;
        }else{
            this.consumi = 0.0;
        }
    }
    public double getConsumi(){
        return this.consumi;
    }
    public void setServizio(double min_ser){
        if(min_ser>0.0){
            this.min_servizio = min_ser;
        }else{
            this.min_servizio = 0.0;
        }
    }
    public double getServizio(){
        return this.min_servizio;
    }
    public void ricarica(double ric){
        if(ric>0.0){
            this.min_disponibili+=ric;
        }
    }
    public boolean eroga(){
        if(this.min_servizio<=this.min_disponibili){
            return true;
        }else{
            return false;
        }
    }
    public void spesaEroga(){
        if(eroga()){
            this.min_disponibili-=this.min_servizio;
            this.consumi+=this.min_servizio;
        }
    }
    public double costoMinuto(){
        return this.COSTO_MINUTO * this.min_disponibili;
    }
    public String toString(){
        String out = "";
        out+="Minuti disponibili: " + this.min_disponibili + "\n";
        out+= "Minuti che utilizza il servizio: " + this.min_servizio + "\n";
        out+="Consumi: " + this.consumi;
        return out;
    }
}
