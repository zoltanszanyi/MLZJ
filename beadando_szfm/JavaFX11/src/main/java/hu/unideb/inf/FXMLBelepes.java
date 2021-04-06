package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLBelepes {

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
        String login_user_name = login_username.getText();
        String jelszo = login_password.getText();
        System.out.println(login_user_name);
        System.out.println();

    }

    @FXML
    void handleRegisztrálokButtonPushed(ActionEvent event) {
        String registration_user_name = registration_username.getText();
        System.out.println(registration_user_name);
    }
}