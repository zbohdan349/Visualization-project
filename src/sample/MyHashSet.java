package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyHashSet extends HashSet<String> {

    private HBox node;

    public MyHashSet(){
        this.node=new HBox();
    }
    public void setNode(HBox node) {
        this.node = node;
    }

    public  void myAdd() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Введіть значення:");
        dialog.setContentText("Значення::");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            if(super.add(name)){
                replace();
            }
        });

    }

    public void contains() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Введіть значення:");
        dialog.setContentText("Значення:");

        Optional<String> result = dialog.showAndWait();

        result.ifPresent(name -> {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            if(super.contains(name)){
                alert1.setContentText("Такий елемент існує в колекції");
                alert1.showAndWait();
            }
            if (super.contains(name)== false) {
                alert1.setContentText("Такий елемент не існує в колекції");
                alert1.showAndWait();
            }
        });
    }



    public void myRem()
    {
        try{
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Введіть значення:");
        dialog.setContentText("Значення:");
        Optional<String> result = dialog.showAndWait();
        Iterator <String>iterator =this.iterator();
        result.ifPresent(name ->
        {
            int i =0;
            while (iterator.hasNext() ){
                if(iterator.next().equals(name)){
                        TranslateTransition st = new TranslateTransition(Duration.millis(200), node.getChildren().get(i));
                        //st.setByX(1.5f);
                        st.setToY(-200);
                        int finalI = i;
                        st.setOnFinished(event -> {
                            node.getChildren().remove(finalI);
                        });
                        st.play();
                    break;
                }
               i++;
            }
            super.remove(name);
        });
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
    }



    @Override
    public void clear() {
        node.getChildren().clear();
        super.clear();
    }



    public void replace(){
        Iterator <String>iterator =this.iterator();
        node.getChildren().clear();

        while (iterator.hasNext())
            node.getChildren().add(new HashSetElement(iterator.next()));
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
            stage.setTitle("New Window");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
}
class HashSetElement extends VBox {
    
    String value;

    Label labelValue;

    HashSetElement(String value) {

        this.value = value;
        this.labelValue = new Label(value);


        // this.setPrefSize(80,80);
        // this.setMaxHeight(100);
        // VBox.setVgrow(this, Priority.NEVER);
        this.getStylesheets().add("/fxml/el.css");
        this.setId("ArrayListElement");
        this.getChildren().addAll(labelValue);
    }

}

