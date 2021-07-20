package control.hashMapControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.MyMap;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Map {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnGet;

    @FXML
    private Button btnContain;

    @FXML
    private Button btnPut;

    @FXML
    private HBox ColView;

    private static MyMap col;



    @FXML
    void put(ActionEvent event) {
        openAlert("/fxml/lab/hashMap/put.fxml");
    }
    @FXML
    void contain(ActionEvent event) {
        openAlert("/fxml/lab/hashMap/contain.fxml");
    }
    @FXML
    void get(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Введіть значення:");
        dialog.setContentText("Значення:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
           col.myGet(Integer.parseInt(name));
        });
    }
    @FXML
    void remove(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Введіть значення:");
        dialog.setContentText("Значення:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            col.myRemove(Integer.parseInt(name));
        });
    }

    @FXML
    void clear(ActionEvent event) {
        col.clear();
    }
    @FXML
    void initialize() {
        col =new MyMap();
        col.setNode(ColView);
        col.replaceNode();

    }
    public void openAlert(String s) {
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
    public static MyMap getCol() {
        return col;
    }
}
