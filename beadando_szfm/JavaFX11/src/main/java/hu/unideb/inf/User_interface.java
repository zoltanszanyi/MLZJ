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
import java.util.ResourceBundle;

public class User_interface implements Initializable {

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
    private ComboBox<?> SelectHours;

    @FXML
    private Label PrintReserveTime;

    @FXML
    private Label Reserve;

    @FXML
    private ComboBox<?> SelectMin;

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
    }

    @FXML
    void HandleSelectMin(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> combo = FXCollections.observableArrayList("Debrecen", "Nyíregyháza", "Levelek", "Nagydobrony");
        Location loc = new Location();
        /*for (Location num : loc.locationsClass) {
            combo.add(num.getName());
        }*/
        SelectLocation.setItems(combo);
    }
}