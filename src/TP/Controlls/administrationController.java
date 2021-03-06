package TP.Controlls;
import TP.Noyeau.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class administrationController extends Parent {
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
    private Label est;

    @FXML
    private Label mesg;

    @FXML
    private Label own;

    @FXML
    public void initialize(){
        window w = new window();
        this.est.setText(this.est.getText()+" "+w.getAgence().getBiens().size());
        this.mesg.setText(this.mesg.getText()+" "+w.getAgence().getMessages().size());
        this.own.setText(this.own.getText()+" "+w.getAgence().getProprietaires().size());
    }

    @FXML
    void showEstate(ActionEvent event) {
        System.out.println(" hello ");
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.getAgence().trier();
        w.affichShowEst();


        System.out.println();;
    }

    @FXML
    void addEstate(ActionEvent event) {
        System.out.println("hello ");
        //
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
