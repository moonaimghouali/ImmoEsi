package TP.Noyeau;

import java.time.LocalDate;

public abstract class Habitable  extends Bien{
    private boolean meuble;
    private int nbr_pieces;

    public Habitable(boolean meuble, int nbr_pieces, String adresse, Ebiens type_bien, wilaya willaya, float superficie, Transaction transaction, boolean negociabilite, String descriptif, LocalDate dateDajout, String photoUrl, boolean visibilite, int prix, Proprietaire proprietaire) throws Exception {
        super(adresse,type_bien, willaya, superficie, transaction, negociabilite, descriptif,dateDajout, photoUrl, visibilite, prix,proprietaire);
        this.meuble = meuble;
        this.nbr_pieces = nbr_pieces;
        if (nbr_pieces < 1) throw new LogicalException();
    }

    public abstract void afficher();
    public abstract void afficherDetail();

    public int getNbr_pieces() {
        return nbr_pieces;
    }
    public void setNbr_pieces(int nbr_pieces) {
        this.nbr_pieces = nbr_pieces;
    }
    public boolean isMeuble() {
        return meuble;
    }

    @Override
    public void setPrixAgence(float prixAgence) {
        super.setPrixAgence(prixAgence);
    }
}
