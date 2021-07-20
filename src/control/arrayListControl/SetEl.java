package control.arrayListControl;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SetEl {

    @FXML
    private ComboBox<Integer> ComboBox =new ComboBox(); ;

    @FXML
    private TextField label;

    @FXML
    private Button btnOk;

    @FXML
    void ok(ActionEvent event) {
        if(ComboBox.getValue()!=null)
            ArrayListController.getCol().set(ComboBox.getValue(),label.getText());
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }
    @FXML
    void set(ActionEvent event) {
        label.setText(ArrayListController.getCol().get(ComboBox.getValue()));

    }
    @FXML
    void initialize() {
        for(int i=0;i<ArrayListController.getCol().size();i++)
            ComboBox.getItems().add(i);
    }

}