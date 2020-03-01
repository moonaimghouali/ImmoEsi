

package TP;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import TP.Noyeau.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import TP.Controlls.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
      /*  Parent root = FXMLLoader.load(getClass().getResource("UI/adminLogin.fxml"));
        primaryStage.setTitle("IMMO-Login");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();*/
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = LocalDate.of(2018,12,12);
        Proprietaire prop1 = new Proprietaire("ghoulai","moonaim","ia_ghouali@esi.dz","0778222901","ouledyaich.blida");
        Proprietaire prop2 = new Proprietaire("hafri","seif","is_hafri@esi.dz","0778222901","harrach");
        Proprietaire prop3 = new Proprietaire("pacino","al","ia_ghouali@esi.dz","0778222901","blida");
        Proprietaire prop4 = new Proprietaire("pecsi","joe","ia_ghouali@esi.dz","0778222901","ouledyaich.blida");


        wilaya wilaya1 = new wilaya(100000,wilayas.BLIDA);
        wilaya wilaya2 = new wilaya(30000,wilayas.ALGER);
        wilaya wilaya3 = new wilaya(60000,wilayas.TIPAZA);
        wilaya wilaya4 = new wilaya(50000,wilayas.SETIF);
        Bien bien1 = null ;
        Bien bien2 = null;
        Bien bien3 = null;
        Bien bien4 = null;
        Bien bien5 = null;
        Bien bien6 = null;
        Bien bien7 = null;
        Bien bien8 =null;
        try {
            bien1 = new Appartement(TypeApp.DUPLEXE,false,1,true,4,"a",Ebiens.Appartement,wilaya2,120,Transaction.vente,false," une bonne appartement",d1,"photo1 , photo2",true,4000000,prop2);
            bien2 = new Maison(3,false,true,false,190,true,6,"c",Ebiens.Maison,wilaya3,200,Transaction.vente,false," une maison de luxe ",d1," phot1 , phot2",true,10000000,prop1);
            bien3 = new Terrain("promesse de vente",3,"a",Ebiens.Terrain,wilaya1,500,Transaction.vente,false," une bon terrain",d1,"photo 3",true,20000000,prop1);
            bien4 = new Appartement(TypeApp.DUPLEXE,false,1,true,3,"a",Ebiens.Appartement,wilaya3,100,Transaction.location,false," une bonne appartement",d1,"photo1 , photo2",true,40000,prop2);
            bien5 = new Maison(6,false,false,true,160,true,6,"l",Ebiens.Maison,wilaya2,160,Transaction.location,false,"bien creer aujourdhui",d2," phot1 , phot2",true,150000,prop3);
            bien6 = new Appartement(TypeApp.SIMPLEXE,false,6,true,3,"z",Ebiens.Appartement,wilaya3,50,Transaction.location,false," une bonne appartement",d1,"photo1 , photo2",true,600000,prop2);
            bien7 = new Terrain("promesse de vente",1,"y",Ebiens.Terrain,wilaya1,650,Transaction.echange,false," une bon terrain",d1,"photo 3",true,18000000,prop1);
            bien8 = new Maison(6,true,false,false,170,true,6,"r",Ebiens.Maison,wilaya2,200,Transaction.location,false," une maison de luxe ",d1," phot1 , phot2",true,14000000,prop2);

        }catch (LogicalException e){
            System.out.println(" verifier les donnes inseres comme la superficie habitable, nombre de facades, nombre de pieces, ");
        } catch (Exception e) {
            System.out.println(" Erreur : une erreur est produite.");
        }
        Agence immo = new Agence();
        immo.ajouter_Bien(bien6,bien1,bien2,bien3,bien4,bien5,bien7,bien8);
        ArrayList<String> p = new ArrayList<String>();
        p.add("ce bien est bon monsieur");
        p.add("ce bien est bon monsieur");
        p.add("cet appartemt bon monsieur");

        immo.setMessages(p);
        window window = new window(immo);
        window.affichLoginMenu(immo);
       //System.out.println(immo.getBiens().size());
    }
    //public void administrationView(Window window) throws IOException {
      //  Parent root = FXMLLoader.load(getClass().getResource("UI/adminLogin.fxml"));
        //((Stage)window).setScene(new Scene(root,1000,600));

    //


    public static void main(String[] args)
    {
        launch(args);
    }
}
