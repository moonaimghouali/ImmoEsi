package TP.Controlls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class addEstController {

    @FXML
    private Pane root;

    @FXML
    private Button houseBtn;

    @FXML
    private Button flatBtn;

    @FXML
    private Button fieldBtn;

    @FXML
    void addfield(ActionEvent event) {
        ((Stage) (flatBtn.getScene().getWindow())).close();
        System.out.println("terrain");
        window w = new window();
        w.affichAddterrain();
    }

    @FXML
    void addflat(ActionEvent event) {
        ((Stage) (flatBtn.getScene().getWindow())).close();
        System.out.println("app");
        window w = new window();
        w.affichAddAppartement();
    }

    @FXML
    void addhouse(ActionEvent event) {
        ((Stage) (flatBtn.getScene().getWindow())).close();
        System.out.println("maison");
        window w = new window();
        w.affichAddMaison();
    }

}
