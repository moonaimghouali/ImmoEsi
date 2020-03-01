package TP.Controlls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UserController {
    @FXML
    private Button showEstBtn;

    @FXML
    private Button sendMsgBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Label est;

    @FXML
    public void initialize(){
        window w = new window();
        this.est.setText(this.est.getText()+" "+w.getAgence().getBiens().size());

    }

    @FXML
    void showEstate(ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichShowEstUser();
    }

    @FXML
    public void sendmessage(){
        System.out.println("hjashd ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichSendMessage();
       // w.affichSendMessage();

    }

    @FXML
    void logOut(ActionEvent event) {
       // System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.affichCheckMessages();
    }

}
