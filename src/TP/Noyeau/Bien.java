package TP.Noyeau;

import java.time.LocalDate;

public abstract class Bien implements Comparable {
    private String adresse;
    private Ebiens type_bien;
    private wilaya willaya;
    private float superficie;
    private Transaction transaction;
    private boolean negociabilite;
    private String descriptif;
    private LocalDate dateDajout;
    private String photoUrl;
    private boolean visibilite;
    private float prix;
    private float prixAgence;
    private Proprietaire proprietaire;

    public Bien(){}
    public Bien(String adresse, Ebiens type_bien, wilaya willaya, float superficie, Transaction transaction, boolean negociabilite, String descriptif, LocalDate dateDajout, String photoUrl, boolean visibilite, float prix, Proprietaire proprietaire) throws Exception {
        this.adresse = adresse;
        this.type_bien = type_bien;
        this.willaya = willaya;
        this.superficie = superficie;
        this.transaction = transaction;
        this.negociabilite=negociabilite;
        this.descriptif=descriptif;
        this.dateDajout = dateDajout;
        this.photoUrl = photoUrl;
        this.visibilite = visibilite;
        this.proprietaire = proprietaire;
        this.prix = prix;
        if (prix < 0) throw new LogicalException();

    }

    public abstract void afficher();
    public abstract void afficherDetail();

    public LocalDate getDateDajout() {
        return dateDajout;
    }
    public String getDescriptif() {
        return descriptif;
    }
    public String getAdresse() {
        return adresse;
    }
    public float getPrix(){
        return this.prix;
    }
    public float getPrixAgence(){ return this.prixAgence;}
    public Transaction getTransaction(){
        return transaction;
    }
    public float getSuperficie(){
        return superficie;
    }
    public wilaya getWillaya(){ return this.willaya; }
    public Ebiens getType_bien(){return this.type_bien;}
    public Proprietaire getProprietaire(){return this.proprietaire;}
    public boolean isVisibilite() {
        return visibilite;
    }
    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public void setVisibilite(boolean visibilite) {
        this.visibilite = visibilite;
    }
    public void  setProprietaire(Proprietaire p ){this.proprietaire = p;}
    public void setPrixAgence(float prixAgence) {
        this.prixAgence = prixAgence;
    }
    public void setWillaya(wilaya willaya) {
        this.willaya = willaya;
    }
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
    public void setNegociabilite(boolean negociabilite) {
        this.negociabilite = negociabilite;
    }
    public void setNegociabilite(){
        this.negociabilite = !this.negociabilite;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }

    public  float calcul_prix(){
        float price = 0;;
        float prixMetreCarre = willaya.getPrixMetreCarre();

        if ((transaction == Transaction.vente)||(transaction == Transaction.echange)){
            if (prix < 5000000){
                if (prixMetreCarre < 50000){
                    price = (float) (prix + prix * 0.03);
                }else {
                    price = (float) (prix + (prix * 0.035));
                }

            }else {
                if ((prix >= 5000000 )&&(prix <= 15000000)){
                    if (prixMetreCarre < 50000){
                        price = (float) (prix + prix * 0.02);
                    }else {
                        price = (float) (prix + (prix * 0.025));
                    }
                }else if (prix > 15000000){
                    if (prixMetreCarre < 70000){
                        price = (float) (prix + prix * 0.01);
                    }else {
                        price = (float) (prix + (prix * 0.02));
                    }
                }
            }
        }else {
                if (superficie < 60){
                    if (prixMetreCarre < 50000){
                        price = (float) (prix + prix * 0.01);
                    }else {
                        price = (float) (prix + (prix * 0.015));
                    }

                }if ((superficie >= 60 )&&(superficie <= 150)){
                        if (prixMetreCarre < 50000){
                            price = (float) (prix + prix * 0.02);
                        }else {
                            price = (float) (prix + (prix * 0.025));
                        }
                    }else {
                        if (prixMetreCarre < 50000){
                            price = (float) (prix + prix * 0.03);
                        }else {
                            price = (float) (prix + (prix * 0.035));
                        }
                    }

        }
        return price ;
    }

    @Override
    public int compareTo(Object o) {
        return this.getDateDajout().compareTo(((Bien)o).getDateDajout());
    }

}
