package TP.Controlls;

import TP.Noyeau.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class fiterController {

    ObservableList<wilayas> province = FXCollections.observableArrayList(TP.Noyeau.wilayas.ADRAR ,TP.Noyeau.wilayas.CHLEF, TP.Noyeau.wilayas.LAGHOUAT, TP.Noyeau.wilayas.OUMBOUAGHI, TP.Noyeau.wilayas.BATNA, TP.Noyeau.wilayas.BEJAIA, TP.Noyeau.wilayas.BISKRA,TP.Noyeau.wilayas.BECHAR, TP.Noyeau.wilayas.BLIDA, TP.Noyeau.wilayas.BOUIRA, TP.Noyeau.wilayas.TAMANRASSET, TP.Noyeau.wilayas.TEBESSA, TP.Noyeau.wilayas.TLEMCEN, TP.Noyeau.wilayas.TIARET, TP.Noyeau.wilayas.TIZIOUZOU, TP.Noyeau.wilayas.ALGER, TP.Noyeau.wilayas.DJELFA,TP.Noyeau.wilayas.JIJEL, TP.Noyeau.wilayas.SETIF, TP.Noyeau.wilayas.SAIDA, TP.Noyeau.wilayas.SKIKDA, TP.Noyeau.wilayas.SIDIBELABBES, TP.Noyeau.wilayas.ANNABA, TP.Noyeau.wilayas.GUELMA, TP.Noyeau.wilayas.CONSTANTINE, TP.Noyeau.wilayas.MEDEA, TP.Noyeau.wilayas.MOSTAGANEM, TP.Noyeau.wilayas.MSILA, TP.Noyeau.wilayas.MASCARA,TP.Noyeau.wilayas.OUARGLA, TP.Noyeau.wilayas.ORAN, TP.Noyeau.wilayas.ELBAYDH, TP.Noyeau.wilayas.ILLIZI,TP.Noyeau.wilayas.BORDJBOUARRERIDJ,TP.Noyeau.wilayas.BOUMERDES,TP.Noyeau.wilayas.ELTAREF,TP.Noyeau.wilayas.TINDOUF, TP.Noyeau.wilayas.TISSEMSILT, TP.Noyeau.wilayas.ELOUED, TP.Noyeau.wilayas.KHENCHLA, TP.Noyeau.wilayas.SOUKAHRASS, TP.Noyeau.wilayas.TIPAZA, TP.Noyeau.wilayas.MILA, TP.Noyeau.wilayas.AINDEFLA,TP.Noyeau.wilayas.NAAMA, TP.Noyeau.wilayas.AINTEMOUCHENT, TP.Noyeau.wilayas.GHARDAIA, TP.Noyeau.wilayas.RELIZANE);
    ObservableList<Transaction> transactions = FXCollections.observableArrayList(Transaction.vente,Transaction.location,Transaction.echange);
    ObservableList<Ebiens> Biens = FXCollections.observableArrayList(Ebiens.Maison,Ebiens.Appartement,Ebiens.Terrain,Ebiens.Habitable,Ebiens.Bien);



    @FXML
    private Button validateBtn;

    @FXML
    private Button showEstBtn;

    @FXML
    private Button addEstBtn;

    @FXML
    private Button showOwnBtn;

    @FXML
    private Button fltEstBtn;

    @FXML
    private Button chkMsgBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private TextField prixMaxTf;

    @FXML
    private TextField prixMinTf;

    @FXML
    private ChoiceBox<TP.Noyeau.wilayas> wilayas;

    @FXML
    private ChoiceBox<Ebiens> typeBiens;
    @FXML
    private Label warningLab;

    @FXML
    private ChoiceBox<Transaction> transaction;

    @FXML
    public void initialize(){
        wilayas.setItems(province);
        wilayas.setValue(TP.Noyeau.wilayas.ALGER);
        transaction.setItems(transactions);
        transaction.setValue(Transaction.vente);
        typeBiens.setItems(Biens);
        typeBiens.setValue(Ebiens.Appartement);
        //System.out.println("lol");
    }
    @FXML
    void showEstate(javafx.event.ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowEst();

        System.out.println();;
    }

    @FXML
    void addEstate(javafx.event.ActionEvent event) {
        System.out.println(" hello ");
        //((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichAddEst();
    }

    @FXML
    void fltrEstate(javafx.event.ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window win = new window();
        win.affichFilterEst();
    }

    @FXML
    void showOwners(javafx.event.ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowOwn();
    }

    @FXML
    void chkMessages(javafx.event.ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichCheckMessages();
    }

    @FXML
    void logOut(ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichLoginMenu(w.getAgence());
    }

    public void valider(){
        System.out.println("mooonaim");
       // System.out.println("welcome");
        if (prixMaxTf.getText().equals("")&&prixMinTf.getText().equals("")){
            warningLab.setText("you must fill the textfields.");
        }else {

            Prix_min prixMin = new Prix_min(Long.parseLong(prixMinTf.getText().trim()));
            Prix_max prixMax = new Prix_max(Long.parseLong(prixMaxTf.getText().trim()));
            wilaya wilaya = new wilaya(0, this.wilayas.getValue());
            Type_bien bien = new Type_bien(typeBiens.getValue());
            Type_transaction transaction = new Type_transaction(this.transaction.getValue());

            window w = new window();
            ArrayList<Bien> biens = w.getAgence().recherchFiltres(prixMax, prixMin, wilaya, bien, transaction);
            showfilterestController c = new showfilterestController();
            c.setBiensAfficher(biens);
            w.getAgence().affichBien(biens);
            if (biens.size()>0){
                ((Stage) (showEstBtn.getScene().getWindow())).close();
                w.affichEstatefiltre();
            }else {
                warningLab.setText("No estate meets your search filters");
            }

        }

    }

}
