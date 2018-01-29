/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgrid;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Runnan Dong
 * pawprint:rdyz6
 * date:Jan 27th
 * **/

public class FXMLDocumentController implements Initializable,Startable {
 public Stage stage;
    public buildCheckerBoard checkerBoard;
    
    @FXML
    public VBox vbox;
    
    @FXML
    public MenuBar menuBar;
    
    @FXML
    public AnchorPane anchorPane;
   
    
    @FXML
    public void resize3x3(ActionEvent event)
    {
        double height =this.checkerBoard.getHeight(stage.getScene().getHeight() - menuBar.getHeight());
        double width = this.checkerBoard.getWidth(stage.getScene().getWidth());
        refresh(new buildCheckerBoard(3, 3, height, width, this.checkerBoard.getLightColor(), this.checkerBoard.getDarkColor()));

    }
    
    @FXML
    public void resize8x8(ActionEvent event)
    {
        double height =this.checkerBoard.getHeight(stage.getScene().getHeight() - menuBar.getHeight());
        double width = this.checkerBoard.getWidth(stage.getScene().getWidth());
        refresh(new buildCheckerBoard(8, 8, height,width, this.checkerBoard.getLightColor(), this.checkerBoard.getDarkColor()));
    }
    
    @FXML
    public void resize10x10(ActionEvent event)
    {
        double height =this.checkerBoard.getHeight(stage.getScene().getHeight() - menuBar.getHeight());
        double width = this.checkerBoard.getWidth(stage.getScene().getWidth());
        refresh(new buildCheckerBoard(10, 10, height, width, this.checkerBoard.getLightColor(), this.checkerBoard.getDarkColor()));
    }
    
    @FXML
    public void resize16x16(ActionEvent event)
    {
        double height =this.checkerBoard.getHeight(stage.getScene().getHeight() - menuBar.getHeight());
        double width = this.checkerBoard.getWidth(stage.getScene().getWidth());
        refresh(new buildCheckerBoard(16, 16, height, width, this.checkerBoard.getLightColor(), this.checkerBoard.getDarkColor()));
    }
    
    @FXML
    public void DefaultColor(ActionEvent event)
    {
        double height =this.checkerBoard.getHeight(stage.getScene().getHeight() - menuBar.getHeight());
        double width = this.checkerBoard.getWidth(stage.getScene().getWidth());
        refresh(new buildCheckerBoard(this.checkerBoard.getNumRows(), this.checkerBoard.getNumCols(), height, width,Color.RED, Color.BLACK));
    }

    @FXML
    public void BlueColor(ActionEvent event)
    {
        double height =this.checkerBoard.getHeight(stage.getScene().getHeight() - menuBar.getHeight());
        double width = this.checkerBoard.getWidth(stage.getScene().getWidth());
        refresh(new buildCheckerBoard(this.checkerBoard.getNumRows(), this.checkerBoard.getNumCols(),height, width, Color.SKYBLUE, Color.DARKBLUE));
    }
    
    
    @Override
    public void start(Stage stage)
    {
        this.stage = stage;
        refresh(new buildCheckerBoard(8, 8, anchorPane.getHeight(), anchorPane.getWidth()));
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue)
                -> {
            refresh(new buildCheckerBoard(this.checkerBoard.getNumRows(), this.checkerBoard.getNumCols(), stage.getScene().getHeight() - menuBar.getHeight(), stage.getScene().getWidth(), this.checkerBoard.getLightColor(), this.checkerBoard.getDarkColor()));
        };
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       System.out.println(AnchorPane.getTopAnchor(vbox));
    }    
    
    public void refresh(buildCheckerBoard checkerBoard)
    {
       if(checkerBoard.build() != null)
        {
             vbox.getChildren().remove(anchorPane);
            anchorPane = checkerBoard.getBoard();
            vbox.getChildren().add(anchorPane);
            this.checkerBoard = checkerBoard;
        }
       else{
          System.out.println("Error!");
       }
            
       
        
    }
        
        
}
    
