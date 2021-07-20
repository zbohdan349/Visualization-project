package control.arrayListControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.MyArrayList;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayListController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnGet;

    @FXML
    private Button btnSet;

    @FXML
    private Button btnAdd;

    @FXML
    private  HBox ColView;


    private static MyArrayList col = new MyArrayList() ;

    @FXML
    void add(ActionEvent event) throws InterruptedException {

        openAlert("/fxml/lab/arrayList/addEl.fxml");
        //ColView.getChildren().add(new ArrayListElement("ntcn",0));
    }

    @FXML
    void clear(ActionEvent event) {
        col.clear();
    }

    @FXML
    void get(ActionEvent event) throws InterruptedException {
        if(col.size()>0)
            openAlert("/fxml/lab/arrayList/getEl.fxml");
        else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Колеція порожня");
            alert1.showAndWait();
        }
    }



    @FXML
    void remove(ActionEvent event) throws InterruptedException {
        if(col.size()>0)
            openAlert("/fxml/lab/arrayList/remEl.fxml");
         else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Колеція порожня");
            alert1.showAndWait();
        }


    }

    @FXML
    void set(ActionEvent event) throws InterruptedException {
        openAlert("/fxml/lab/arrayList/SetEl.fxml");
    }
    @FXML
    void initialize() {
        col.setNode(ColView);
        col.replace();


    }

    public void openAlert(String s) throws InterruptedException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(s));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }


    public static MyArrayList getCol() {
        return col;
    }
}


