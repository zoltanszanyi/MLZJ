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


public class User_interface{
    public Location loc = new Location();
    public Bicicle bic = new Bicicle();
    String min;
    String hour;
    int actual = 2;

    @FXML
    private ComboBox SelectFrom;

    @FXML
    private ComboBox SelectHours1;

    @FXML
    private ComboBox SelectWhere;

    @FXML
    private ComboBox SelectMin1;

    @FXML
    private ComboBox SelectMin2;

    @FXML
    private ComboBox SelectHours2;

    @FXML
    void HandleSelectFrom(ActionEvent event) {

    }

    @FXML
    void HandleSelectHours1(ActionEvent event) {

    }

    @FXML
    void HandleSelectHours2(ActionEvent event) {

    }

    @FXML
    void HandleSelectMin1(ActionEvent event) {

    }

    @FXML
    void HandleSelectMin2(ActionEvent event) {

    }

    @FXML
    void HandleSelectWhere(ActionEvent event) {

    }

    @FXML
    private ComboBox SelectLocation;

    @FXML
    private Label ActualLocation;

    @FXML
    private Label VehicleInfo;

    @FXML
    private Label LocationInfo;

    @FXML
    private Label Fullness;

    @FXML
    private Label Price;

    @FXML
    private ComboBox SelectBicycle;

    @FXML
    private ComboBox SelectHours;

    @FXML
    private Label PrintPrice;


    @FXML
    private Label ReserveSuccessLabel;

    @FXML
    private ComboBox SelectMin;

    @FXML
    void HandleReserveButton(ActionEvent event) {
        List<Bicicle> bicicles = new ArrayList<>();
        List<Location> locations = new ArrayList<>();
        ReserveSuccessLabel.setTextFill(Color.color(0.1,0.1,0.1));
        ReserveSuccessLabel.setText("A lefoglalás sikeresen megtörtént");
        int ora1 = Integer.parseInt((String) SelectHours1.getSelectionModel().getSelectedItem()) * 60,
                ora2 = Integer.parseInt((String) SelectHours2.getSelectionModel().getSelectedItem()) * 60,
                perc1 = Integer.parseInt((String) SelectMin1.getSelectionModel().getSelectedItem()),
                perc2 = Integer.parseInt((String) SelectMin2.getSelectionModel().getSelectedItem()),
                kül = (ora1 + perc1) - (ora2 + perc2);
                if(kül < 0)
                    kül = (kül *(-1) - 30)/30;
                if(Integer.parseInt((String) SelectBicycle.getSelectionModel().getSelectedItem()) >= 26)
                    PrintPrice.setText(String.valueOf(kül * 600) + "Ft");
                else
                    PrintPrice.setText(String.valueOf(kül * 400) + "Ft");
        try (BicicleDAO bDAO = new JpaBicicleDAO(); LocationDAO lDAO = new JpaLocationDAO();) {
            bicicles= bDAO.getBicicles();
            locations= lDAO.getLocations();

        for (Bicicle num : bicicles) {
            if (num.getBicicleID() == Integer.parseInt(SelectBicycle.getSelectionModel().getSelectedItem().toString())) {
                for (Location a: locations) {
                    if(a.getLocID() == num.getLocID()) {
                        a.setNowin(a.getNowin() - 1);
                        a.setFullness();
                        lDAO.updateLocation(a);
                    }
                    if(a.getName().equals(SelectWhere.getSelectionModel().getSelectedItem().toString())) {
                        a.setNowin(a.getNowin() + 1);
                        a.setFullness();
                        num.setLocID(a.getLocID());
                        bDAO.updateBicicle(num);
                        lDAO.updateLocation(a);
                    }
                }
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void HandleSelectBicycle(ActionEvent event) {
        String s, tipus = null, foglaltság = null, toltottseg = null;
        List<Bicicle> bicicles = new ArrayList<>();
        try (BicicleDAO bDAO = new JpaBicicleDAO();) {
            bicicles= bDAO.getBicicles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Bicicle num : bicicles) {
            if(num.getBicicleID() == Integer.parseInt(SelectBicycle.getSelectionModel().getSelectedItem().toString()))
            {
                if (num.getAvailable() == 0)
                    foglaltság = "foglalt";
                else
                    foglaltság = "szabad";
                if(num.isType()) {
                    tipus = "elektromos";
                    toltottseg = String.valueOf(num.getCharge());
                }else {
                    tipus = "hagyomásnyos";
                    toltottseg = "-";
                }
            }
            VehicleInfo.setText("Tipusa: " + tipus + "\n" +
                                "Elérhetőség: " + foglaltság + "\n" +
                                "Töltöttsége: " + toltottseg + "\n"
                                    );
        }
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
                actual = num.getLocID();
                initializeBic();
            }
            Price.setText("Első fél óra ingyenes!\nHagyományos: 400ft/0,5 óra\nElektromos: 600ft/0,5 óra");
        }
    }

    @FXML
    void HandleSelectMin(ActionEvent event) {
        min = SelectMin.getSelectionModel().getSelectedItem().toString();
    }


    public void initializeBic()
    {
        /*----------------------------Bicycle combobox---------------------------------*/
        ObservableList<String> comboBic = FXCollections.observableArrayList();
        List<Bicicle> bicName = new ArrayList<>();
        try (BicicleDAO bDAO = new JpaBicicleDAO();) {  //try-with-resources   Adatbáziskezelő példányosítása a felhesználókhoz
            bicName = bDAO.getBicicles(); //felhasználó elmentése adatbázisba
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Bicicle num : bicName) {
            if(num.getLocID() == actual)
                comboBic.add(String.valueOf(num.getBicicleID()));
        }
        SelectBicycle.setItems(comboBic);
        /*-------------------------------------------------------------------------------*/

    }

    public void initialize() {
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
        SelectFrom.setItems(comboLoc);
        SelectWhere.setItems(comboLoc);
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
        SelectMin1.setItems(comboMin);
        SelectMin2.setItems(comboMin);
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
        SelectHours1.setItems(comboHou);
        SelectHours2.setItems(comboHou);
        /*-------------------------------------------------------------------------------*/
    }
}