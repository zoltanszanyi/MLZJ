package hu.unideb.inf;

import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class MainApp extends Application {
    User_interface userInterface = new User_interface();

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLBelepes.fxml"));
        Scene scene = new Scene((Parent) loader.load());
        stage.setTitle("Kezdőlap");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        FXMLBelepes belepes = new FXMLBelepes();
        Users users = new Users();
        Bicicle bic = new Bicicle();
        User_interface userInterface = new User_interface();
        ArrayList<Users> usersList = new ArrayList<>();
        ArrayList<Location> locations = new ArrayList<>();

    }
    /*--------- Ellenőrzi, hogy az Email használatban van-e már ---------*/
    public boolean checkEmailInUse(String a, String b)
    {
        if(a.equals(b))
            return true;
        return false;
    }

    /*--------- Ellenőrzi, hogy a jelszó használatban van-e már ---------*/
    public boolean registerPw(String pw1,String pw2) {
        if(pw1.equals(pw2)){
            return true;
        }
        return false;
    }
    public void getLocationArray(){
        Location loc = new Location();
        /*ObservableList<String> combo = FXCollections.observableArrayList("Debrecen", "Nyíregyháza", "Levelek");
        for (Location num : loc.locationsClass) {
            combo.add(num.getName());
        }
        userInterface.setSelectLocation();*/
    }

}


