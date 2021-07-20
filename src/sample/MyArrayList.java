package sample;


import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collection;

public class MyArrayList extends ArrayList<String> {
    private HBox node;
    public MyArrayList(){
        this.node=new HBox();
    }

    public void setNode(HBox node) {
        this.node = node;
    }


    public void myGet(int index) {
        TranslateTransition st = new TranslateTransition(Duration.millis(1000), node.getChildren().get(index));
        //st.setByX(1.5f);
        st.setToY(-30);
        st.setAutoReverse(true);
        st.setCycleCount(4);
        st.setAutoReverse(true);
        st.play();
    }

    @Override
    public boolean add(String s) {
        ArrayListElement el= new ArrayListElement(s,this.size());

       node.getChildren().add(el);
       try{
            TranslateTransition st = new TranslateTransition(Duration.millis(1), el);
            //
            st.setToY(-60);
            el.setLayoutY(-60);
            st.setOnFinished(event -> {
                TranslateTransition st1 = new TranslateTransition(Duration.millis(600), el);
                st1.setToY(0);
                st1.play();
                //replace();
            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
        //node.getChildren().add(el);
        return super.add(s);
    }

    @Override
    public void add(int index, String s) {

        ArrayListElement el= new ArrayListElement(s,index);
        node.getChildren().add(index,el);
        try{
            TranslateTransition st = new TranslateTransition(Duration.millis(1), el);
            //
            st.setToY(-60);
            el.setLayoutY(-60);
            st.setOnFinished(event -> {
                TranslateTransition st1 = new TranslateTransition(Duration.millis(600), el);
                st1.setToY(0);
                st1.setOnFinished(event1 -> {
                    node.getChildren().remove(index , this.size());
                    for(int i=index ;i<this.size();i++){
                        node.getChildren().add(new ArrayListElement(this.get(i),i));
                    }
                });
                st1.play();
            });
            st.play();
        }catch (IndexOutOfBoundsException e){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Колекція порожня");
            alert.showAndWait();
        }
       /* node.getChildren().remove(index-1 , this.size());
        for(int i=index ;i<this.size();i++){

            node.getChildren().add(new ArrayListElement(this.get(i),i));
        }*/
        super.add(index, s);
    }


    public void myRem(int index) {
        try{
            TranslateTransition st = new TranslateTransition(Duration.millis(200), node.getChildren().get(index));
            //st.setByX(1.5f);
            st.setToY(-200);

            int finalK = index;
            st.setOnFinished(event -> {
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


    public void myAddAll(Collection<? extends String> c) {

        ArrayList<String> s=new ArrayList<String>(c);

        for(int i=0 ;i< 2;i++){
            ArrayListElement el=new ArrayListElement(s.get(i),this.size()+i);
            node.getChildren().add(el);
            try{
                TranslateTransition st = new TranslateTransition(Duration.millis(1), el);
                //
                st.setToY(-60);
                el.setLayoutY(-60);
                st.setOnFinished(event -> {
                    TranslateTransition st1 = new TranslateTransition(Duration.millis(600), el);
                    st1.setToY(0);
                    st1.play();
                    //replace();
                });
                st.play();
            }catch (IndexOutOfBoundsException e){
                Alert alert =new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Колекція порожня");
                alert.showAndWait();
            }
        }

         super.addAll(c);
    }


    @Override
    public String set(int index, String element) {
       if(node.getChildren().get(index) instanceof ArrayListElement)
           ((ArrayListElement) node.getChildren().get(index)).changeValue(element);

        //
        return super.set(index, element);
    }

    public void addAll2(int index, ArrayList s) {
        for(int i=0 ;i< 2;i++){
            ArrayListElement el=new ArrayListElement(s.get(i),index+i);
            node.getChildren().add(index+i,el);
            try{
                TranslateTransition st = new TranslateTransition(Duration.millis(1), el);
                //
                st.setToY(-60);
                el.setLayoutY(-60);
                st.setOnFinished(event -> {
                    TranslateTransition st1 = new TranslateTransition(Duration.millis(600), el);
                    st1.setToY(0);
                    st1.play();
                    st1.setOnFinished(event1 -> {
                        replace();
                    });

                });
                st.play();
            }catch (IndexOutOfBoundsException e){
                Alert alert =new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Колекція порожня");
                alert.showAndWait();
            }
        }
        super.addAll(index,s);
        //replace();
        }
    public void replace(){
        node.getChildren().clear();
        for (int i =0;i<this.size();i++)
            node.getChildren().add(new ArrayListElement(this.get(i), i));
    }
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }

}
class ArrayListElement extends VBox {
    int id;

    private VBox body;

    public int getMyId() {
        return id;
    }

    Object value;

    public Object getValue() {
        return value;
    }

    Label labelId;

    Label labelValue;



     ArrayListElement(Object value, int id) {
        this.id = id;
        this.value = value;
        this.labelId = new Label(Integer.toString(id));
        this.labelValue = new Label(value.toString());
        body =new VBox();


        body.getStylesheets().add("/fxml/el.css");
        body.setId("ArrayListElement");
        body.setPrefHeight(100);
        this.getStylesheets().add("/fxml/el.css");
        this.setId("ArrayListMain");
        body.getChildren().addAll(labelValue);
        this.getChildren().addAll(labelId,body);
    }

    public void changeId(int id){
        this.id=id;
        labelId.setText(Integer.toString(this.id));
    }
    public void changeValue(String value){
        this.value=value;
        labelValue.setText(value);
    }
}
