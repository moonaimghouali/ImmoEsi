package TP.Controlls;

import TP.Noyeau.Appartement;
import TP.Noyeau.Bien;
import TP.Noyeau.Maison;
import TP.Noyeau.Terrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class showEstController {

    private static int indice = 0;
    private static int indicefilter = 0;
    private static ArrayList<Bien> biensAfficher = new ArrayList<Bien>();

    @FXML
    private Button arcEstBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private Button delEstBtn;

    @FXML
    private Button mdfEstBtn;

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
    private Label adress;

    @FXML
    private Label superficie;

    @FXML
    private Label typebien;

    @FXML
    private Label transaction;

    @FXML
    private Label prop;

    @FXML
    private Label prix;

    @FXML
    private Label descripRepo;

    @FXML
    private Label labSpec1;

    @FXML
    private Label labSpec2;

    @FXML
    private Label labSpec3;

    @FXML
    private Label labspec4;

    @FXML
    private Label labSpec5;

    public ArrayList<Bien> getBiensAfficher() {
        return biensAfficher;
    }
    public void setBiensAfficher(ArrayList<Bien> biensAfficher) {
        this.biensAfficher = biensAfficher;
    }

    public showEstController(){
        //indice = 0;
    }
    @FXML
    public void initialize(){
        indice %= window.getAgence().getBiens().size();
        Bien b = window.getAgence().getBiens().get(indice);
        if (b.isVisibilite()){
            adress.setText(adress.getText()+" "+b.getAdresse());
            superficie.setText(superficie.getText()+" "+b.getSuperficie()+" m*m");
            typebien.setText(typebien.getText()+" "+b.getType_bien());
            transaction.setText(transaction.getText()+" "+b.getTransaction());
            prop.setText(prop.getText()+" "+b.getProprietaire().getNom()+" "+b.getProprietaire().getPrenom());
            prix.setText(prix.getText()+" "+b.getPrixAgence());
            descripRepo.setText(descripRepo.getText()+" "+b.getDescriptif());
            if (b instanceof Maison){
                labSpec1.setText("Bedrooms : "+((Maison) b).getNbr_pieces());
                labSpec2.setText("Living Area : "+((Maison) b).getSuperficieHabitable());
                labSpec3.setText("Floors : "+((Maison) b).getEtages());
                if (((Maison) b).isDispoGarage()||((Maison) b).isDispoJardin()||((Maison) b).isDispoPiscine()){
                    labspec4.setText("Specifications : ");
                    if (((Maison) b).isDispoGarage())labspec4.setText(labspec4.getText()+"Garage");
                    if (((Maison) b).isDispoJardin())labspec4.setText(labspec4.getText()+" Garden");
                    if (((Maison) b).isDispoPiscine())labspec4.setText(labspec4.getText()+" Pool");
                }
                if (((Maison) b).isMeuble())labSpec5.setText(" Furnished");

            }
            if (b instanceof Appartement){
                labSpec1.setText("Bedrooms : "+((Appartement) b).getNbr_pieces());
                labSpec2.setText("Floors : "+((Appartement) b).getNbrEtages());
                labSpec3.setText("Flat type : "+((Appartement) b).getNatureApp());
                if (((Appartement) b).isDispoAssenceur())
                    labspec4.setText("Elevator : Available");
                else
                    labspec4.setText("Elevator : Not available");

            }
            if (b instanceof Terrain){
                labSpec1.setText("Facades : "+((Terrain) b).getNbrFacades());
                labSpec2.setText("Legal Status : "+((Terrain) b).getStatutJuridique());

            }
        }
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


    public void Next(ActionEvent event) {
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        indice++;
        window w = new window();
        w.affichShowEst();

    }

    public void modify(ActionEvent event) {
        ((Stage) (showEstBtn.getScene().getWindow())).close();
    }

    public void delete(ActionEvent event) {
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.getAgence().suprimerBien(w.getAgence().getBiens().get(indice));
        //w.getAgence().affichProps();
        w.affichShowEst();
    }

    public void archive(ActionEvent event) {
        ((Stage) (showEstBtn.getScene().getWindow())).close();
        window w = new window();
        w.getAgence().archiver(w.getAgence().getBiens().get(indice));
        w.affichShowEst();
    }
}
