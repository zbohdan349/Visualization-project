package sample;



import javafx.animation.TranslateTransition;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import java.util.Iterator;
import java.util.TreeSet;

public class MyTreeSet extends TreeSet<Integer> {

        private HBox node;



        public MyTreeSet(){
            this.node=new HBox();
        }

        public void setNode(HBox node) {
            this.node = node;
        }

    @Override
    public boolean add(Integer integer) {
    boolean k =false;
    if(super.add(integer)){
       replace();
        k=true;
    }
    else {
        Alert alert =new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Такий елемент існує");
        alert.showAndWait();
    }
        return k;
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        node.getChildren().clear();
        super.clear();
    }


    public void myFirst() {
        getAnimation(0);
    }


    public void myLast() {
        getAnimation(this.size()-1);
    }


    public void myFloor(Integer integer) {
        try {
            Iterator<Integer> iterator = this.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                if (iterator.next() == super.floor(integer)) {
                    getAnimation(i);
                }
                i++;
            }
        }catch (NullPointerException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Такий елемент не існує");
            alert.showAndWait();
        }
    }


    public void myCeiling(Integer integer) {
        try {
            Iterator<Integer> iterator = this.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                if (iterator.next() == super.ceiling(integer)) {
                    getAnimation(i);
                }
                i++;
            }
        }catch (NullPointerException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Такий елемент не існує");
            alert.showAndWait();
        }
    }


    public void myPollFirst() {

        polAnimation(0);

        super.pollFirst();
    }


    public void myPollLast() {
        polAnimation(this.size()-1);
        super.pollLast();
    }

    public void getAnimation(int index){
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
    public void polAnimation(int index) {
        try{
            TranslateTransition st = new TranslateTransition(Duration.millis(200), node.getChildren().get(index));
            //st.setByX(1.5f);
            st.setToY(-200);

            st.setOnFinished(event -> {
                node.getChildren().remove(index);
            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
    }
    public void replace(){
        node.getChildren().clear();
        Iterator<Integer> iterator = this.iterator();
        while (iterator.hasNext())
            node.getChildren().add(new TreeSetElement(iterator.next()));
    }
}
class TreeSetElement extends VBox {

    private Integer value;

    private Label labelValue;

    private Line Lineleft=new Line();

    public TreeSetElement(Integer value) {
        this.value = value;

        this.labelValue = new Label(value.toString());

        Lineleft.setStartX(labelValue.getLayoutX());
        Lineleft.setStartY(labelValue.getLayoutY());
        Lineleft.setEndX(labelValue.getLayoutX());
        Lineleft.setEndY(labelValue.getLayoutY());

        // this.setPrefSize(80,80);
        // this.setMaxHeight(100);
        // VBox.setVgrow(this, Priority.NEVER);
        this.getStylesheets().add("/fxml/el.css");
        this.setId("ArrayListElement");

        this.getChildren().addAll(labelValue,Lineleft);
    }
    public Integer getValue() {
        return value;
    }
}
