package control.hashMapControl;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Put {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOk;

    @FXML
    private TextField label;

    @FXML
    private TextField label1;

    @FXML
    void ok(ActionEvent event) {
        Integer k = Integer.parseInt(label.getText());
        Map.getCol().myPut(k ,label1.getText());
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void initialize() {


    }
}
