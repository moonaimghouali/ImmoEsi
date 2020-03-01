package TP.Controlls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class sendMessage {


    @FXML
    private Button validateBtn;


    @FXML
    private Button showEstBtn;


    @FXML
    private Button logOutBtn;

    @FXML
    private TextField messageTF;

    @FXML
    void showEstate(javafx.event.ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowEstUser();
        //w.affichShowEst();
    }

    @FXML
    void logOut(ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichLoginMenu(w.getAgence());
    }

    public void valider(){

        window w = new window();
        w.getAgence().getMessages().add(messageTF.getText());
        //System.out.println(messageTF.getText());
        w.affichUserMenu();
        ((Stage)logOutBtn.getScene().getWindow()).close();
    }

}
