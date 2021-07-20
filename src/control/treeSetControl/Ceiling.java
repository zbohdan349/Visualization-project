package control.treeSetControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Ceiling {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnOk;

    @FXML
    private TextField label;

    @FXML
    void ok(ActionEvent event) {
        TreeSet.getCol().add(Integer.valueOf(label.getText()));
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
