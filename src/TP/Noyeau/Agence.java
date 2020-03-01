package TP.Noyeau;
import java.util.*;

public class Agence {

	//////declaration
    //private Admin admin;
	private ArrayList<Bien> biens = new ArrayList<Bien>();
	private ArrayList<Bien> biensArchives = new ArrayList<Bien>();
	private static int NbBien = 0 ;
	private boolean connecte;

	private static ArrayList<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
	private static ArrayList<String> messages = new ArrayList<String>();

    // hashmap pour mapper les differentes willayas et leur matricule
    HashMap<Integer, wilaya> mapWilaya = new HashMap<>() {{
        put(1, new wilaya(0, wilayas.ADRAR));
        put(2, new wilaya(0, wilayas.CHLEF));
        put(3, new wilaya(0, wilayas.LAGHOUAT));
        put(4, new wilaya(0, wilayas.OUMBOUAGHI));
        put(5, new wilaya(0, wilayas.BATNA));
        put(6, new wilaya(0, wilayas.BEJAIA));
        put(7, new wilaya(0, wilayas.BISKRA));
        put(8, new wilaya(0, wilayas.BECHAR));
        put(9, new wilaya(0, wilayas.BLIDA));
        put(10, new wilaya(0, wilayas.BOUIRA));
        put(11, new wilaya(0, wilayas.TAMANRASSET));
        put(12, new wilaya(0, wilayas.TEBESSA));
        put(13, new wilaya(0, wilayas.TLEMCEN));
        put(14, new wilaya(0, wilayas.TIARET));
        put(15, new wilaya(0, wilayas.TIZIOUZOU));
        put(16, new wilaya(0, wilayas.ALGER));
        put(17, new wilaya(0, wilayas.DJELFA));
        put(18, new wilaya(0, wilayas.JIJEL));
        put(19, new wilaya(0, wilayas.SETIF));
        put(20, new wilaya(0, wilayas.SAIDA));
        put(21, new wilaya(0, wilayas.SKIKDA));
        put(22, new wilaya(0, wilayas.SIDIBELABBES));
        put(23, new wilaya(0, wilayas.ANNABA));
        put(24, new wilaya(0, wilayas.GUELMA));
        put(25, new wilaya(0, wilayas.CONSTANTINE));
        put(26, new wilaya(0, wilayas.MEDEA));
        put(27, new wilaya(0, wilayas.MOSTAGANEM));
        put(28, new wilaya(0, wilayas.MSILA));
        put(29, new wilaya(0, wilayas.MASCARA));
        put(30, new wilaya(0, wilayas.OUARGLA));
        put(31, new wilaya(0, wilayas.ORAN));
        put(32, new wilaya(0, wilayas.ELBAYDH));
        put(33, new wilaya(0, wilayas.ILLIZI));
        put(34, new wilaya(0, wilayas.BORDJBOUARRERIDJ));
        put(35, new wilaya(0, wilayas.BOUMERDES));
        put(36, new wilaya(0, wilayas.ELTAREF));
        put(37, new wilaya(0, wilayas.TINDOUF));
        put(38, new wilaya(0, wilayas.TISSEMSILT));
        put(39, new wilaya(0, wilayas.ELOUED));
        put(40, new wilaya(0, wilayas.KHENCHLA));
        put(41, new wilaya(0, wilayas.SOUKAHRASS));
        put(42, new wilaya(0, wilayas.TIPAZA));
        put(43, new wilaya(0, wilayas.MILA));
        put(44, new wilaya(0, wilayas.AINDEFLA));
        put(45, new wilaya(0, wilayas.NAAMA));
        put(46, new wilaya(0, wilayas.AINTEMOUCHENT));
        put(47, new wilaya(0, wilayas.GHARDAIA));
        put(48, new wilaya(0, wilayas.RELIZANE));
    }};

	//////constructor
	public Agence () { }
	public Agence(Admin admin){
	    //this.admin = admin;
	    this.connecte = false;
    }

	////// getters and setters

