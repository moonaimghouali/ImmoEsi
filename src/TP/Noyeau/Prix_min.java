package TP.Noyeau;

public class Prix_min extends Critere {
    private float prix_min;

    public Prix_min(float prix) {
        this.prix_min = prix;
    }

    public Prix_min() {

    }

    public float getPrix_min() {
        return prix_min;
    }
    public float price(){ return 10;}
}
