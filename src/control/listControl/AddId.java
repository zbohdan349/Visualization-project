package control.listControl;

import control.arrayListControl.ArrayListController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddId {

    @FXML
    private TextField id;

    @FXML
    private TextField text;

    @FXML
    private Button btnOk;

    @FXML
    void ok(ActionEvent event) {
        try{
            List.getCol().addId(Integer.parseInt(id.getText()),text.getText());
        }catch (IndexOutOfBoundsException e){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Для цього методу потрібно вказувати індекс в межах списку(тобто останній доступний ідекс - індекс останнього елементу)");
            alert1.showAndWait();
        }catch (NumberFormatException e){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Некоректно введений індекс");
            alert1.showAndWait();
        }
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
