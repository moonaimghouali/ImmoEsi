package TP.Controlls;

import TP.Noyeau.Agence;
import TP.Noyeau.Bien;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class window extends Stage {
    private static Agence agence ;
    private static Stage stage;
    private static ArrayList<Bien> ownerbiens = new ArrayList<Bien>();
    public static ArrayList<Bien> getOwnerbiens() {
        return ownerbiens;
    }
    public static Agence getAgence() {
        return agence;
    }
    public static void setAgence(Agence agence) {
        window.agence = agence;
    }

    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    public window(Agence a,Stage s){
        this.agence = a;
        this.stage = s;
    }
    public window(){

    }
    public window(Agence a){
        this.agence = a;
    }

    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    public void affichLoginMenu(Agence a){
        setAgence(a);
        Stage window = new Stage();
        this.stage = window;
        FXMLLoader loader = new FXMLLoader();
        //administrationController root ;
        try {
            loader.setLocation(getClass().getResource("../UI/adminLogin.fxml"));
            Pane p = loader.load();
            stage.setScene(new Scene(p));
            stage.setTitle("IMMO");
            stage.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichAdministration(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/administrationMenu.fxml"));
            Pane p = loader.load();
            administrationController a = new administrationController();
            stage.setScene(new Scene(p));
            stage.setTitle("IMMO");
            stage.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichFilterEst(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/filterest.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("jkaskjf");
        }
    }
    public void affichAddEst(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/addchoix.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p, 400, 200));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("nigro");
        }
    }
    public void affichAddMaison(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/addmaison.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void affichAddAppartement(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/addappartement.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichAddterrain(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/addterrain.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichCheckMessages(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/checkmessages.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p, 1000, 600));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichShowEst(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/showest.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p, 1000, 600));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichShowEst(ArrayList<Bien> biens){
        ownerbiens = biens;
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/showownest.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p, 1000, 600));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichShowOwnEst(ArrayList<Bien> biens){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/showownest.fxml"));
            Pane p = loader.load();
            showownestController c = new showownestController();
            c.setBiensAfficher(biens);
            //root.setBiens(biens);
            window.setScene(new Scene(p, 1000, 600));
            window.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichShowOwnEst(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/showownest.fxml"));
            Pane p = loader.load();
            window.setScene(new Scene(p, 1000, 600));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichShowOwn(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/showown.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p, 1000, 600));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("moonaim");
        }
    }
    public void affichEstatefiltre(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/showfilterEst.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("sfsfsafo");
        }

    }
    public void affichUserMenu(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/UserMenu.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p));
            window.setTitle("IMMO");
            window.show();

        }catch (Exception e)
        {
            System.out.println("hello");
        }
    }
    public void affichSendMessage(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/sendmessgae.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p));
            window.setTitle("IMMO");
            window.setTitle("IMMO");
            window.show();


        }catch (Exception e)
        {
            System.out.println("mjkasjfd");
        }
    }
    public void affichShowEstUser(){
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../UI/showEstUser.fxml"));
            Pane p = loader.load();
            //root.setBiens(biens);
            window.setScene(new Scene(p));
            window.show();

        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("moonaim");

        }

    }

}
