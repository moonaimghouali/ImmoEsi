package TP.Controlls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class adminLoginController {
    @FXML
    private Pane root;
    @FXML
    private TextField passTF;
    @FXML
    private TextField user;
    @FXML
    private Button loginBtn;
    @FXML
    private Label erreur;
    @FXML
    private Button userLoginBtn;
    @FXML
    void login(ActionEvent event) throws IOException {

        if (event.getSource().equals(loginBtn)){
            if ((user.getText().equals("m"))&&(passTF.getText().equals("m"))) {
                /////////////////////////////////////////////////////////////////////////////
                // here go to administration menu view i.e load the administrationMenu.fxml
                /////////////////////////////////////////////////////////////////////////////

                ((Stage) (loginBtn.getScene().getWindow())).close();
                window w = new window();
                w.affichAdministration();
            }else {
                if ((user.getText().equals(""))||(passTF.getText().equals(""))){
                    erreur.setText(" you must fill the text fields");
                }else {
                    if (!user.getText().equals("m")){
                        erreur.setText(" worng username.");
                    }else if (!passTF.getText().equals("m")){
                        erreur.setText(" wrong password.");
                    }
                }
                window w = new window();
            }
        }else {
            /////////////////////////////////////////////////////////////////////////////
            // go to the user menu view i.e load the userMenu.fxml
            /////////////////////////////////////////////////////////////////////////////
            ((Stage) (loginBtn.getScene().getWindow())).close();
            window w = new window();
            w.affichUserMenu();
        }
    }
}