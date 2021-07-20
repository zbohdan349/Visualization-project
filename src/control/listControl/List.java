package control.listControl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import control.arrayListControl.ArrayListController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;
import sample.MyList;



public class List {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnRemove;
    @FXML
    private Button btnRem;
    @FXML
    private Button btnAddId;
    @FXML
    private Button btnGet;
    @FXML
    private Button btnPoll;

    @FXML
    private Button btnPeek;

    @FXML
    private Button btnPeekLast;


    @FXML
    private Button btnAdd;

    @FXML
    private HBox ColView;

    public static MyList col =new MyList();


    @FXML
    void add(ActionEvent event) throws InterruptedException {
        addEl.setStatus(1);
        openAlert("/fxml/lab/list/addEl.fxml");

    }

    @FXML
    void push(ActionEvent event) throws InterruptedException {
        addEl.setStatus(0);
        openAlert("/fxml/lab/list/addEl.fxml");

    }
    @FXML
    void addId(ActionEvent event) throws InterruptedException {

        openAlert("/fxml/lab/list/addId.fxml");
    }
    @FXML
    void get(ActionEvent event) throws InterruptedException {
        if (List.getCol().size()>0) {
            try {
                openAlert("/fxml/lab/list/getEl.fxml");
            } catch (IndexOutOfBoundsException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Колекція порожня");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }


    }
    @FXML
    void remove(ActionEvent event) throws InterruptedException {
        if (List.getCol().size()>0) {
            try {
                openAlert("/fxml/lab/list/remEl.fxml");
            } catch (IndexOutOfBoundsException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Колекція порожня");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
    }

    @FXML
    void clear(ActionEvent event) {
        col.clear();
    }

    @FXML
    void peek(ActionEvent event) {
        col.myPeek();
    }
    @FXML
    void peekLast(ActionEvent event) {
        col.myPeekLast();
    }

    @FXML
    void poll(ActionEvent event) {
        col.myPoll();
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
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
    public static MyList getCol() {
        return col;
    }
}

