package TP.Noyeau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Admin {

    private String nom ;
    private String prenom;

    public Admin(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    ////// getters and setters
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }

    ////// suprimer bien
    public void suprimerBien(Agence a, Bien b){
        a.suprimerBien(b);
    }
    public void suprimerBien(Agence a, Bien ... b){
        for (Bien bien : b){
            this.suprimerBien(a,bien);
        }
    }

    ////// ajouter bien
    public void ajouterBien(Agence a,Bien b){
        a.ajouter_Bien(b);
    }
    public void ajouterBien(Agence a,Bien ... b){
        for (Bien bien : b){
            a.ajouter_Bien(bien);
        }
    }

    ////// modifierbien
    public void modifierBien(Agence a , Bien b) throws Exception{
            if (a.isConnecte()){
                a.modifierBien(b);
            }
            else {
                System.out.println(" tu n'a pas le droit pour modifier un bien");
            }
    }
    public void modifierBiens(Agence a ,Bien ... biens)throws Exception{
        if (a.isConnecte()){
            for (Bien b : biens){
                a.modifierBien(b);
            }
        }
        else {
            System.out.println(" tu n'a pas le droit pour modifier ces biens");
        }
    }

    ////// modifier appartement
    public void modifierBien(Agence a,Appartement app) throws Exception{
        if (a.isConnecte()){
            a.modifierBien(app);
        }
        else {
            System.out.println(" tu n'a pas le droit pour modifier cette appartement");
        }
    }

    ////// modifier maison
    public void modifierBien(Agence a,Maison maison) throws Exception{
        if (a.isConnecte()){
            a.modifierBien(maison);
        }
        else {
            System.out.println(" tu n'a pas le droit pour modifier cette maison");;
        }
    }

    ////// modifier terrain
    public void modifierBien(Agence a , Terrain terr) throws Exception{
        if (a.isConnecte()){
            a.modifierBien(terr);
        }else {
            System.out.println(" tu n'a pas le droit pour modifier ce terrain");
        }
    }


    ////// recherche filtres.
    public ArrayList<Bien> recherchFiltres(Agence a) {

        Scanner scanner = new Scanner(System.in); //scanner

        // hashmap pour mapper les diffrentes type des biens
        HashMap<Integer, Type_bien> mapTypeBien = new HashMap<>() {{
            put(1, new Type_bien(Ebiens.Bien));
            put(2, new Type_bien(Ebiens.Habitable));
            put(3, new Type_bien(Ebiens.Maison));
            put(4, new Type_bien(Ebiens.Appartement));
            put(5, new Type_bien(Ebiens.Terrain));
        }};

        ////////hashmap pour mapper les diffrentes type des transactions
        HashMap<Integer, Type_transaction> mapTypeTrans = new HashMap<>() {{
            put(1, new Type_transaction(Transaction.vente));
            put(2, new Type_transaction(Transaction.location));
            put(3, new Type_transaction(Transaction.echange));
        }};
        float prix;

        /////// filtre par prix maximale
        System.out.print(" Inserer un prix maximale : ");
        prix = scanner.nextFloat();
        Prix_max prix_max = new Prix_max(prix);
        System.out.println();

        //filtrer par prix minimale
        System.out.print(" Inserer un prix minimale : ");
        prix = scanner.nextFloat();
        Prix_min prix_min = new Prix_min(prix);
        System.out.println();

        //filtrer par wilaya
        System.out.print(" Inserer le code du willaya : ");
        int num;
        do {
            num = scanner.nextInt();
        } while ((num < 1) || num > 48);
        wilaya wil = a.getMapWilaya().get(num);
        System.out.println();

        //filtrer par nature du bien
        System.out.println(" 1 --> tout les biens ");
        System.out.println(" 2 --> tout les biens Habitables ");
        System.out.println(" 3 --> tout les maisons ");
        System.out.println(" 4 --> tout les les appartements ");
        System.out.println(" 5 --> tout les terrains ");
        System.out.print(" Inserer votre choix : ");
        do {
            num = scanner.nextInt();
        } while ((num < 1) || num > 5);
        Type_bien bien = mapTypeBien.get(num);
        System.out.println();

        ////// filtrer par nature du transaction
        System.out.println(" 1 --> vente ");
        System.out.println(" 2 --> location ");
        System.out.println(" 3 --> echange ");
        System.out.print(" Inserer votre choix : ");
        do {
            num = scanner.nextInt();
        } while ((num < 1) || num > 3);
        Type_transaction trans = mapTypeTrans.get(num);


        ArrayList<Bien> tab = a.recherchFiltres(prix_max,prix_min,wil,bien,trans);

        for (Bien b : tab) b.afficher();
        return a.recherchFiltres();
    }
}
