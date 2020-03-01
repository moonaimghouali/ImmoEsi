package TP.Noyeau;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = LocalDate.of(2018,12,12);
        Proprietaire prop1 = new Proprietaire("ghoulai","moonaim","ia_ghouali@esi.dz","0778222901","ouledyaich.blida");
        Proprietaire prop2 = new Proprietaire("hafri","sayef","is_hafri@esi.dz","0778222901","ouledyaich.blida");
        Proprietaire prop3 = new Proprietaire("pacino","al","ia_ghouali@esi.dz","0778222901","ouledyaich.blida");
        Proprietaire prop4 = new Proprietaire("pecsi","joe","ia_ghouali@esi.dz","0778222901","ouledyaich.blida");


        wilaya wilaya1 = new wilaya(100000,wilayas.BLIDA);
        wilaya wilaya2 = new wilaya(30000,wilayas.ALGER);
        wilaya wilaya3 = new wilaya(60000,wilayas.TIPAZA);
        wilaya wilaya4 = new wilaya(50000,wilayas.SETIF);
        Bien bien1 = null ;
        Bien bien2 = null;
        Bien bien3 =null;
        Bien bien4 = null;
        Bien bien5 = null;
        Bien bien6 = null;
        Bien bien7 = null;
        Bien bien8 =null;
        try {
            bien1 = new Appartement(TypeApp.DUPLEXE,false,1,true,4,"alger centre",Ebiens.Appartement,wilaya2,120,Transaction.vente,false," une bonne appartement",d1,"photo1 , photo2",true,4000000,prop2);
            bien2 = new Maison(3,false,true,false,190,true,6,"cherchel",Ebiens.Maison,wilaya3,200,Transaction.vente,false," une maison de luxe ",d1," phot1 , phot2",true,10000000,prop1);
            bien3 = new Terrain("promesse de vente",3,"",Ebiens.Terrain,wilaya1,500,Transaction.vente,false," une bon terrain",d1,"photo 3",true,20000000,prop1);
            bien4 = new Appartement(TypeApp.DUPLEXE,false,1,true,3,"alger centre",Ebiens.Appartement,wilaya3,100,Transaction.location,false," une bonne appartement",d1,"photo1 , photo2",true,40000,prop2);
            bien5 = new Maison(6,false,false,true,160,true,6,"cherchel",Ebiens.Maison,wilaya2,160,Transaction.location,false,"bien creer aujourdhui",d2," phot1 , phot2",true,150000,prop3);
            bien6 = new Appartement(TypeApp.SIMPLEXE,false,6,true,3,"alger centre",Ebiens.Appartement,wilaya3,50,Transaction.location,false," une bonne appartement",d1,"photo1 , photo2",true,600000,prop2);
            bien7 = new Terrain("promesse de vente",1,"",Ebiens.Terrain,wilaya1,650,Transaction.echange,false," une bon terrain",d1,"photo 3",true,18000000,prop1);
            bien8 = new Maison(6,true,false,false,170,true,6,"cherchel",Ebiens.Maison,wilaya2,200,Transaction.location,false," une maison de luxe ",d1," phot1 , phot2",true,14000000,prop2);

        }catch (LogicalException e){
            System.out.println(" verifier les donnes inseres comme la superficie habitable, nombre de facades, nombre de pieces, ");
        }
        catch (Exception e1){
            System.out.println(" ");
        }
        Scanner scan = new Scanner(System.in);
        Admin admin = new Admin("gh", "mnm");
        Agence immo = new Agence(admin);

        System.out.println("          Bienvenue ");
        System.out.println();
        System.out.println(" 1 - pour connecter comme admin");
        System.out.println(" 2 - pour connecter comme utilisateur.");
        System.out.println();
        System.out.println();
        System.out.print(" votre choix : ");
        int choix = 0;
        do {
            try {

                choix = scan.nextInt();
                System.out.println();
                System.out.println(choix);
            }catch (InputMismatchException e ) {
                System.out.println(" veilluez entrer 1 ou 2.");
            }
        }while (choix <1 || choix >2 );
        switch (choix){
            case 1:
                System.out.println( "              - Administration -  ");
                System.out.print(" Nom : ");
                String nom = scan.next();
                System.out.println();
                System.out.print(" Prenom : ");
                String prenom = scan.next();
                if (true)
                {

                    immo.setConnecte(true);
                    immo.affichBiens();

                        System.out.println("           - Immo ESI -    ");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("           - Menu -         ");
                    System.out.println();
                    System.out.println(" 1 - Ajouter un bien. ");
                    System.out.println(" 2 - Ajouter plusieurs bien.");
                    System.out.println(" 3 - Suprimer un bien.");
                    System.out.println(" 4 - Suprimer plusieurs biens.");
                    System.out.println(" 5 - Modifier un bien>");
                    System.out.println(" 6 - Modifier plusieurs biens");
                    System.out.println(" 7 - Afficher le prix finale d'un bien.");
                    System.out.println(" 8 - Afficher les prix finale de pleusieurs biens. ");
                    System.out.println(" 9 - Afficher les prix finales de tout les biens. ");
                    System.out.println(" 10 - Recherche filtres. ");
                    System.out.println(" 11 - Affichage des message envoyes par les utilisateurs.");
                    System.out.println(" 12 - Archiver un bien.");

                    System.out.println();
                    System.out.print("    - entrer votre choix : ");
                    try {
                        choix = scan.nextInt();
                        System.out.println();
                        if ( choix < 1 || choix > 12) throw new LogicalException();

                        switch (choix){
                            case 1:
                                System.out.println(" - Ajouter un bien : ");
                                System.out.println();
                                System.out.println();
                               // admin.ajouterBien(immo,bien2);
                                System.out.println(" affichage des biens de l'agence : ");
                                System.out.println();
                                immo.affichBiens();
                                break;
                            case 2:
                                System.out.println(" - Ajouter plusieurs bien : ");
                                System.out.println();
                                System.out.println();
                                admin.ajouterBien(immo,bien1,bien2,bien3);
                                System.out.println(" affichage des biens de l'agence : ");
                                System.out.println();
                                immo.affichBiens();
                                break;
                            case 3:
                                System.out.println(" - Suprimer un bien : ");
                                System.out.println();
                                System.out.println();
                                admin.ajouterBien(immo,bien1,bien5,bien6);
                                System.out.println(" - Affichage tout les biens de l'agence : ");
                                System.out.println();
                                immo.affichBiens();
                                admin.suprimerBien(immo,bien5);
                                System.out.println(" - Affichage tout les biens de l'agence apres la suprimation d'un : ");
                                System.out.println();
                                immo.affichBiens();
                                immo.affichProps();
                                break;
                            case 4:
                                System.out.println(" - Suprimer plusierus biens : ");
                                System.out.println();
                                System.out.println();
                                admin.ajouterBien(immo,bien1,bien5,bien6,bien2,bien4);
                                System.out.println(" - Affichage tout les biens de l'agence : ");
                                System.out.println();
                                immo.affichBiens();
                                admin.suprimerBien(immo,bien1,bien4,bien5);
                                System.out.println(" - Affichage tout les biens de l'agence apres la suprimation d'un : ");
                                System.out.println();
                                immo.affichBiens();
                                break;
                            case 5:
                                System.out.println();
                                System.out.println(" 1 - modifier un bien. ");
                                System.out.println(" 2 - modifier une Appartement.");
                                System.out.println(" 3 - modifier une maison.");
                                System.out.println(" 4 - modifier un terrain.");
                                System.out.println();
                                System.out.print("    - entrer votre choix : ");
                                try {
                                    choix = scan.nextInt();
                                    System.out.println();
                                    if ( choix < 1 || choix > 4) throw new LogicalException();
                                }
                                catch (InputMismatchException | LogicalException e){
                                    System.out.println(" Erreur : entrer un enitier positif entre 1 et 8.");
                                }
                                catch (Exception e2){
                                    System.out.println(" Erreur : une erreur est produite.");
                                }
                                admin.ajouterBien(immo,bien1,bien5,bien6,bien2,bien4);
                                System.out.println(" - Affichage tout les biens de l'agence : ");
                                System.out.println();
                                immo.affichBiens();
                                switch (choix){
                                    case 1:
                                        System.out.println(" - Modifier un bien : ");
                                        System.out.println();
                                        System.out.println();
                                        admin.modifierBien(immo,bien2);
                                        immo.affichBien(bien2);
                                        break;
                                    case 2:
                                        System.out.println(" - Modifier une appartement : ");
                                        System.out.println();
                                        System.out.println();
                                        admin.modifierBien(immo,((Appartement)bien1));
                                        immo.affichBien(bien1);
                                        break;
                                    case 3:
                                        System.out.println(" - Modifier une maison : ");
                                        System.out.println();
                                        System.out.println();
                                        admin.modifierBien(immo,((Maison)bien2));
                                        immo.affichBien(bien2);
                                        break;
                                    case 4:
                                        System.out.println(" - Modifier un terrain : ");
                                        System.out.println();
                                        System.out.println();
                                        admin.modifierBien(immo,((Terrain)bien3));
                                        immo.affichBien(bien3);
                                        break;
                                }

                                break;
                            case 6:
                                admin.ajouterBien(immo,bien1,bien5,bien6,bien2,bien4);
                                System.out.println(" -  Modifier plusieurs biens : ");
                                System.out.println();
                                immo.affichBiens();
                                admin.modifierBiens(immo,bien1,bien2);
                                immo.affichBien(bien1,bien2);
                                break;
                            case 7:
                                admin.ajouterBien(immo,bien1,bien5,bien6,bien2,bien4);
                                System.out.println(" - Affichage de prix finale d'un bien : ");
                                System.out.println();
                                immo.affichPrixFin(bien1);
                                break;
                            case 8:
                                admin.ajouterBien(immo,bien1,bien5,bien6,bien2,bien4);
                                System.out.println(" - Affichage de prix fianele de plusieurs biens : ");
                                System.out.println();
                                immo.affichPrixFin(bien1,bien4,bien6);
                                break;
                            case 9:
                                admin.ajouterBien(immo,bien1,bien2,bien3,bien4,bien5,bien6,bien7,bien8);
                                for (int i= 0 ;i<immo.getBiens().size();i++){
                                    System.out.println();
                                    System.out.println(" prix propose : " +immo.getBiens().get(i).getPrix());
                                    System.out.println(" Prix  "+(i+1)+" : "+ (((Bien)(immo.getBiens().get(i))).calcul_prix())) ;
                                    System.out.println(" Prix finale "+(i+1)+" : "+immo.getBiens().get(i).getPrixAgence());
                                    System.out.println();
                                    System.out.println("------------------------------------------------------");
                                }
                                break;
                            case 10:
                                admin.ajouterBien(immo,bien1,bien2,bien3,bien4,bien5,bien6,bien7,bien8);
                                admin.recherchFiltres(immo);

                                break;
                            case 11:
                                immo.getMessages().add(" ce bien est magnifique");
                                immo.getMessages().add(" ce bien n'est pas bon");
                                immo.getMessages().add(" ce bien est tres bon");
                                System.out.println(" - Affichage des messages : ");
                                System.out.println();
                                System.out.println();
                                immo.affichMessages();
                                break;
                            case 12:
                                admin.ajouterBien(immo,bien1,bien2,bien3,bien4);
                                System.out.println(" les biens de l'agence : ");
                                System.out.println();
                                immo.affichBiens();
                                immo.archiver(bien2);
                                System.out.println();
                                System.out.println(" les biens apres l'archivage d'un bien : ");
                                System.out.println();
                                immo.affichBiens();


                                break;
                        }
                    }
                    catch (InputMismatchException | LogicalException e){
                        System.out.println(" Erreur : entrer un enitier positif entre 1 et 11.");
                    }
                    catch (Exception e2){
                        System.out.println(" Erreur : une erreur est produite.");
                    }
                }
                else {
                    System.out.println(" vous etes pas un admin.");
                }
                break;
            case 2:
                System.out.println("         - Utilisateur");
                System.out.println();
                System.out.println();
                System.out.println(" 1 - Afficher un bien.");
                System.out.println(" 2 - Afficher pleusieurs biens. ");
                System.out.println(" 3 - Envoyer un message a propos d'un bien.");

                try {
                    choix = scan.nextInt();
                    System.out.println();
                    if ( choix < 1 || choix > 3) throw new LogicalException();

                    immo.setConnecte(true);
                    immo.ajouter_Bien(bien1,bien2,bien3,bien4,bien5,bien6,bien7,bien8);
                    Utilisateur util = new Utilisateur();
                    switch (choix){
                        case 1:
                            System.out.println(" - Affichage d'un bien.");
                            System.out.println();
                            System.out.println();
                            immo.affichBien(bien2);
                            break;
                        case 2:
                            System.out.println(" - Affichage de plusieurs biens.");
                            System.out.println();
                            System.out.println();
                            immo.affichBien(bien1, bien4);
                            break;
                        case 3:
                            System.out.println(" - envoyer un message a propos d'un bien.");
                            System.out.println();
                            System.out.println();
                            util.envoyerMessage(immo,bien4);
                            immo.affichMessages();
                            break;
                    }
                }
                catch (InputMismatchException | LogicalException e){
                    System.out.println(" Erreur : entrer un enitier positif entre 1 et 10.");
                }
                catch (Exception e2){
                    System.out.println(" Erreur : une erreur est produite.");
                }

                break;
        }



    }
}
