package hu.unideb.inf;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MainApp extends Application {

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
        FXMLBelepes belepes;
        Users users;
        ArrayList<Users> usersList = new ArrayList<>();
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

}


