package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    private static VBox mainWindow;
    private static HBox menu;
    private static HBox back;
    private static VBox programWindow;

    @Override
    public void start(Stage primaryStage) throws IOException {


        mainWindow = new VBox();
        menu=FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
        programWindow =FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));
        back=FXMLLoader.load(getClass().getResource("/fxml/back.fxml"));



        //mainWindow=FXMLLoader.load(getClass().getResource("../fxml/back.fxml"));
        mainWindow.getChildren().addAll(menu,programWindow);


        primaryStage.setTitle("2-КТ-17 Жаров Богдан,Колекції");
        Image applicationIcon = new Image("icon2.png");
        primaryStage.getIcons().add(applicationIcon);
        primaryStage.setScene(new Scene(mainWindow));
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    public static VBox getMainWindow() {
        return mainWindow;
    }
    public static HBox getMenu() {
        return menu;
    }

    public static VBox getProgramWindow() {
        return programWindow;
    }
    public static HBox getBack() { return back; }
    public static VBox changeProgramWindow(String s) throws IOException {

        programWindow=FXMLLoader.load(Main.class.getResource(s));
        return programWindow;
    }
}

