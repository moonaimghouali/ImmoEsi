package TP.Controlls;

import TP.Noyeau.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class addterrainController {
    window w = new window();

    ObservableList<TP.Noyeau.wilayas> wilayas = FXCollections.observableArrayList(TP.Noyeau.wilayas.ADRAR ,TP.Noyeau.wilayas.CHLEF, TP.Noyeau.wilayas.LAGHOUAT, TP.Noyeau.wilayas.OUMBOUAGHI, TP.Noyeau.wilayas.BATNA, TP.Noyeau.wilayas.BEJAIA, TP.Noyeau.wilayas.BISKRA,TP.Noyeau.wilayas.BECHAR, TP.Noyeau.wilayas.BLIDA, TP.Noyeau.wilayas.BOUIRA, TP.Noyeau.wilayas.TAMANRASSET, TP.Noyeau.wilayas.TEBESSA, TP.Noyeau.wilayas.TLEMCEN, TP.Noyeau.wilayas.TIARET, TP.Noyeau.wilayas.TIZIOUZOU, TP.Noyeau.wilayas.ALGER, TP.Noyeau.wilayas.DJELFA,TP.Noyeau.wilayas.JIJEL, TP.Noyeau.wilayas.SETIF, TP.Noyeau.wilayas.SAIDA, TP.Noyeau.wilayas.SKIKDA, TP.Noyeau.wilayas.SIDIBELABBES, TP.Noyeau.wilayas.ANNABA, TP.Noyeau.wilayas.GUELMA, TP.Noyeau.wilayas.CONSTANTINE, TP.Noyeau.wilayas.MEDEA, TP.Noyeau.wilayas.MOSTAGANEM, TP.Noyeau.wilayas.MSILA, TP.Noyeau.wilayas.MASCARA,TP.Noyeau.wilayas.OUARGLA, TP.Noyeau.wilayas.ORAN, TP.Noyeau.wilayas.ELBAYDH, TP.Noyeau.wilayas.ILLIZI,TP.Noyeau.wilayas.BORDJBOUARRERIDJ,TP.Noyeau.wilayas.BOUMERDES,TP.Noyeau.wilayas.ELTAREF,TP.Noyeau.wilayas.TINDOUF, TP.Noyeau.wilayas.TISSEMSILT, TP.Noyeau.wilayas.ELOUED, TP.Noyeau.wilayas.KHENCHLA, TP.Noyeau.wilayas.SOUKAHRASS, TP.Noyeau.wilayas.TIPAZA, TP.Noyeau.wilayas.MILA, TP.Noyeau.wilayas.AINDEFLA,TP.Noyeau.wilayas.NAAMA, TP.Noyeau.wilayas.AINTEMOUCHENT, TP.Noyeau.wilayas.GHARDAIA, TP.Noyeau.wilayas.RELIZANE);
    ObservableList<Transaction> transactions = FXCollections.observableArrayList(Transaction.vente,Transaction.location,Transaction.echange);
    //ObservableList<TP.Noyeau.Proprietaire> props = FXCollections.observableArrayList(w.getAgence().getProprietaires());

    @FXML
    private Pane root;

    @FXML
    private TextField adress;

    @FXML
    private TextField area;

    @FXML
    private ChoiceBox<Transaction> transaction;

    @FXML
    private ChoiceBox<TP.Noyeau.wilayas> province;

    @FXML
    private TextField description;

    @FXML
    private TextField price;

    @FXML
    private CheckBox negotiable;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField name;

    @FXML
    private TextField firstname;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private TextField ownadress;

    @FXML
    private Label warningLab;

    @FXML
    private CheckBox ownerexist;

    @FXML
    private ChoiceBox<String> owners;

    @FXML
    private TextField legalstatus;

    @FXML
    private TextField facades;

    @FXML
    public void initialize(){
        province.setItems(wilayas);
        province.setValue(TP.Noyeau.wilayas.ALGER);
        transaction.setItems(transactions);
        transaction.setValue(Transaction.vente);
        ArrayList<String> a = new ArrayList<String>();
        for (Proprietaire p : w.getAgence().getProprietaires()){
            a.add(p.getNom()+" "+p.getPrenom());
        }
        ObservableList<String>propsnames = FXCollections.observableArrayList(a);
        owners.setItems(propsnames);
      //  owners.setItems(props);
    }

    @FXML
    void submit(ActionEvent event) {
        if (adress.getText().equals("") || area.getText().equals("") || price.getText().equals("") ) {
            warningLab.setText(" you have to fill the textfields");
        } else {
            Proprietaire p =null;
            LocalDate d = LocalDate.of(2018, 12, 12);
            if (ownerexist.isSelected()){
                for (Proprietaire prop :  w.getAgence().getProprietaires()){
                    if ((prop.getNom()+" "+prop.getPrenom()).equals(owners.getValue().toString()) ){
                        p = prop;
                    }
                }
            }
            if ((!ownerexist.isSelected())&&(name.getText().equals(""))&&(firstname.getText().equals(""))){
                try {
                    throw new LogicalException();
                }catch (LogicalException e){
                    warningLab.setText("adllfljafs");
                }
            }
            p = new Proprietaire(name.getText(), firstname.getText(), email.getText(), phone.getText(), ownadress.getText());
            wilaya wil = new wilaya(60000, province.getValue());
            Terrain m = null;
            try {
                m = new Terrain(legalstatus.getText(),Integer.parseInt(facades.getText().trim()),adress.getText(),Ebiens.Terrain,wil,Integer.parseInt(area.getText().trim()),transaction.getValue(),negotiable.isSelected(),description.getText(),d,"photo",true,Integer.parseInt(price.getText().trim()),p);
            } catch (LogicalException e){
                if (Integer.parseInt(area.getText().trim())<1) {
                    warningLab.setText("check the area of the estate.");
                } else {
                    if (Integer.parseInt(facades.getText().trim())< 1) {
                        warningLab.setText("check facades textfield.");
                    } else {
                            if (Integer.parseInt(price.getText().trim()) < 0) {
                                warningLab.setText("check price textfield.");
                            }
                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            window win = new window();
            win.getAgence().ajouter_Bien(m);
            ((Stage) (submitBtn.getScene().getWindow())).close();
            win.affichShowEst();

        }
    }

}
