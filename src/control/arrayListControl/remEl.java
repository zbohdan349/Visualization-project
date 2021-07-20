package control.arrayListControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class remEl {

    @FXML
    private ComboBox<Integer> Com;

    @FXML
    private Button btnOk;

    @FXML
    void rem(ActionEvent event) {
       ArrayListController.getCol().myRem(Com.getValue());
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @FXML
    void initialize()
    {
        if(ArrayListController.getCol().size()!=0)
        {
            for (int i=0;i<ArrayListController.getCol().size();i++)
            {
                Com.getItems().add(i);
            }
        }
    }

}
