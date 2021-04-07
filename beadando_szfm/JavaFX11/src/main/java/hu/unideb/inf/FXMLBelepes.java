package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        ArrayList<Users> usersList = new ArrayList<>();
        boolean emailIsExists = false;
        boolean pwIsExists = false;
        MainApp app = new MainApp();
        Users users = null;
        Bicicle bic = null;
        String login_user_name = login_username.getText();
        String jelszo = login_password.getText();
        System.out.println(login_user_name);
        System.out.println(jelszo);


        /*              Létezik-e ilyen felhasználó                      */
        for (Users user: usersList) {//végigmeghy a lista elemein
            if(app.checkEmailInUse(login_user_name, user.getEmail()))//megnézi hogy egyenlő-e a két string
                emailIsExists = true;
            if(app.checkEmailInUse(login_password.getText(), user.getPassword()))//megnézi hogy egyenlő-e a két string
                pwIsExists = true;
        }
        if(emailIsExists && pwIsExists) {
            System.out.println("Sikeres belépés");
            login_error.setText("Sikeres belépés");
        }else if(emailIsExists && !pwIsExists){
            System.out.println("Rossz jelszót adtál meg");
            login_error.setText("Rossz jelszót adtál meg");
        }else
            System.out.println("Nincs ilyen felhasználó-jelszó páros");
            login_error.setText("Nincs ilyen felhasználó-jelszó páros");
        /*--------------------------------------------------------- */

        /*              Acc hozzáadása
        if(users.checkPassword(registration_password.getText()) && !emailIsExists && !pwIsExists)
            usersList.add(new Users(bic.random()))
        /*--------------------------------------------------------- */


    }

    @FXML
    void handleRegisztrálokButtonPushed(ActionEvent event) {
        String registration_user_name = registration_username.getText();
        System.out.println(registration_user_name);
    }

    public TextField getLogin_username() {
        return login_username;
    }
}