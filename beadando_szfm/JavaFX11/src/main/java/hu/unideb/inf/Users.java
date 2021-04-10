package hu.unideb.inf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users{
    private int userID;
    private String email;
    private String password;

    public Users(int userID, String email, String password) {
        this.userID = userID;
        this.email = email;
        this.password = password;
    }


    public Users() {
    }


    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public boolean checkPassword(String pw) {
        //felveszem a változókat hogy nyomon tudjuk követni hogy megfelel-e
        boolean nagy = false;
        boolean szam = false;
        boolean spec = false;
        boolean kis = false;
        boolean hossz = false;

        if (pw.length() >= 7)//jelszó hosszának ellenőrzése
            hossz = true;
        if (pw.matches("(?=.*[0-9]).*"))//szám ellenőrzése
            szam = true;
        if (pw.matches("(?=.*[a-z]).*"))//kis betük ellenőrzése
            kis = true;
        if (pw.matches("(?=.*[A-Z]).*"))//nagy betűk ellenőrzése
            nagy = true;
        if (pw.matches("(?=.*[~!@#+$%^&*()_-]).*"))//speciális karakterek ellenőrzése
            spec = true;

        if (nagy && szam && spec && kis && hossz)//ha mindegyik teljesül akkor egy igaz értéket ad vissza ha nem akkor hamisat
            return true;
        else
            return false;
    }
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
            "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?" +
            "[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\" +
            "x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);


    public boolean emailValidator(String email){

        if (email == null) {
            return false;
        }

        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
