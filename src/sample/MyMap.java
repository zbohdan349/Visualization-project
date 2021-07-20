package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyMap extends HashMap<Integer, MyMap.MapEl> {
    private HBox node;;

    public MyMap() {
        this.node = new HBox();
    }

    public void setNode(HBox node) {
        this.node = node;
    }

    public void replaceNode() {
        node.getChildren().clear();
        this.forEach((k, v) -> node.getChildren().add(v));
    }


    public void myGet(Integer key) {

        int k = -1;
        for (int i = 0; i < node.getChildren().size(); i++)
            if (node.getChildren().get(i) instanceof MapEl) {
                if (((MapEl) node.getChildren().get(i)).getMyId() == key) k = i;
            }
        TranslateTransition st = new TranslateTransition(Duration.millis(1000), node.getChildren().get(k));
        //st.setByX(1.5f);
        st.setToY(-30);
        st.setAutoReverse(true);
        st.setCycleCount(4);
        st.setAutoReverse(true);
        st.play();
    }

    @Override
    public boolean containsKey(Object key) {

        return super.containsKey(key);
    }


    public void myPut(Integer key, String value) {
        MapEl V = new MapEl(value, key);
        node.getChildren().add(V);
        super.put(key, V);
        replaceNode();
    }

    @Override
    public MapEl remove(Object key) {
        return super.remove(key);
    }

    @Override
    public void clear() {
        node.getChildren().clear();
        super.clear();

    }

    @Override
    public boolean containsValue(Object value) {
        Boolean b = false;
        for (Entry<Integer, MapEl> entry : this.entrySet()) {
            MapEl v = entry.getValue();
            if (v.getValue().equals(value)) b = true;
        }
        return b;
    }


    public void myRemove(Integer key) {
        int k = -1;
        for (int i = 0; i < node.getChildren().size(); i++)
            if (node.getChildren().get(i) instanceof MapEl) {
                if (((MapEl) node.getChildren().get(i)).getMyId() == key) k = i;
            }
        try {
            TranslateTransition st = new TranslateTransition(Duration.millis(200), node.getChildren().get(k));
            //st.setByX(1.5f);
            st.setToY(-200);

            int finalK = k;
            st.setOnFinished(event -> {
                node.getChildren().remove(finalK);
            });
            st.play();
        } catch (IndexOutOfBoundsException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
        super.remove(key);
    }


    public void openAlert(String s) {
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

    class MapEl extends VBox {
        int id;


        public int getMyId() {
            return id;
        }

        Object value;

        public Object getValue() {
            return value;
        }

        Label labelId;

        Label labelValue;

        MapEl(Object value, int id) {
            this.id = id;
            this.value = value;
            this.labelId = new Label(Integer.toString(id));
            this.labelValue = new Label(value.toString());


            this.getStylesheets().add("/fxml/el.css");
            this.setId("ArrayListElement");
            this.getChildren().addAll(labelId, labelValue);
        }

        public void changeId(int id) {
            this.id = id;
            labelId.setText(Integer.toString(this.id));
        }

        public void changeValue(String value) {
            this.value = value;
            labelValue.setText(value);
        }
    }
}