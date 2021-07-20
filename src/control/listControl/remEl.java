package control.listControl;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.util.Duration;

public class remEl {

    @FXML
    private ComboBox<Integer> Com;

    @FXML
    private Button btnOk;

    @FXML
    void rem(ActionEvent event) {

        if (List.getCol().size()>0) {
            try {
                List.getCol().myRem(Com.getValue());
                ((Node) (event.getSource())).getScene().getWindow().hide();
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
    void initialize() {
        if (List.getCol().size() != 0) {
            for (int i = 0; i < List.getCol().size(); i++) {
                Com.getItems().add(i);
            }
        }
    }

}
