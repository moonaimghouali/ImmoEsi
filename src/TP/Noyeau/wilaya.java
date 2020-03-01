package TP.Noyeau;

public class wilaya extends Critere{
    private float prixMetreCarre;
    private wilayas w ;

    public wilaya(float prixMetreCarre , wilayas w){
        this.prixMetreCarre = prixMetreCarre;
        this.w = w;
    }
    public float getPrixMetreCarre(){return prixMetreCarre;}

    public wilayas getW() {
        return w;
    }
}
