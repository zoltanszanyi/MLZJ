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
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class User_interface implements Initializable {
    public Location loc = new Location();
    public Bicicle bic = new Bicicle();
    String min;
    String hour;

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
    private Label ReserveSuccessLabel;

    @FXML
    private ComboBox SelectMin;

    @FXML
    void HandleReserveButton(ActionEvent event) {
        ReserveSuccessLabel.setTextFill(Color.color(0.1,0.1,0.1));
        ReserveSuccessLabel.setText("A lefoglalás sikeresen megtörtént");
    }

    @FXML
    void HandleSelectBicycle(ActionEvent event) {
    }

    @FXML
    void HandleSelectHours(ActionEvent event) {
        hour = SelectHours.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    void HandleSelectLocation(ActionEvent event) {
        String s = SelectLocation.getSelectionModel().getSelectedItem().toString();
        ActualLocation.setText(s);
        List<Location> locName = new ArrayList<>();
        try (LocationDAO lDAO = new JpaLocationDAO();) {  //try-with-resources   Adatbáziskezelő példányosítása a felhesználókhoz
            locName = lDAO.getLocations(); //felhasználó elmentése adatbázisba
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Location num: locName) {
            if(num.getName().equals(ActualLocation.getText()))
            {
                LocationInfo.setText(num.getAddress());
                Fullness.setText(String.valueOf(num.getFullness()) + "%" + "\n" + num.getNowin() +"/"+ num.getMax());
            }
            Price.setText("Első fél óra ingyenes!\nHagyományos: 400ft/0,5 óra\nElektromos: 600ft/0,5 óra");
        }
    }

    @FXML
    void HandleSelectMin(ActionEvent event) {
        min = SelectMin.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    void HandleOkButtonPushed(ActionEvent event) {
        PrintReserveTime.setText("Idő kiválasztva");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*----------------------------Location combobox---------------------------------*/
        ObservableList<String> comboLoc = FXCollections.observableArrayList();
        List<Location> locName = new ArrayList<>();
        try (LocationDAO lDAO = new JpaLocationDAO();) {  //try-with-resources   Adatbáziskezelő példányosítása a felhesználókhoz
            locName = lDAO.getLocations(); //felhasználó elmentése adatbázisba
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Location num : locName) {
            comboLoc.add(num.getName());
        }
        SelectLocation.setItems(comboLoc);


        /*-------------------------------------------------------------------------------*/


        /*----------------------------Minutes combobox---------------------------------*/
        ObservableList<String> comboMin = FXCollections.observableArrayList();
        ArrayList<String> minutes = new ArrayList<>();
        for(int i = 0; i <= 59; i++)
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
        for(int i = 0; i <= 23; i++)
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