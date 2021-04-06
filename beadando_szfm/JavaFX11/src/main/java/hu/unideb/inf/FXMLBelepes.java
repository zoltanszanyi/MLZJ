package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLBelepes {

    public TextField getLogin_username() {
        return login_username;
    }

    public TextField getRegistration_username() {
        return registration_username;
    }

    public PasswordField getLogin_password() {
        return login_password;
    }

    public PasswordField getRegistration_password() {
        return registration_password;
    }

    public PasswordField getRegistration_password2() {
        return registration_password2;
    }

    public Label getLogin_error() {
        return login_error;
    }

    public Label getRegistration_error() {
        return registration_error;
    }

    @FXML
    private TextField login_username;

    @FXML
    private TextField registration_username;

    @FXML
    private PasswordField login_password;

    @FXML
    private PasswordField registration_password;

    @FXML
    private PasswordField registration_password2;

    @FXML
    private Label login_error;

    @FXML
    private Label registration_error;

    @FXML
    void handleBejelentkezekButtonPushed(ActionEvent event) {
        System.out.println(getLogin_password());
    }

    @FXML
    void handleRegisztrálokButtonPushed(ActionEvent event) {
        System.out.println(getRegistration_username().toString());
    }
}