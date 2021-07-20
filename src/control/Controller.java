package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

import java.io.IOException;

public class Controller {

    @FXML
    private Button btnArrayList;

    @FXML
    private Button btnPriority;

    @FXML
    private Button btnHashSet;

    @FXML
    private Button btnTreeSet;

    @FXML
    private Button btnHashMap;


    @FXML
    void openArrayList(ActionEvent event) throws IOException {
        open("/fxml/lab/arrayList/Arraylist.fxml");

    }
    @FXML
    void openPriority(ActionEvent event) throws IOException {
        open("/fxml/lab/list/list.fxml");

    }

    @FXML
    void openHashSet(ActionEvent event) throws IOException {
        open("/fxml/lab/hashSet/hashSet.fxml");

    }
    @FXML
    void openTreeSet(ActionEvent event) throws IOException {
        open("/fxml/lab/TreeSet/TreeSet.fxml");

    }


    @FXML
    void openHashMap(ActionEvent event) throws IOException {
        open("/fxml/lab/hashMap/map.fxml");

    }




    void open(String s) throws IOException {
        Main.getMainWindow().getChildren().remove(Main.getProgramWindow());
        Main.changeProgramWindow(s);
        Main.getMainWindow().getChildren().add(Main.getBack());
        Main.getMainWindow().getChildren().add(Main.getProgramWindow());

    }

}
