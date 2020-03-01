package TP.Noyeau;

import java.time.LocalDate;

public class Maison  extends Habitable {

    /////// declaration
    private int etages;
    private boolean dispoGarage;
    private boolean dispoJardin;
    private boolean dispoPiscine;
    private float superficieHabitable;
    private float prixAgence;

    ////// constructor
    public Maison(int etages, boolean dispoGarage, boolean dispoJardin, boolean dispoPiscine, float superficieHabitable, boolean meuble, int nbr_pieces, String adresse, Ebiens type_bien , wilaya willaya, float superficie, Transaction transaction, boolean negociabilite, String descriptif, LocalDate dateDajout, String photoUrl, boolean visibilite, int prix, Proprietaire proprietaire) throws Exception{
        super(meuble, nbr_pieces, adresse,type_bien, willaya, superficie, transaction, negociabilite, descriptif,dateDajout, photoUrl, visibilite, prix,proprietaire);
        this.etages = etages;
        if (etages < 1) throw new LogicalException();
        this.dispoGarage = dispoGarage;
        this.dispoJardin = dispoJardin;
        this.dispoPiscine = dispoPiscine;
        this.superficieHabitable = superficieHabitable;
        if (superficieHabitable > this.getSuperficie()) throw new LogicalException();
    }

    ////// getters and setters
    public float getPrixAgence(){return this.prixAgence;}
    public float getSuperficieHabitable() {
        return superficieHabitable;
    }
    public boolean isDispoGarage() {
        return dispoGarage;
    }
    public void setDispoGarage(boolean dispoGarage) {
        this.dispoGarage = dispoGarage;
    }
    public boolean isDispoJardin() {
        return dispoJardin;
    }
    public void setDispoJardin(boolean dispoJardin) {
        this.dispoJardin = dispoJardin;
    }
    public boolean isDispoPiscine() {
        return dispoPiscine;
    }
    public void setDispoPiscine(boolean dispoPiscine) {
        this.dispoPiscine = dispoPiscine;
    }
    public void setSuperficieHabitable(float superficieHabitable) {
        this.superficieHabitable = superficieHabitable;
    }
    public void setEtages(int etages) {
        this.etages = etages;
    }
    public int getEtages() {
        return etages;
    }

    @Override
    public void setPrixAgence(float prixAgence) {
        this.prixAgence = prixAgence;
    }

    ////// affichage de bien
    public void afficher(){

        System.out.println(" Le bien est de type : "+this.getType_bien());
        System.out.println(" Adresse : "+getAdresse());
        System.out.println(" Transaction : "+this.getTransaction());
        System.out.println(" Superficie : "+getSuperficie());
        System.out.println(" Superficie habitable : "+this.superficieHabitable);
        System.out.println(" Nombre de pieces : "+getNbr_pieces());
        System.out.println(" Nombre de etages : "+this.etages);

        System.out.print(" Specifications : ");
        if (dispoPiscine) System.out.print("Piscine ");
        if (dispoJardin) System.out.print("Jardin ");
        if (dispoGarage) System.out.print("Garage ");
        System.out.println();
        System.out.println(" Descriptif : "+getDescriptif());
        System.out.println();
        System.out.println(" Prix : "+this.prixAgence+" DA");
    }
    public void afficherDetail(){
        if (this.getTransaction() == Transaction.vente){
            System.out.println(" Une maison pour vente");
        }else if (this.getTransaction() == Transaction.location){
            System.out.println(" Une maison pour louer");
        }else {
            System.out.println(" Une maison pour echange");
        }
        if (this.isMeuble())
            System.out.print(" meuble");
        System.out.println();

        System.out.println(" Adresse : "+getAdresse());
        System.out.println(" Superficie : "+getSuperficie());
        System.out.println(" Superficie habitable : "+this.superficieHabitable);
        System.out.println(" Nombre de pieces : "+getNbr_pieces());
        System.out.println(" Nombre de etages : "+this.etages);
        System.out.print(" Specifications : ");
        if (dispoPiscine) System.out.print("Piscine ");
        if (dispoJardin) System.out.print("Jardin ");
        if (dispoGarage) System.out.print("Garage ");
        System.out.println();
        System.out.println(" Date d'ajout : "+this.getDateDajout());
        System.out.println(" Proprietaire : ");
        this.getProprietaire().afficher();
        System.out.println(" Prix : "+prixAgence+" DA");
    }

    ////// Calcul
    public float calcul_prix(){
        float price = 0;
        float prix = this.getPrix();
        float superficie = this.getSuperficie();
        Transaction transaction = this.getTransaction();

        price = super.calcul_prix();
        if ((transaction == Transaction.vente)||(transaction == Transaction.echange)){
            if ( dispoJardin || dispoGarage || dispoPiscine ){
                price = (float) (price + this.getPrix()* 0.005);
            }
        }else {
            if (dispoPiscine){
                price = price + 50000;
            }
        }
        return price;
    }


}
