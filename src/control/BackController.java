package control;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.Main;

import java.io.IOException;

public class BackController {

    @FXML
    private Button btnBack;

    @FXML
    private Label text;

    @FXML
    void back(ActionEvent event) throws IOException {
        Main.getMainWindow().
                getChildren().
                removeAll(Main.getBack(),Main.getProgramWindow());
        Main.getMainWindow().
                getChildren().add(Main.changeProgramWindow("/fxml/mainWindow.fxml"));

    }

}
