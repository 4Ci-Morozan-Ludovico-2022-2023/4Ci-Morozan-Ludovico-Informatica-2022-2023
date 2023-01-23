import java.util.*;
public class Contatoregas{
    private String marca;
    private String modello;
    private String classe;
    private int annodifabbr;
    private double portataminima;
    private double portatamassima;
    private double consumo;
    private boolean acceso;
    public Contatoregas (String m, String mod, String c){
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
        if (c!=null){
            this.classe = c;
        }else{
            this.classe = "anonimo";
        }
        this.annodifabbr = 0;
        this.portataminima = 0.0;
        this.portatamassima = 0.0;
        this.consumo = 0.0;
        this.acceso = false;
    }
    //
    public String toString(){
        String out = "Marca: " + this.marca + "\n";
        out += "Modello: " + this.modello + "\n";
        out += "Classe: " + this.classe + "\n";
        out += "Anno di fabbricazione: " + this.annodifabbr + "\n";
        out += "Portata minima: " + this.portataminima + "\n";
        out += "Portata massima: " + this.portatamassima + "\n";
        out += "Consumo: " + this.consumo + "\n";
        if(acceso){
            out += "è acceso" + "\n";
        }else{
            out += "è spento" + "\n";
        }
        return out;
    }
}