    public HashMap<Integer, wilaya> getMapWilaya() {
        return mapWilaya;
    }
    public ArrayList<Bien> getBiens() {
		return biens;
	}
	public void setBiens(ArrayList<Bien> biens) {
		this.biens = biens;
	}
    public static ArrayList<Proprietaire> getProprietaires() {
        return proprietaires;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }
    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }



    ////// boolean functions
	public boolean notContainBien(Bien bien){
		return !this.biens.contains(bien);
	}
	public boolean notContainProp(Proprietaire p){
		return !this.proprietaires.contains(p);
	}
    public boolean isConnecte() {
        return connecte;
    }
    public void setConnecte(boolean connecte) {
        this.connecte = connecte;
    }

    ////// affichage des proprietaires et les biens
    public void affichBiensProp(Proprietaire p ){
        System.out.println(" les biens de le proprietaire "+p.getNom()+" "+p.getPrenom()+" sont : ");
        System.out.println("");
        System.out.println("");
	    for (Bien b : p.getBiensProprietaires()){
	        b.afficher();
        }
    }
    public void affichBiensProps(Proprietaire ... proprietaires){
	    for (Proprietaire p : proprietaires){
	        this.affichBiensProp(p);
        }
    }
    public void affichProp(Proprietaire p){
	    p.afficher();
    }
	public void affichProps(){
		for (Proprietaire p : proprietaires){
			p.afficher();
		}
	}
	public void affichBien(Bien bien){
	    if (bien.isVisibilite())
	    bien.afficher();
    }
    public void affichBien(Bien ...biens){
	    for (Bien b : biens){
	        this.affichBien(b);
        }
    }
	public void affichBiens(){
		if (biens.size() != 0){
			int i = 0 ;
			for (Bien b : biens) {
				if (b.isVisibilite() == true) {
					System.out.println();
					System.out.println("---------------------------------------");
					i++;
					b.afficher();
					System.out.println(" Le bien numero : " + i);
					System.out.println("---------------------------------------");
					System.out.println();
				}
			}
		}
	}
	public void consulter(Bien b){
		if (b.isVisibilite() == true)
		b.afficherDetail();
		else System.out.println(" Ce bien n'est pas disponible pour le moment. ");
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

	////// archiver
    public void archiver(Bien b){
	   biensArchives.add(b);
	   biens.remove(b);
    }
    public void archiver(Bien ... biens){
	    for (Bien b : biens){
	        this.archiver(b);
        }
    }

	////// suprimer les biens
	public void suprimerBien(Bien b ){

            this.NbBien --;
            this.biens.remove(b);
            b.getProprietaire().getBiensProprietaires().remove(b);
            if (b.getProprietaire().getBiensProprietaires().size() == 0 ){
                this.proprietaires.remove(b.getProprietaire());
            }
            b.getProprietaire().getBiensProprietaires().remove(b);
            b.setProprietaire(null);
	}
	public void suprimerBien(Bien ... b){
            for (Bien bien : b){
                this.suprimerBien(bien);
            }
	}

	////// ajouter un bien
	public void ajouter_Bien (Bien bien){
	        bien.setPrixAgence(bien.calcul_prix());
            bien.getProprietaire().getBiensProprietaires().add(bien);
            if (this.notContainBien(bien)){
                biens.add(bien);
                NbBien ++;
            }
            if (this.notContainProp(bien.getProprietaire())){
                proprietaires.add(bien.getProprietaire());
            }
	}
	public void ajouter_Bien (Bien ... biens ){

            for (Bien b : biens){
                this.ajouter_Bien(b);
            }
    }

    ////// trier les biens.
    public void trier(){
	    Collections.sort(this.biens);
    }

    ////// afficher les messages
    public void affichMessages(){
	    if (isConnecte()){
            int i =1;
	        for (String s : messages){
                System.out.println(" message "+i+" : "+s);
                i++;
            }
        }
    }

	////// recherche filtrer
	public ArrayList<Bien> recherchFiltres(Critere ... criteres){
		ArrayList<Bien> tab = new ArrayList<Bien>();
			tab = this.biens;
		for (Critere c : criteres){
			for (int i = 0 ; i<tab.size(); i++){
				if (c instanceof Prix_max){
					if (tab.get(i).getPrixAgence() > ((Prix_max)c).getPrix_max()){
						tab.remove(tab.get(i));
					}
				}
				if(c instanceof Prix_min){
					if (tab.get(i).getPrixAgence() < ((Prix_min)c).getPrix_min() ){
						tab.remove(tab.get(i));
					}
				}
				if (c instanceof wilaya){
					if (!(((wilaya)tab.get(i).getWillaya()).getW() == ((wilaya)c).getW())){
						tab.remove(tab.get(i));
					}
				}

				if (c instanceof Type_bien){
					if (((Type_bien)c).getType() != tab.get(i).getType_bien()){
						tab.remove(tab.get(i));
					}
				}
				if (c instanceof Type_transaction){
					if (((Type_transaction)c).getTransaction() != tab.get(i).getTransaction()){
						tab.remove(tab.get(i));
					}
				}
			}
		}
		return tab;
	}

	////// modification de bien
	public void modifierBien( Bien bien) throws Exception{
	    if (biens.contains(bien)) {
            if (bien.isVisibilite()) {
                bien.afficher();
                System.out.println("   - choisir les champs que vous voulez changer ");
                System.out.println(" 1 - La willaya");
                System.out.println(" 2 - Nombre de pieces");
                System.out.println(" 3 - Le proprietaire"); //will throw an exception if owner doesnt exist
                System.out.println(" 4 - La superficie");
                System.out.println(" 5 - Type de transaction");
                System.out.println(" 6 - La negociabilite");
                System.out.println(" 7 - Le  descriptif");
                System.out.println(" 8 - Le prix");
                System.out.println(" 0 - Quitter");

                Scanner scan = new Scanner(System.in);
                ArrayList<Integer> tab = new ArrayList<Integer>();
                System.out.println();
                System.out.print(" entrer votre choix : ");
                int choix;
                do {
                    choix = scan.nextInt();
                    if (((choix >= 1) && (choix <= 8)) && (!tab.contains(choix))) {
                        tab.add(choix);
                    }
                } while ((choix != 0));

                for (Integer i : tab) {
                    int num = -1;
                    switch (i) {
                        case 1:
                            System.out.print(" entrer le matricule de la nouvelle willaya : ");

                            try {
                                num = scan.nextInt();
                                System.out.println();
                                if (num < 1 || num > 48) throw new NumberOutOfBoundaries();

                            } catch (InputMismatchException | NumberOutOfBoundaries e) {
                                System.out.print(" Erreur : veilluez entrer un entier entre 1 et 48. ");
                                System.out.println();
                                System.out.println();
                                this.modifierBien(bien);
                            } catch (Exception e1) {
                                System.out.println();
                                System.out.print(" Erreur : une est erreur est produite.");
                            }

                            bien.setWillaya(mapWilaya.get(num));

                            break;
                        case 2:
                            if (bien instanceof Habitable) {
                                System.out.print(" entrer le nombre de pieces : ");

                                try {
                                    num = scan.nextInt();
                                    System.out.println();
                                    if (num < 1) throw new NumberOutOfBoundaries();
                                } catch (InputMismatchException | NumberOutOfBoundaries e) {
                                    System.out.print(" Erreur : entrer un entier superieure a 1. ");
                                } catch (Exception e2) {
                                    System.out.println(" Erreur : une erreur est produite.");
                                }
                                ((Habitable) bien).setNbr_pieces(num);
                            } else {
                                System.out.println(" ce bien ne contient pas ce champ");
                            }

                            break;
                        case 3:
                            String nom = "";
                            String prenom = "";
                            String email = "";
                            String tel = "";
                            String adr = "";
                            try {
                                System.out.println("donner les nouvelles coordonnees du proprietaire ");
                                System.out.print("Nom : ");
                                nom = scan.nextLine();
                                System.out.println();
                                System.out.print("Prenom : ");
                                prenom = scan.nextLine();
                                System.out.println();
                                System.out.print(" Email :");
                                email = scan.nextLine();
                                System.out.println();
                                System.out.print("Telephone : ");
                                tel = scan.nextLine();
                                System.out.println();
                                System.out.print("Adresse : ");
                                adr = scan.nextLine();
                                System.out.println();
                            } catch (Exception e) {
                                System.out.println(" Erreur : ");
                            }
                            Proprietaire p = new Proprietaire(nom, prenom, email, tel, adr);
                            Proprietaire p2 = bien.getProprietaire();
                            if (p2.getBiensProprietaires().size() == 1) {
                                p2.getBiensProprietaires().remove(bien);
                                proprietaires.remove(p2);
                            }
                            p.getBiensProprietaires().add(bien);
                            proprietaires.add(p);
                            bien.setProprietaire(p);

                            break;
                        case 4:
                            System.out.print(" Entrer la nouvelle superficie :  ");
                            System.out.println();

                            float superficie = 0;
                            try {
                                superficie = scan.nextFloat();
                                if (bien instanceof Maison) {
                                    if (superficie < ((Maison) bien).getSuperficieHabitable()) {
                                        throw new LogicalException();
                                    }
                                }
                            } catch (InputMismatchException | LogicalException e) {
                                System.out.println(" Erreur : entrer un nombre superieure a la superficie habitable.");
                            } catch (Exception e2) {
                                System.out.println(" Erreur: une erreur est produite.");
                            }


                            bien.setSuperficie((float) superficie);

                            break;
                        case 5:
                            HashMap<Integer, Type_transaction> mapTypeTrans = new HashMap<>() {{
                                put(1, new Type_transaction(Transaction.vente));
                                put(2, new Type_transaction(Transaction.location));
                                put(3, new Type_transaction(Transaction.echange));
                            }};

                            System.out.println(" 1 - vente ");
                            System.out.println(" 2 - location ");
                            System.out.println(" 3 - echange ");
                            System.out.print(" Inserer votre choix : ");
                            try {

                                num = scan.nextInt();
                                System.out.println();
                                if (num > 3 || num < 1) throw new LogicalException();
                            } catch (InputMismatchException | LogicalException e) {
                                System.out.print(" Erreur : entrer un entier entre 1 et 3.");
                            } catch (Exception e2) {
                                System.out.println(" Erreur : une erreur est produite.");
                            }
                            bien.setTransaction(mapTypeTrans.get(num).getTransaction());
                            break;
                        case 6:
                            bien.setNegociabilite();
                            break;
                        case 7:
                            System.out.print(" entrer un nouveau descriptif : ");
                            String s = scan.next();
                            bien.setDescriptif(s);
                            break;
                        case 8:
                            float prix = 0;
                            System.out.println(" entrer le nouveau prix : ");
                            try {
                                prix = scan.nextFloat();
                                if (prix <= 0) throw new LogicalException();
                            } catch (InputMismatchException | LogicalException e) {
                                System.out.print(" Erreur : entrer un nombre positif.");
                            } catch (Exception e2) {
                                System.out.println(" Erreur : une erreur est produite.");
                            }
                            bien.setPrix(prix);
                            break;
                        default:
                            bien.setPrixAgence(bien.calcul_prix());
                            break;
                    }
                }
            }else {
                System.out.println(" ce bien est archive.");
            }
        }
	    else System.out.println(" ce biens n'existe pas dans l'agence.");
    }
    public void modifierBien( Bien ... biens) throws Exception{
	    for (Bien b : biens){
	        this.modifierBien(b);
        }
    }

    ////// modification d'appartement
    public void modifierBien(Appartement app) throws Exception {
        if (app.isVisibilite()) {
            app.afficher();
            this.modifierBien(((Bien) app));
            System.out.println("   - choisir les champs que vous voulez changer ");
            System.out.println(" 1 - Nombre d'etages");
            System.out.println(" 2 - Disponibilite d'assenceur");
            System.out.println(" 3 - Type d'appartement"); //will throw an exception if owner doesnt exist
            System.out.println(" 0 - Quitter");

            Scanner scan = new Scanner(System.in);
            ArrayList<Integer> tab = new ArrayList<Integer>();
            System.out.println();
            System.out.print(" entrer votre choix : ");
            int choix;
            do {
                choix = scan.nextInt();
                if (((choix >= 1) && (choix <= 3)) && (!tab.contains(choix))) {
                    tab.add(choix);
                }
            } while ((choix != 0));
            for (Integer i : tab){
                int num = -1;
                switch (i) {
                    case 1:
                        System.out.print(" entrer le nouveau nombre d'etages : ");

                        try {
                            num = scan.nextInt();
                            System.out.println();
                            if (num < 1 ) throw new LogicalException();

                        }catch (InputMismatchException | LogicalException e){
                            System.out.print(" Erreur : veilluez entrer un entier superieure a 0. ");
                        }catch ( Exception e1 ){
                            System.out.print(" Erreur : une est erreur est produite.");
                        }
                        app.setNbrEtages(num);
                        break;
                    case 2:
                        app.setDispoAssenceur(!app.isDispoAssenceur());
                        break;
                    case 3:
                        HashMap<Integer, TypeApp> mapNatureApp = new HashMap<>() {{
                            put(1, TypeApp.SIMPLEXE);
                            put(2, TypeApp.DUPLEXE);
                        }};

                        System.out.println(" 1 - Simplexe ");
                        System.out.println(" 2 - Duplexe ");
                        System.out.println();
                        System.out.print(" Inserer votre choix : ");
                        try {
                            num = scan.nextInt();
                            System.out.println();
                            if (num>2 || num <1) throw new LogicalException();
                        }catch (InputMismatchException | LogicalException e){
                            System.out.print(" Erreur : entrer un entier entre 1 et 2.");
                        }catch (Exception e2){
                            System.out.println(" Erreur : une erreur est produite.");
                        }
                        app.setNatureApp(mapNatureApp.get(num));
                        break;
                    default:
                        app.setPrixAgence(app.calcul_prix());
                        break;
        }
    }
}
        else {
            System.out.println(" cette appartement est archivee");
        }
    }

	////// modification de maison
    public void modifierBien(Maison maison) throws Exception{
        if (maison.isVisibilite()) {
            maison.afficherDetail();
            this.modifierBien(((Bien) maison));
            System.out.println("   - choisir les champs que vous voulez changer ");
            System.out.println(" 1 - Nombre d'etages");
            System.out.println(" 2 - Disponibilite de garage");
            System.out.println(" 3 - Disponibilite de pisciene");
            System.out.println(" 4 - Disponibilite de jardin");
            System.out.println(" 5 - Superficie habitable"); //will throw an exception if owner doesnt exist
            System.out.println(" 0 - Quitter");

            Scanner scan = new Scanner(System.in);
            ArrayList<Integer> tab = new ArrayList<Integer>();
            System.out.println();
            System.out.print(" entrer votre choix : ");
            int choix;
            do {
                choix = scan.nextInt();
                if (((choix >= 1) && (choix <= 5)) && (!tab.contains(choix))) {
                    tab.add(choix);
                }
            } while ((choix != 0));
            for (Integer i : tab){
                int num = -1;
                switch (i) {
                    case 1:
                        System.out.print(" entrer le nouveau nombre d'etages : ");

                        try {
                            num = scan.nextInt();
                            System.out.println();
                            if (num < 1 ) throw new LogicalException();

                        }catch (InputMismatchException | LogicalException e){
                            System.out.print(" Erreur : veilluez entrer un entier superieure a 0. ");
                        }catch ( Exception e1 ){
                            System.out.print(" Erreur : une est erreur est produite.");
                        }
                        maison.setEtages(num);
                        break;
                    case 2:
                        maison.setDispoGarage(!maison.isDispoGarage());
                        break;
                    case 3:
                        maison.setDispoPiscine(!maison.isDispoPiscine());
                        break;
                    case 4:
                        maison.setDispoJardin(!maison.isDispoJardin());
                        break;
                    case 5:
                        System.out.print(" entrer la nouvelle superficie habitable : ");
                        try {
                            num = scan.nextInt();
                            System.out.println();
                            if (num > maison.getSuperficie() ) throw new LogicalException();

                        }catch (InputMismatchException | LogicalException e){
                            System.out.print(" Erreur : entrer un nombre inferieure a la superficie. ");
                        }catch ( Exception e1 ){
                            System.out.print(" Erreur : une est erreur est produite.");
                        }
                        maison.setSuperficieHabitable(num);
                        break;
                    default:
                        maison.setPrixAgence(maison.calcul_prix());
                        break;
                }
            }
        } else {
            System.out.println(" cette maison est archivee.");
        }

    }

    ////// modificationTerrain
    public void modifierBien( Terrain terr)throws Exception{
        if (terr.isVisibilite()) {
            terr.afficher();
            this.modifierBien(((Bien) terr));
            System.out.println("   - choisir les champs que vous voulez changer ");
            System.out.println(" 1 - Statut juridique");
            System.out.println(" 2 - Nombre de facades");
            System.out.println(" 0 - Quitter");

            Scanner scan = new Scanner(System.in);
            ArrayList<Integer> tab = new ArrayList<Integer>();
            System.out.println();
            System.out.print(" entrer votre choix : ");
            int choix;
            do {
                choix = scan.nextInt();
                if (((choix >= 1) && (choix <= 2)) && (!tab.contains(choix))) {
                    tab.add(choix);
                }
            } while ((choix != 0));
            for (Integer i : tab){
                int num = -1;
                String s ="";
                switch (i) {
                    case 1:
                        System.out.print(" entrer le nouveau nombre d'etages : ");

                        try {
                            s = scan.next();
                            System.out.println();
                        }catch ( Exception e1 ){
                            System.out.print(" Erreur : une est erreur est produite.");
                        }
                        terr.setStatutJuridique(s);
                        break;
                    case 2:
                        System.out.print(" entrer le nouveau nombre de facades : ");

                        try {
                            num = scan.nextInt();
                            System.out.println();
                            if (num <1) throw new LogicalException();
                        }catch (InputMismatchException | LogicalException e){
                            System.out.print(" Erreur : veilluez entrer un entier superieure a 0. ");
                        }catch ( Exception e1 ){
                            System.out.print(" Erreur : une est erreur est produite.");
                        }
                        terr.setNbrFacades(num);
                        break;

                    default:
                        terr.setPrixAgence(terr.calcul_prix());
                        break;
                }
            }
        } else {
            System.out.println(" ce terrain est archive");
        }

    }

    public void affichBien(ArrayList<Bien> biens) {
	    for (Bien b : biens){
	        b.afficherDetail();
        }
    }
}
