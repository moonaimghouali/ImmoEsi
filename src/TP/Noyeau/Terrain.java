package TP.Noyeau;

import java.time.LocalDate;

public class Terrain extends Bien {

    private String statutJuridique;
    private int nbrFacades;
    private float prixAgence;

    ////// Constructor
    public Terrain(String statutJuridique, int nbrFacades, String adresse, Ebiens type_bien, wilaya willaya, float superficie, Transaction transaction, boolean negociabilite, String descriptif, LocalDate dateDajout, String photoUrl, boolean visibilite, int prix, Proprietaire proprietaire) throws Exception{
        super(adresse, type_bien, willaya, superficie, transaction, negociabilite, descriptif, dateDajout, photoUrl, visibilite, prix,proprietaire);
        this.statutJuridique = statutJuridique;
        this.nbrFacades = nbrFacades;
        if (nbrFacades <1) throw new LogicalException();
    }

    ////// getters and setters
    public float getPrixAgence(){return this.prixAgence;}
    public void setNbrFacades(int nbrFacades) {
        this.nbrFacades = nbrFacades;
    }
    public void setStatutJuridique(String statutJuridique) {
        this.statutJuridique = statutJuridique;
    }

    @Override
    public void setPrixAgence(float prixAgence) {
        this.prixAgence = prixAgence;
    }
    public int getNbrFacades() {
        return nbrFacades;
    }
    public String getStatutJuridique() {
        return statutJuridique;
    }

    ////// affichage
    public void afficher() {
        System.out.println(" Le bien est de type : "+this.getType_bien());
        System.out.println(" Adresse : "+getAdresse());
        System.out.println(" Transaction : "+this.getTransaction());
        System.out.println(" Superficie : "+getSuperficie());
        System.out.println(" Statut juridique : "+this.statutJuridique);
        System.out.println(" Nombre de facades : "+this.nbrFacades);
        System.out.println();
        System.out.println(" Descriptif : "+getDescriptif());
        System.out.println();
        System.out.println(" Prix : "+this.prixAgence);
    }
    public void afficherDetail(){
        if (this.getTransaction() == Transaction.vente){
            System.out.println(" Une maison pour vente");
        }else if (this.getTransaction() == Transaction.location){
            System.out.println(" Une maison pour louer");
        }else {
            System.out.println(" Une maison pour echange");
        }

        System.out.println();

        System.out.println(" Adresse : "+getAdresse());
        System.out.println(" Superficie : "+getSuperficie());

        System.out.println(" Statut juridique : "+this.statutJuridique);
        System.out.println(" Nombre de facades : "+this.nbrFacades);
        System.out.println();
        System.out.println(" Date d'ajout : "+this.getDateDajout());
        System.out.println(" Proprietaire : ");
        this.getProprietaire().afficher();
        System.out.println(" Prix : "+prixAgence+" DA");
    }

    ////// calcul de prix
    public float calcul_prix() {
        float price = 0;
        float prix = this.getPrix();
        float superficie = this.getSuperficie();
        Transaction transaction = this.getTransaction();

        price = super.calcul_prix();
        if ((transaction == Transaction.vente)||(transaction == Transaction.echange)){
            if ( nbrFacades > 1 ){
                price = (float) (price + prix*(0.005*nbrFacades));
            }else {
                return super.calcul_prix();
            }
        }else {
            return super.calcul_prix();
        }
        return price;
    }


}
