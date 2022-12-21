public class Articolo{
    private String nome;
    private double sconto;
    private double prezzo;
    public Articolo(){
        this.nome = "";
        this.sconto = 0.0;
        this.prezzo = 0.0;
    }
    public void setNome(String nome){
        if(nome != null){
            this.nome = nome;
        }
    }
    public void setSconto(double sconto){
        if(sconto > 1 && sconto < 99){
            this.sconto = sconto;
        }else{
            this.sconto = 0;
        }
    }
    public void setPrezzo(double prezzo){
        if(prezzo > -1){
            this.prezzo = prezzo;
        }else{
            this.prezzo = 0;
        }
    }
}
