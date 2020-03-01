package TP.Controlls;

import TP.Noyeau.Proprietaire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class checkMessagesController {
    private static int indice = 0;

    @FXML
    private Button nextBtn;

    @FXML
    private Label msg;
    @FXML
    private Label msgLab;

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

    public void initialize(){
        indice %= window.getAgence().getMessages().size();
        msg.setText(msg.getText()+" "+(indice+1)+": ");
        msgLab.setText(msgLab.getText()+" "+window.getAgence().getMessages().get(indice));
    }

    @FXML
    void Next(ActionEvent event) {
        System.out.println("moonaim");
        indice++;
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichCheckMessages();
    }
    @FXML
    void showEstate(ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowEst();

        System.out.println();;
    }

    @FXML
    void addEstate(ActionEvent event) {
        System.out.println(" hello ");
        //((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichAddEst();
    }

    @FXML
    void fltrEstate(ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window win = new window();
        win.affichFilterEst();
    }

    @FXML
    void showOwners(ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowOwn();
    }

    @FXML
    void chkMessages(ActionEvent event) {
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


}
