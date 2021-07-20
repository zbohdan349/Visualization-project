package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MyList extends LinkedList<String> {
    private HBox node;
    public MyList(){
        this.node=new HBox();
    }
    public void setNode(HBox node) {
        this.node = node;
    }


    public void myAdd(String s) {
        ListElement  el= new ListElement("",s,"","");

        node.getChildren().add(el);
        try{
            TranslateTransition st = new TranslateTransition(Duration.millis(1), el);
            //
            st.setToY(-60);
            el.setLayoutY(-60);
            st.setOnFinished(event -> {
                TranslateTransition st1 = new TranslateTransition(Duration.millis(600), el);
                st1.setToY(0);
                st1.setOnFinished(event1 -> {
                    replace();
                });
                st1.play();

            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
        super.add(s);


    }
    public void addId(int index, String s) {
        ListElement  el= new ListElement("",s,"","");

        node.getChildren().add(index,el);
        try{
            TranslateTransition st = new TranslateTransition(Duration.millis(1), el);
            //
            st.setToY(-60);
            el.setLayoutY(-60);
            st.setOnFinished(event -> {
                TranslateTransition st1 = new TranslateTransition(Duration.millis(600),node.getChildren().get(index));
                st1.setToY(0);
                st1.setOnFinished(event1 -> {
                    replace();
                });
                st1.play();

            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
        super.add(index,s);


    }
    public void myPush(String s) {
        ListElement  el= new ListElement("",s,"","");

        node.getChildren().add(0,el);
        try{
            TranslateTransition st = new TranslateTransition(Duration.millis(1), el);
            //
            st.setToY(-60);
            el.setLayoutY(-60);
            st.setOnFinished(event -> {
                TranslateTransition st1 = new TranslateTransition(Duration.millis(600), el);
                st1.setToY(0);
                st1.setOnFinished(event1 -> {
                    replace();
                });
                st1.play();
            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
        super.push(s);
    }
    public void myGet(int index) {
        try {
            TranslateTransition st = new TranslateTransition(Duration.millis(1000), node.getChildren().get(index));
            //st.setByX(1.5f);
            st.setToY(-30);
            st.setAutoReverse(true);
            st.setCycleCount(4);
            st.setAutoReverse(true);
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
    }
    public void myRem(int index) {
        try{

            TranslateTransition st = new TranslateTransition(Duration.millis(200), node.getChildren().get(index));
            //st.setByX(1.5f);
            st.setToY(-200);

            st.setOnFinished(event -> {
                node.getChildren().remove(index);
                replace();
            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
        super.remove(index);

    }
    @Override
    public void clear() {
        node.getChildren().clear();
        super.clear();
    }
    public void myPoll() {
        try{
            TranslateTransition st = new TranslateTransition(Duration.millis(200), node.getChildren().get(0));
            //st.setByX(1.5f);
            st.setToY(-200);

            st.setOnFinished(event -> {
                node.getChildren().remove(0);
                replace();
            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
         super.poll();
    }
    public void myPollLast() {
        try{
            super.pollLast();
            TranslateTransition st = new TranslateTransition(Duration.millis(200), node.getChildren().get(this.size()));
            //st.setByX(1.5f);
            st.setToY(-200);

            st.setOnFinished(event -> {
                node.getChildren().remove(this.size());
                replace();
            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
    }
    public void myPeek() {
        try {
            TranslateTransition st = new TranslateTransition(Duration.millis(1000), node.getChildren().get(0));
            //st.setByX(1.5f);
            st.setToY(-30);
            st.setAutoReverse(true);
            st.setCycleCount(4);
            st.setAutoReverse(true);
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
    }
    public void myPeekLast() {
        try {
            TranslateTransition st = new TranslateTransition(Duration.millis(1000), node.getChildren().get(this.size()-1));
            //st.setByX(1.5f);
            st.setToY(-30);
            st.setAutoReverse(true);
            st.setCycleCount(4);
            st.setAutoReverse(true);
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
    }



    public void replace(){
        node.getChildren().clear();
        for (int i =0;i<this.size();i++)
            try{
                node.getChildren().add(new ListElement("",this.get(i),this.get(i-1),this.get(i+1)));
            }catch (IndexOutOfBoundsException e){
                if(this.size()-1==0){
                    node.getChildren().add(new ListElement("голова/хвіст",this.get(i),"NULL","NULL"));
                    break;
                }
                if(i ==this.size()-1){
                    node.getChildren().add(
                            new ListElement("хвіст",
                                    this.get(i),this.get(i-1),
                                    "NULL"));
                    continue;
                }
                if(i ==0){
                    node.getChildren().add(new ListElement("голова",
                            this.get(i),
                            "NULL",
                            this.get(i+1)));
                    continue;
                }
            }

    }
}
class ListElement extends VBox {

    Object value;

    Label st;

    private VBox body;

    Label labelValue;

    Label prevValue;

    Label nextValue;



    ListElement(String status,Object value,String prev,String next) {

        this.value = value;
        this.labelValue = new Label(value.toString());
        st=new Label(status);
        prevValue = new Label("Адреса ел.: "+prev);
        nextValue=new Label("Адреса ел.: "+next);
        body =new VBox();


        // this.setPrefSize(80,80);
        // this.setMaxHeight(100);
        // VBox.setVgrow(this, Priority.NEVER);
        nextValue.getStylesheets().add("/fxml/el.css");
        prevValue.getStylesheets().add("/fxml/el.css");
        nextValue.setId("label1");
        prevValue.setId("label1");
        prevValue.setStyle("-fx-text-fill: #E0F72E;");
        nextValue.setStyle("-fx-text-fill: #2EA214;");

        body.getStylesheets().add("/fxml/el.css");
        body.setId("ArrayListElement");
        this.getStylesheets().add("/fxml/el.css");
        this.setId("ArrayListMain");
        body.getChildren().addAll(labelValue,prevValue,nextValue);
        this.getChildren().addAll(st,body);
    }

    public void changeValue(String value){
        this.value=value;
        labelValue.setText(value);
    }
}
