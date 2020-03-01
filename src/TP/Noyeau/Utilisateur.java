package TP.Noyeau;

import java.util.Scanner;

public class Utilisateur {


    public void affichBiensProps(Agence a , Proprietaire ... proprietaires){
        for (Proprietaire p : proprietaires){
            a.affichBiensProp(p);
        }
    }
    public void affichProp(Agence a, Proprietaire p){
        p.afficher();
    }
    public void consulter(Agence a , Bien b){
      a.consulter(b);
    }
    public void affichPrixFin(Bien b){
        System.out.println(" Prix finale est : "+b.getPrixAgence()+" DA.");
    }
    public void affichPrixFin(Bien ... biens){
        for (Bien b : biens){
            System.out.println();
            this.affichPrixFin(b);
        }
    }
    public void envoyerMessage(Agence a , Bien b){
        Scanner scan = new Scanner(System.in) ;
        b.afficherDetail();
        System.out.println();
        System.out.print(" introduire votre message sur ce Bien : ");
        String msg = scan.nextLine();
        a.getMessages().add(msg);
    }
    public void envoyerMessage(Agence a , Bien ... biens){
        for (Bien b : biens){
            System.out.println();
            this.envoyerMessage(a,b);
            System.out.println();
        }
    }


}
