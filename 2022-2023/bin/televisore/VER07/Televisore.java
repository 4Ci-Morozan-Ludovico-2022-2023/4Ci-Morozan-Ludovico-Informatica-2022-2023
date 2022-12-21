import java.util.*;
public class Televisore
{
    private int pollici = 0;
    private String schermo = "anonimo";
    private String colore = "anonimo";
    private int canale = 0;
    private int volume = 0;
    private int luminos = 50;
    private boolean acceso = false;
    public Televisore(int pollici, String schermo, String colore){
         if(pollici>0){
             this.pollici=pollici;
         }
         if(schermo!=null){
             this.schermo=schermo;
         }
         if(colore!=null){
             this.colore=colore;
         }
    }
    //
     public void accendi(){
        this.acceso = true;
    }
    public void spegni(){
        this.acceso = false;
    }
    //
    public int getPollici(){
        return this.pollici;
    }
    public void setPollici(int p){
        if(p>0){
            this.pollici=p;
        }
    }
    //
     public String getSchermo(){
        return this.schermo;
    }
    public void setSchermo(String s){
        if(s!=null){
            this.schermo=s;
        }
    }
    //
    public String getColore(){
        return this.colore;
    }
    public void setColore(String color){
        if(color!=null){
            this.colore=color;
        }
    }
    //
    public int getCanale(){
        return this.canale;
    }
    public void setCanale(int c){
        if(c>0 || c<1000){
            this.canale=c;
        }
    }
    public void aumentaCanale(){
        if(this.canale==999){
            this.canale=1;
        }else{
            this.canale++;
        }
    }
    public void diminuisciCanale(){
        if(this.canale<1){
            this.canale=999;
        }else{
            this.canale--;
        }
    }
    //
    public int getVolume(){
        return this.volume;
    }
    public void setVolume(int v){
        if(v>=0 || v<=00){
            this.volume=v;
        }
    }
    public void aumentaVolume(){
        if(this.volume>=0 || this.volume<100){
            this.volume++;
        }
    }
    public void diminuisciVolume(){
        if(this.volume>0 || this.volume<=100){
            this.volume--;
        }
    }
    //
    public String toString(){
        String out="";
        out="\nPollici: "+this.pollici;
        out+="\nSchermo: "+this.schermo;
        out+="\nColore: "+this.colore;
        out+="\nCanale: "+this.canale;
        out+="\nVolume: "+this.volume;
        out+="\nLuminosità: "+this.luminos;
        if(this.acceso){
            out+="\nAcceso";
        }else{
            out+="\nSpento";
        }
        return out;
    }
}
