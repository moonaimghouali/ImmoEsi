package TP.Controlls;

import TP.Noyeau.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class addmaisonController {
    window w = new window();
    ObservableList<wilayas> wilayas = FXCollections.observableArrayList(TP.Noyeau.wilayas.ADRAR ,TP.Noyeau.wilayas.CHLEF, TP.Noyeau.wilayas.LAGHOUAT, TP.Noyeau.wilayas.OUMBOUAGHI, TP.Noyeau.wilayas.BATNA, TP.Noyeau.wilayas.BEJAIA, TP.Noyeau.wilayas.BISKRA,TP.Noyeau.wilayas.BECHAR, TP.Noyeau.wilayas.BLIDA, TP.Noyeau.wilayas.BOUIRA, TP.Noyeau.wilayas.TAMANRASSET, TP.Noyeau.wilayas.TEBESSA, TP.Noyeau.wilayas.TLEMCEN, TP.Noyeau.wilayas.TIARET, TP.Noyeau.wilayas.TIZIOUZOU, TP.Noyeau.wilayas.ALGER, TP.Noyeau.wilayas.DJELFA,TP.Noyeau.wilayas.JIJEL, TP.Noyeau.wilayas.SETIF, TP.Noyeau.wilayas.SAIDA, TP.Noyeau.wilayas.SKIKDA, TP.Noyeau.wilayas.SIDIBELABBES, TP.Noyeau.wilayas.ANNABA, TP.Noyeau.wilayas.GUELMA, TP.Noyeau.wilayas.CONSTANTINE, TP.Noyeau.wilayas.MEDEA, TP.Noyeau.wilayas.MOSTAGANEM, TP.Noyeau.wilayas.MSILA, TP.Noyeau.wilayas.MASCARA,TP.Noyeau.wilayas.OUARGLA, TP.Noyeau.wilayas.ORAN, TP.Noyeau.wilayas.ELBAYDH, TP.Noyeau.wilayas.ILLIZI,TP.Noyeau.wilayas.BORDJBOUARRERIDJ,TP.Noyeau.wilayas.BOUMERDES,TP.Noyeau.wilayas.ELTAREF,TP.Noyeau.wilayas.TINDOUF, TP.Noyeau.wilayas.TISSEMSILT, TP.Noyeau.wilayas.ELOUED, TP.Noyeau.wilayas.KHENCHLA, TP.Noyeau.wilayas.SOUKAHRASS, TP.Noyeau.wilayas.TIPAZA, TP.Noyeau.wilayas.MILA, TP.Noyeau.wilayas.AINDEFLA,TP.Noyeau.wilayas.NAAMA, TP.Noyeau.wilayas.AINTEMOUCHENT, TP.Noyeau.wilayas.GHARDAIA, TP.Noyeau.wilayas.RELIZANE);
    ObservableList<Transaction> transactions = FXCollections.observableArrayList(Transaction.vente,Transaction.location,Transaction.echange);
   // ObservableList<Proprietaire> props = FXCollections.observableArrayList(w.getAgence().getProprietaires());


    @FXML
    private Pane root;

    @FXML
    private TextField adress;

    @FXML
    private TextField name;

    @FXML
    private TextField firstname;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML private TextField ownadress ;

    @FXML
    private TextField area;

    @FXML
    private TextField areahabitable;

    @FXML
    private TextField floors;

    @FXML
    private TextField bedrooms;

    @FXML
    private ChoiceBox<Transaction> transaction;

    @FXML
    private ChoiceBox<wilayas> province;

    @FXML
    private TextField description;

    @FXML
    private CheckBox garden;

    @FXML
    private CheckBox pool;

    @FXML
    private CheckBox garage;

    @FXML
    private CheckBox furnished;

    @FXML
    private CheckBox negotiable;

    @FXML
    private TextField price;

    @FXML
    private Button addOwnerBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private Label warningLab;

    @FXML
    private ChoiceBox<String> owners;

    @FXML
    private CheckBox ownerexist;

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
    }


    public void submit(ActionEvent event) {
        Maison m = null;
        if (adress.getText().equals("") && area.getText().equals("") && areahabitable.getText().equals("") && floors.getText().equals("") && bedrooms.getText().equals("") && price.getText().equals("")) {
            warningLab.setText(" you have to fill the textfields");

        } else {
            Proprietaire p = null;
            LocalDate d = LocalDate.of(2018, 12, 12);
            if (ownerexist.isSelected()) {
                for (Proprietaire prop : w.getAgence().getProprietaires()) {
                    if ((prop.getNom() + " " + prop.getPrenom()).equals(owners.getValue().toString())) {
                        p = prop;
                    }
                }

            } else {
                p = new Proprietaire(name.getText(), firstname.getText(), email.getText(), phone.getText(), ownadress.getText());
            }
            wilaya wil = new wilaya(60000, province.getValue());
            m = null;
            try {
                m = new Maison(Integer.parseInt(floors.getText().trim()), garage.isSelected(), garden.isSelected(), pool.isSelected(), Integer.parseInt(areahabitable.getText().trim()), furnished.isSelected(), Integer.parseInt(bedrooms.getText().trim()), adress.getText(), Ebiens.Maison, wil, Integer.parseInt(area.getText().trim()), transaction.getValue(), negotiable.isSelected(), description.getText(), d, "photo", true, Integer.parseInt(price.getText().trim()), p);
            } catch (LogicalException e) {
                //  warningLab.setText("Wrong input : please check the textfields input.");
                if (Integer.parseInt(area.getText().trim()) <Integer.parseInt(areahabitable.getText().trim())) {
                    warningLab.setText("check the area of the estate.");
                } else {
                    if (Integer.parseInt(floors.getText().trim()) < 1) {
                        warningLab.setText("check floors textfield.");
                    } else {
                        if (Integer.parseInt(bedrooms.getText().trim()) < 1) {
                            warningLab.setText("check bedrooms textfield.");
                        } else {
                            if (Integer.parseInt(price.getText().trim()) < 0) {
                                warningLab.setText("check price textfield.");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        window win = new window();
        win.getAgence().ajouter_Bien(m);
        ((Stage) (submitBtn.getScene().getWindow())).close();
        win.affichShowEst();
    }

    }


