package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PainterController {
    private Color myColor;
    @FXML
    private RadioButton penButton;
    @FXML
    private RadioButton eraseButton;
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private TitledPane titledPane;

    public PainterController(){
        myColor = Color.BLACK;
    }
    @FXML
    public void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    public void drawingAreaMouseDragged( MouseEvent event){

        Circle newCircle = new Circle( event.getX(), event.getY(), 4, myColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    public void eraseAction(ActionEvent event) {
        System.out.println( event.getEventType());
        myColor = Color.WHITE;
        penButton.setSelected(false);
    }

    @FXML
    public void penAction(ActionEvent event) {
        System.out.println( event.getEventType());

        myColor = Color.BLACK;
        eraseButton.setSelected(false);
    }

}
