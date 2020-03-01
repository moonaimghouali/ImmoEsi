package TP.Noyeau;
import java.util.ArrayList;

public class Proprietaire {
 /////// Declaration
 private String  nom;
 private String prenom;
 private String email;
 private String tel;
 private String adresse;
 private ArrayList<Bien> biensProprietaires = new ArrayList<Bien>();

 	////// Constructor
	public Proprietaire(String nom, String prenom, String email, String tel, String adr) {
		this.nom = nom;
		this.prenom = prenom;;
		this.email  = email;
		this.tel = tel;
		this.adresse = adr;
	}

	////// getters and setters
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public ArrayList<Bien> getBiensProprietaires() { return biensProprietaires; }
	public void setBiensProprietaires(ArrayList<Bien> biensProprietaires) { this.biensProprietaires = biensProprietaires;}

	public String getTel() {
		return tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getEmail() {
		return email;
	}

	////// affichage de proprietaire
	public void afficher(){
		System.out.println(" Nom : "+this.nom);
		System.out.println(" Prenom : "+this.prenom);
		System.out.println(" Adresse : "+this.adresse);
		System.out.println(" Telephone : "+this.tel);
		System.out.println(" E-mail : "+this.email);
	}



}
