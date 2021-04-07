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
    Bicicle bic = null;
    ArrayList<Users> usersList = new ArrayList<>();
    boolean emailIsExists = false;
    boolean pwIsExists = false;


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

        /*              Létezik-e ilyen felhasználó                      */
        for (Users user: usersList) {//végigmeghy a lista elemein
            if(app.checkEmailInUse(login_user_name, user.getEmail()))//megnézi hogy egyenlő-e a két string
                emailIsExists = true;
            if(app.checkEmailInUse(login_password.getText(), user.getPassword()))//megnézi hogy egyenlő-e a két string
                pwIsExists = true;
        }
        if(emailIsExists && pwIsExists) {
            login_error.setTextFill(Color.color(0,1,0));
            login_error.setText("Sikeres belépés");
        }else if(emailIsExists && !pwIsExists){
            login_error.setTextFill(Color.color(1,0,0));
            login_error.setText("Rossz jelszót adtál meg");
        }else
            login_error.setTextFill(Color.color(1,0,0));
            login_error.setText("Nincs ilyen felhasználó-jelszó páros");

        /*--------------------------------------------------------- */

    }

    @FXML
    void handleRegisztrálokButtonPushed(ActionEvent event) {
        String pw1 = registration_password.getText();
        String pw2 = registration_password2.getText();
        Users users = new Users();
        Bicicle bic = null;
        if (app.registerPw(pw1, pw2) && !emailIsExists && users.checkPassword(pw1)){
            registration_error.setTextFill(Color.color(0,1,0));
            registration_error.setText("Sikeres regisztráció!");}
        else if(!app.registerPw(pw1, pw2)) {
            registration_error.setTextFill(Color.color(1,0,0));
            registration_error.setText("Sikertelen regisztráció! A megadott jelszavak NEM egyeznek meg!");
        }
        else if(!users.checkPassword(pw1)) {
            registration_error.setTextFill(Color.color(1,0,0));
            registration_error.setText("Sikertelen regisztráció! A megadott jelszó nem elég erős!");
        }
        else if(!emailIsExists) {
            registration_error.setTextFill(Color.color(1,0,0));
            registration_error.setText("Sikertelen regisztráció! A megadott E-mail már használatban van");
        }
        registrationPwdReset();
        registrationPwd2Reset();

    }

    public void pause(int s){
        int i = 0;
        LocalTime startTime = LocalTime.now();
        LocalTime deltaTime = startTime.plusSeconds(s);
        String[] time1 = deltaTime.toString().split("[:.]");
        while(true) {
            if (i == 1) {
                break;
            }
            String[] time2 = LocalTime.now().toString().split("[:.]");
            if ((time2[2]).equals(time1[2])) {
                i = 1;
            }
        }


    }

        public void registrationErrorReset(){
            registration_error.setText(null);
        }
        public void registrationPwdReset(){
            registration_password.setText(null);
        }

        public void registrationPwd2Reset(){
            registration_password2.setText(null);
        }

        public TextField getLogin_username() {
            return login_username;
        }
    }




