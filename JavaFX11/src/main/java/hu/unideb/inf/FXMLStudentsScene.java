package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class FXMLStudentsScene {
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    private Label nameLabel;

    @FXML
    private Label creditsLabel;

    @FXML
    private Label dateOfBirthLabel;

    @FXML
    private Label helloLabel;

    @FXML
    void handleButtonPushed(ActionEvent event) {
        System.out.println("Kapd be");
        helloLabel.setText("Button Pushed...");
    }

    @FXML
    void handleLoadButtonPushed(ActionEvent event) {
        nameLabel.textProperty().bind(model.getStudent().nameProperty());
        creditsLabel.setText("" + model.getStudent().getCredits());
        dateOfBirthLabel.setText(model.getStudent().getDateOfBirth().toString());
    }

    @FXML
    void handleChangeButtonPushed(ActionEvent event) {
        model.getStudent().setName("Tom Smith");

    }
}
