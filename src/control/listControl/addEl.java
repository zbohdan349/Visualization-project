package control.listControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addEl {

    @FXML
    private Button btnOk;

    @FXML
    private TextField label;

    private static int Status =2;

    public static void  setStatus(int status) {
        Status = status;
    }

    @FXML
    void ok(ActionEvent event) {
        if(Status == 1){
            List.getCol().myAdd(label.getText());
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        if(Status == 0){
            List.getCol().myPush(label.getText());
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }

    }

}