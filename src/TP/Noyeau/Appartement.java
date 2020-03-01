package TP.Noyeau;

import java.time.LocalDate;

public class Appartement extends Habitable {

    /////// Declaration
    private int nbrEtages;
    private boolean dispoAssenceur;
    private TypeApp natureApp;
    private float prixAgence;

    ////// Constructor
    public Appartement(TypeApp natureApp, boolean dispoAssenceur, int nbrEtages, boolean meuble, int nbr_pieces, String adresse, Ebiens type_bien, wilaya willaya, float superficie, Transaction transaction, boolean negociabilite, String descriptif, LocalDate dateDajout, String photoUrl, boolean visibilite, int prix, Proprietaire proprietaire) throws Exception{
        super(meuble, nbr_pieces, adresse, type_bien, willaya, superficie, transaction, negociabilite, descriptif, dateDajout , photoUrl, visibilite, prix, proprietaire);
        this.nbrEtages =nbrEtages;
        if (nbrEtages <1) throw new LogicalException();
        this.natureApp = natureApp;
        this.dispoAssenceur = dispoAssenceur;
    }

    ////// getters and setters
    public float getPrixAgence(){return this.prixAgence;}
    @Override
    public void setPrixAgence(float prixAgence) {
        this.prixAgence = prixAgence;
    }
    public void setNatureApp(TypeApp natureApp) {
        this.natureApp = natureApp;
    }
    public boolean isDispoAssenceur() {
        return dispoAssenceur;
    }
    public void setDispoAssenceur(boolean dispoAssenceur) {
        this.dispoAssenceur = dispoAssenceur;
    }
    public void setNbrEtages(int nbrEtages) {
        this.nbrEtages = nbrEtages;
    }
    public TypeApp getNatureApp() {
        return natureApp;
    }

    @Override
    public int getNbr_pieces() {
        return super.getNbr_pieces();
    }

    public int getNbrEtages() {
        return nbrEtages;
    }

    ////// Affichage
    public void afficher(){
        System.out.println(" Le bien est de type : "+this.getType_bien());
        System.out.println(" Adresse : "+getAdresse());
        System.out.println(" Transaction : "+this.getTransaction());
        System.out.println(" Superficie : "+getSuperficie());
        System.out.println(" Nombre de pieces : "+getNbr_pieces());
        System.out.println(" Nombre de etages : "+this.nbrEtages);
        if (dispoAssenceur) System.out.println(" Assenceur : Disponible");
        else System.out.println("Assenceur : Non disponible");

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
        if (this.isMeuble())
            System.out.println(" meuble.");
        System.out.println(" Adresse : "+getAdresse());
        System.out.println(" Superficie : "+getSuperficie());
        System.out.println(" Type d'appartement : "+this.natureApp);
        System.out.println(" Nombre de pieces : "+getNbr_pieces());
        System.out.println(" Nombre de etages : "+this.nbrEtages);
        if (dispoAssenceur) System.out.println(" Assenceur : Disponible");
        else System.out.println("Assenceur : Non disponible");
        System.out.println();
        System.out.println(" Date d'ajout : "+this.getDateDajout());
        System.out.println(" Proprietaire : ");
        this.getProprietaire().afficher();
        System.out.println(" Prix : "+prixAgence+" DA");
    }

    ////// calcul de prix
    public float calcul_prix(){
        float price = 0;
        price = super.calcul_prix();
        float prix = this.getPrix();
        float superficie = this.getSuperficie();
        Transaction transaction = this.getTransaction();

            if ((transaction == Transaction.vente)||(transaction == Transaction.echange)){
                if (nbrEtages <=2 ){
                    price = price + 50000;
                }else {
                    return super.calcul_prix();
                }
            }else {
                if (nbrEtages <= 2 ){
                    price = price + 5000;
                }
                if ((nbrEtages >= 6 )&& (!dispoAssenceur)){
                    price = price - 500*superficie;
                } else {
                    return super.calcul_prix();
                }
            }
        return price;
    }






}
