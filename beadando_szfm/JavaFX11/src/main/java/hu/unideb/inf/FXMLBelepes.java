package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FXMLBelepes {
    MainApp app = new MainApp();
    Users users = new Users();
    Bicicle bic = new Bicicle();
    ArrayList<Users> usersList = new ArrayList<>();
    boolean emailIsExists = false;//változó amivel ellenőrizhetjük az email létezését
    boolean pwIsExists = false;//változó amivel ellenőrizhetjük a jelszó létezését
    TextField textField = new TextField();


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

    public void setRegistration_error(Label registration_error) {
        this.registration_error = registration_error;
    }

    @FXML
    private Label registration_error;

    @FXML
    void handleBejelentkezekButtonPushed(ActionEvent event) {
        emailIsExists = false;
        pwIsExists = false;
        String login_user_name = login_username.getText();
        String jelszo = login_password.getText();

        /*------------Létezik-e ilyen felhasználó------------------*/
        for (Users user: usersList) {//végigmeghy a lista elemein
            if(app.checkEmailInUse(login_user_name, user.getEmail()))//megnézi hogy egyenlő-e a két string
                emailIsExists = true;
            if(app.checkEmailInUse(login_password.getText(), user.getPassword()))//megnézi hogy egyenlő-e a két string
                pwIsExists = true;
        }
        if(emailIsExists && pwIsExists) {//akkor fut le ha egyezik az email jelszo páros
            login_error.setTextFill(Color.color(0,1,0));
            login_error.setText("Sikeres belépés");
        }
        if(!pwIsExists){//akkor fut le ha a jelszó nem egyezik az eltárolttal
            login_error.setTextFill(Color.color(1,0,0));
            login_error.setText("Rossz jelszót adtál meg");
        }

        if(!emailIsExists){//akkor fut le ha nincs ilyen email
            login_error.setTextFill(Color.color(1,0,0));
            login_error.setText("Rossz e-mailt adtál meg");
        }

        /*--------------------------------------------------------- */

    }

    @FXML
    void handleRegisztrálokButtonPushed(ActionEvent event) {
        String pw1 = registration_password.getText();
        String pw2 = registration_password2.getText();
        emailIsExists = false;
        String register_user_name = registration_username.getText();
        for (Users user: usersList) {//végigmeghy a lista elemein
            if (app.checkEmailInUse(register_user_name, user.getEmail()))//megnézi hogy egyenlő-e a két string
                emailIsExists = true;
        }

        /*------------------------Regisztráció mentése---------------------------*/
        if (app.registerPw(pw1, pw2)//ellenőrzi hogy a két jelszó egyezik-e
                && !emailIsExists//ellenőrzi hogy létezik-e már az email( ezt a fentebb lévő for ciklusban vizsgáljuk)
                && users.checkPassword(pw1)//a jelszó erősségét ellenőrzi
                && users.emailValidator(registration_username.getText())) {//elenőrzi hogy megfelelő formátumu-e az email
            registration_error.setTextFill(Color.color(0,1,0));
            registration_error.setText("Sikeres regisztráció!");
            usersList.add(new Users(bic.random(),registration_username.getText(),registration_password.getText()));
        }
        if (!app.registerPw(pw1, pw2)) {//Ha a két jelszó nem egyezik akkor fut le
            registration_error.setTextFill(Color.color(1, 0, 0));
            registration_error.setText("Sikertelen regisztráció! A megadott jelszavak NEM egyeznek meg!");
        }
        if(!users.checkPassword(pw1)) {//akkor fut le ha nem elég erős a jelszó
            registration_error.setTextFill(Color.color(1,0,0));
            registration_error.setText("Sikertelen regisztráció! A megadott jelszó nem elég erős!");
        }
        if(emailIsExists) {//akkor fut le ha már használják az emailt
            registration_error.setTextFill(Color.color(1,0,0));
            registration_error.setText("Sikertelen regisztráció! A megadott E-mail már használatban van");
        }
        /*---------------------------------------------------------------------*/

        registrationErrorReset();
        registrationPwdReset();
        registrationPwd2Reset();
        registrationUsernameReset();
    }


        /*------ reseteli a regisztráció error üzenetet ha valamelyik textfieldbe kattintok ------*/
        public void registrationErrorReset(){
            registration_username.setOnMouseClicked(e ->{
                registration_error.setText(null);
            });
            registration_password.setOnMouseClicked(e ->{
                registration_error.setText(null);
            });
            registration_password2.setOnMouseClicked(e ->{
                registration_error.setText(null);
            });

        }
        public void registrationPwdReset(){//reseteli az reg pw-t üzenetet
            registration_password.setText(null);
        }
        public void registrationPwd2Reset(){//reseteli az reg pw ellenőrzőjét üzenetet
            registration_password2.setText(null);
        }
        public void registrationUsernameReset(){ //regisztráció után reseteli a usernamet
        registration_username.setText(null);
    }

}




