

public class Users{
    private int userID;
    private String email;
    private String password;

    public Users(int userID, String email, String password) {
        this.userID = userID;
        this.email = email;
        this.password = password;
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
        if (pw.matches("(?=.*[~!@#$%^&*()_-]).*"))//speciális karakterek ellenőrzése
            spec = true;

        if (nagy && szam && spec && kis && hossz)//ha mindegyik teljesül akkor egy igaz értéket ad vissza ha nem akkor hamisat
            return true;
        else
            return false;
    }

    /*
    public String checkPassword(String pw)
    {
        boolean nagy = false;
        String nagyB = "Nincs benne nagy betű";
        boolean szam = false;
        String szamN = "Nincs benne szám";
        boolean spec = false;
        String specC = "Nincs benne speciális karakter";
        boolean kis = false;
        String kisB = "Nincs benne kis betű";
        boolean hossz = false;
        String hossza = "Nem elegendő a hossza";

        if(pw.length() >= 7)//jelszó hosszának ellenőrzése
            hossz = true;
        if(pw.matches("(?=.*[0-9]).*"))//szám ellenőrzése
            szam = true;
        if(pw.matches("(?=.*[a-z]).*"))//kis betük ellenőrzése
            kis = true;
        if(pw.matches("(?=.*[A-Z]).*"))//nagy betűk ellenőrzése
            nagy = true;
        if(pw.matches("(?=.*[~!@#$%^&*()_-]).*"))//speciális karakterek ellenőrzése
            spec = true;

        if(nagy && szam && spec && kis && hossz)//ha mindegyik teljesül akkor 'Megfelel' értéket ad vissza ha nem akkor kiiírja a hibát
            return "Megfelel";
        else if(nagy)
            return nagyB;
        else if(szam)
            return szamN;
        else if(spec)
            return specC;
        else if(kis)
            return kisB;
        else
            return hossza;
   }
*/
}
