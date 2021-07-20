package control.hashSetControl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.MyHashSet;

public class Hash {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRemove;

    @FXML
    private Button contains;

    @FXML
    private Button btnAdd;

    @FXML
    private HBox ColView;



    private static MyHashSet col =new MyHashSet();

    @FXML
    void add(ActionEvent event) {
        col.myAdd();
    }

    @FXML
    void clear(ActionEvent event) {
        col.clear();
    }

    @FXML
    void contains(ActionEvent event) {

        col.contains();
    }

    @FXML
    void remove(ActionEvent event) {

        col.myRem();
    }
    public void openAlert(String s)  {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(s));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    void initialize() {
        col.setNode(ColView);
        col.replace();

    }
    public static MyHashSet getCol() {
        return col;
    }
}
