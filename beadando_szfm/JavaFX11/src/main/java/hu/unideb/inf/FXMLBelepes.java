package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

    public void setRegistration_error(Label registration_error) {
        this.registration_error = registration_error;
    }

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

        System.out.println("jelszóóó");
        login_error.setText("Helló");

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
        String pw1 = registration_password.getText();
        String pw2 = registration_password2.getText();
        MainApp app = new MainApp();
        if (app.registerPw(pw1, pw2)) {
            registration_error.setText("Sikeres regisztráció!");

        } else {
            registration_error.setText("Sikertelen regisztráció! A megadott jelszavak NEM egyeznek meg!");
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




