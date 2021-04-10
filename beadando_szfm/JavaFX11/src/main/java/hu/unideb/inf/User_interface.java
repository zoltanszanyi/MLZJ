package hu.unideb.inf;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class User_interface implements Initializable {
    public Location loc = new Location();
    public Bicicle bic = new Bicicle();

    @FXML
    private ComboBox SelectLocation;

    @FXML
    private Label ActualLocation;

    @FXML
    private Label LocationInfo;

    @FXML
    private Label Fullness;

    @FXML
    private Label Price;

    @FXML
    private ComboBox<?> SelectBicycle;

    @FXML
    private ComboBox SelectHours;

    @FXML
    private Label PrintReserveTime;

    @FXML
    private Label Reserve;

    @FXML
    private ComboBox SelectMin;

    @FXML
    void HandleReserveButton(MouseEvent event) {
        Reserve.setText("mŰködik");
    }

    @FXML
    void HandleSelectBicycle(ActionEvent event) {

    }

    @FXML
    void HandleSelectHours(ActionEvent event) {

    }

    @FXML
    void HandleSelectLocation(ActionEvent event) {
        String s = SelectLocation.getSelectionModel().getSelectedItem().toString();
        ActualLocation.setText(s);
    }

    @FXML
    void HandleSelectMin(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*----------------------------Location combobox---------------------------------*/
        loc.locationsClass.add(new Location(bic.random(), 10,5,"Debrecen, anyád fasza utca","Debreceni Unibike"));
        loc.locationsClass.add(new Location(bic.random(), 10,5,"Debrecen, anyád fasza utca","Nyíregyházi Unibike"));
        loc.locationsClass.add(new Location(bic.random(), 10,5,"Debrecen, anyád fasza utca","Leveleki Unibike"));
        loc.locationsClass.add(new Location(bic.random(), 10,5,"Debrecen, anyád fasza utca","Nagydobronyi Unibike"));
        ObservableList<String> comboLoc = FXCollections.observableArrayList();
        ArrayList<String> locName = new ArrayList<>();
        for (Location num: loc.locationsClass)
        {
            locName.add(num.getName());
        }
        for (String num : locName) {
            comboLoc.add(num);
        }
        SelectLocation.setItems(comboLoc);
        /*-------------------------------------------------------------------------------*/


        /*----------------------------Minutes combobox---------------------------------*/
        ObservableList<String> comboMin = FXCollections.observableArrayList();
        ArrayList<String> minutes = new ArrayList<>();
        for(int i = 0; i < 60; i++)
        {
            String h = Integer.toString(i);
            if(h.length() == 1)
                h = "0" + h;
            minutes.add(h);
        }
        for (String num : minutes) {
            comboMin.add(num);
        }
        SelectMin.setItems(comboMin);
        /*-------------------------------------------------------------------------------*/

        /*----------------------------Hourses combobox---------------------------------*/
        ObservableList<String> comboHou = FXCollections.observableArrayList();
        ArrayList<String> hourses = new ArrayList<>();
        for(int i = 0; i < 24; i++)
        {
            String s = Integer.toString(i);
            if(s.length() == 1)
                s = "0" + s;
            hourses.add(s);
        }
        for (String num : hourses) {
            comboHou.add(num);
        }
        SelectHours.setItems(comboHou);
        /*-------------------------------------------------------------------------------*/
    }
}