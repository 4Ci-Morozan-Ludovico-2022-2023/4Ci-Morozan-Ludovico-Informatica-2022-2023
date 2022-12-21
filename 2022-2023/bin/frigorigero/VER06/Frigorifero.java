import java.util.*;
public class Frigorifero{
    private String marca;
    private String modello;
    private int litriFrigo;
    private int litriFrizer;
    private double prezzo;
    private int consumokwat;
    private int temperaturaFrigo;
    private int temperaturaFrizer;
    private boolean acceso;
    public Frigorifero (String m, String mod, double p){
        if (m!=null){
            this.marca = m;
        }else{
            this.marca = "anonimo";
        }
        if (mod!=null){
            this.modello = mod;
        }else{
            this.modello = "anonimo";
        }
        if (p < 0.0){
            this.prezzo = 0.0;
        }else{
            this.prezzo = p;
        }
        this.litriFrigo = 0;
        this.litriFrizer = 0;
        this.consumokwat = 0;
        this.temperaturaFrigo = 0;
        this.temperaturaFrizer = 0;
        this.acceso = false;
    }
    //02
    public void accendi(){
        this.acceso = true;
    }
    public void spegni(){
        this.acceso = false;
    }
    //03
    public String getMarca(){
        return this.marca;
    }
    public void setMarca(String m){
        if(m != null){
            this.marca = m;
        }
    }
    //04
    public String getModello(){
        return this.modello;
    }
    public void setModello(String mod){
        if(mod != null){
            this.modello = mod;
        }
    }
    //05
    public int getlitriFrigo(){
        return this.litriFrigo;
    }
    public void setlitriFrigo(int litriFrigo){
        if(litriFrigo < 123){
            this.litriFrigo = litriFrigo;
        }
    }
    //06
    public int getlitriFrizer(){
        return this.litriFrizer;
    }
    public void setlitriFrizer(int litriFrizer){
        if(litriFrizer < 29){
            this.litriFrizer = litriFrizer;
        }
    }
    //
    public String toString(){
        String out = "Marca: " + this.marca + "\n";
        out += "Modello: " + this.modello + "\n";
        out += "Litri Frigo: " + this.litriFrigo + "\n";
        out += "Litri Frizer: " + this.litriFrizer + "\n";
        out += "Prezzo: " + this.prezzo + "\n";
        out += "Consumo kwat: " + this.consumokwat + "\n";
        out += "Temperatura Frigo: " + this.temperaturaFrigo + "\n";
        out += "Temperatura Frizer: " + this.temperaturaFrizer + "\n";
        if(acceso){
            out += "è acceso" + "\n";
        }else{
            out += "è spento" + "\n";
        }
        return out;
    }
}
