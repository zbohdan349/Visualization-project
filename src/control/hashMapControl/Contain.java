package control.hashMapControl;

import java.net.URL;
import java.util.ResourceBundle;

import control.arrayListControl.AddController;
import control.arrayListControl.ArrayListController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Contain {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton tog2;

    @FXML
    private ToggleGroup group;

    @FXML
    private Button btnOk;

    @FXML
    private RadioButton tog1;

    @FXML
    private HBox met1;

    @FXML
    private TextField value_1;

    @FXML
    private Pane met2;

    @FXML
    private TextField value_2;


    private list mas[]=new list[2];

    @FXML
    void ok(ActionEvent event) {
        int k = -1;
        for (int i = 0; i < 2; i++) {
            if (mas[i].tog.isSelected()) k = i;
        }

        switch (k) {
            case 0:
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
               if(Map.getCol().containsKey(Integer.parseInt(value_1.getText()))){
                   alert1.setContentText("Такий ключ існує");
                   alert1.showAndWait();
               }
               else{
                   alert1.setContentText("Такий ключ не існує");
                   alert1.showAndWait();
               }


                break;
            case 1:
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                if(Map.getCol().containsValue(value_2.getText())){
                    alert2.setContentText("Таке значення існує");
                }
                if(Map.getCol().containsValue(value_2.getText())==false){
                    alert2.setContentText("Таке значення не існує");
                }
                alert2.showAndWait();
                break;
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    class list{
        Toggle tog;
        Node node;

        list(Toggle tog, Node node){
            this.tog=tog;
            this.node=node;
        }
    }

    @FXML
    void initialize() {
        mas[0]= new list(tog1,met1);
        mas[1]=new list(tog2,met2);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){

                for (int i=0;i<2;i++)
                    if(mas[i].tog==oldValue)mas[i].node.setDisable(true);

                for (int i=0;i<2;i++)
                    if(mas[i].tog==newValue)mas[i].node.setDisable(false);
            }


        });

    }
}
