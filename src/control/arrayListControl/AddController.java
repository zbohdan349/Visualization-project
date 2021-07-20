package control.arrayListControl;


import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class AddController {
    private list mas[]=new list[4];

    @FXML
    private RadioButton tog1;

    @FXML
    private RadioButton tog2;

    @FXML
    private RadioButton tog3;

    @FXML
    private RadioButton tog4;

    @FXML
    private HBox met1;

    @FXML
    private Pane met2;

    @FXML
    private Label met3;

    @FXML
    private Pane met4;


    @FXML
    private Button btnOk;

    @FXML
    private ToggleGroup group;

    @FXML
    private TextField value_1=new TextField();

    @FXML
    private TextField value_2;

    @FXML
    private TextField id_2;

    @FXML
    private TextField id_4;

    private  ArrayList<String> S=new ArrayList();




    @FXML
    void ok(ActionEvent event) {
        S.add("Кіт");
        S.add("Собака");



                int k=-1;
                for (int i=0;i<4;i++){
                    if(mas[i].tog.isSelected())k=i;
                }

                switch (k){

                    case 0:
                        ArrayListController.getCol().add(value_1.getText());

                        break;
                    case 1:
                        try{
                            ArrayListController.getCol().add(Integer.parseInt(id_2.getText()),value_2.getText());

                        }catch (IndexOutOfBoundsException e){
                            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                            alert1.setContentText("Для цього методу потрібно вказувати індекс в межах списку(тобто останній доступний ідекс - індекс останнього елементу)");
                            alert1.showAndWait();
                        }catch (NumberFormatException e){
                            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                            alert1.setContentText("Некоректно введений індекс");
                            alert1.showAndWait();
                        }
                        break;
                    case 2:
                        ArrayListController.getCol().myAddAll(S);
                        break;
                    case 3:
                        try {
                            ArrayListController.getCol().addAll2(Integer.parseInt(id_4.getText()), S);
                        }catch (IndexOutOfBoundsException e){
                            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                            alert1.setContentText("Для цього методу потрібно вказувати індекс в межах списку(тобто останній доступний ідекс - індекс останнього елементу)");
                            alert1.showAndWait();
                        }catch (NumberFormatException e){
                            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                            alert1.setContentText("Некоректно введений індекс");
                            alert1.showAndWait();
                        }

                        break;
                    default:
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setContentText("Шото пішло не так");
                        alert1.showAndWait();

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
        mas[0]=new list(tog1,met1);
        mas[1]=new list(tog2,met2);
        mas[2]=new list(tog3,met3);
        mas[3]=new list(tog4,met4);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){

                for (int i=0;i<4;i++)
                    if(mas[i].tog==oldValue)mas[i].node.setDisable(true);

                for (int i=0;i<4;i++)
                    if(mas[i].tog==newValue)mas[i].node.setDisable(false);
            }


        });

    }
}

