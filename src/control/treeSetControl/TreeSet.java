package control.treeSetControl;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.MyTreeSet;


public class TreeSet {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clear;

    @FXML
    private Button pollLast;

    @FXML
    private Button pollFirst;

    @FXML
    private Button last;

    @FXML
    private Button first;

    @FXML
    private Button floor;

    @FXML
    private Button ceiling;

    @FXML
    private Button add;

    @FXML
    private HBox ColView;

    private static MyTreeSet col = new MyTreeSet() ;

    @FXML
    void add(ActionEvent event) throws InterruptedException {
        openAlert("/fxml/lab/TreeSet/addEl.fxml");
    }

    @FXML
    void ceiling(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Введіть значення:");
        dialog.setContentText("Значення:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            col.myCeiling(Integer.parseInt(name));
        });
    }

    @FXML
    void clear(ActionEvent event) {
        col.clear();
    }

    @FXML
    void first(ActionEvent event) {
        col.myFirst();
    }

    @FXML
    void floor(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Введіть значення:");
        dialog.setContentText("Значення:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            col.myFloor(Integer.parseInt(name));
        });
    }

    @FXML
    void last(ActionEvent event) {
        col.myLast();
    }

    @FXML
    void pollFirst(ActionEvent event) {
        col.myPollFirst();
    }

    @FXML
    void pollLast(ActionEvent event) {
        col.myPollLast();
    }



    @FXML
    void initialize() {

        col.setNode(ColView);
        col.replace();
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


    public static MyTreeSet getCol() {
        return col;
    }

}

