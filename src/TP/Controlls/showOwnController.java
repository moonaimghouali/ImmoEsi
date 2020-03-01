package TP.Controlls;

import TP.Noyeau.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class showOwnController {

    private static int indice = 0;

    @FXML
    private Button nextBtn;



    @FXML
    private Button showEstBtn;

    @FXML
    private Button addEstBtn;

    @FXML
    private Button ownEstBtn;

    @FXML
    private Button showOwnBtn;

    @FXML
    private Button fltEstBtn;

    @FXML
    private Button chkMsgBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Label NameLab;

    @FXML
    private Label firstNameLab;

    @FXML
    private Label phoneLab;

    @FXML
    private Label emailLab;

    @FXML
    private Label adrsLab;

    @FXML
    private Label estNbrLab;

    @FXML
    public void initialize(){
        indice %= window.getAgence().getProprietaires().size();
        Proprietaire p = window.getAgence().getProprietaires().get(indice);
        NameLab.setText(NameLab.getText()+" "+p.getNom());
        firstNameLab.setText(firstNameLab.getText()+" "+p.getPrenom());
        phoneLab.setText(phoneLab.getText()+" "+p.getTel());
        emailLab.setText(emailLab.getText()+" "+p.getEmail());
        adrsLab.setText(adrsLab.getText()+" "+p.getAdresse());
        estNbrLab.setText(estNbrLab.getText()+" "+p.getBiensProprietaires().size());

    }
    @FXML
    void Next(ActionEvent event) {
        indice++;
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowOwn();

    }

    @FXML
    void showOwnEst(ActionEvent event) {
        System.out.println(" hello ");
        //indice =0;
        ((Stage) (showEstBtn.getScene().getWindow())).close();

        window w = new window();
        Proprietaire p = w.getAgence().getProprietaires().get(indice);
        ArrayList<Bien> biens = p.getBiensProprietaires();
        w.affichShowEst(biens);
        System.out.println();;
    }

    @FXML
    void ShowEst(ActionEvent event){
        //System.out.println(" hello ");
        indice = 0;
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowEst();

    }

    @FXML
    void addEstate(ActionEvent event) {
        //System.out.println(" hello ");
        indice = 0;
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichAddEst();
    }

    @FXML
    void fltrEstate(ActionEvent event) {
        System.out.println(" hello ");
        indice = 0;
        //((Stage) (showEstBtn.getScene().getWindow())).close();
        window win = new window();
        win.affichFilterEst();
    }

    @FXML
    void showOwners(ActionEvent event) {
        System.out.println(" hello ");
        indice = 0;
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowOwn();
    }

    @FXML
    void chkMessages(ActionEvent event) {
        System.out.println(" hello ");
        indice = 0;
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichCheckMessages();
    }

    @FXML
    void logOut(ActionEvent event) {
        System.out.println(" hello ");
        indice = 0;
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichLoginMenu(w.getAgence());
    }


}
