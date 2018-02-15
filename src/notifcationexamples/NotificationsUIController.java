/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifcationexamples;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import taskers.*;

/**
 * FXML Controller class
 *
 * @author dalemusser
 */
public class NotificationsUIController implements Initializable, Notifiable {

    @FXML
    private TextArea textArea;
    
    @FXML
    public Button Task1;
    @FXML
    public Button Task2;
    @FXML
    public Button Task3;
    
    private Task1 task1;
    private Task2 task2;
    private Task3 task3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void start(Stage stage) {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                if (task1 != null){
                    task1.end();
                    //Task1.setText("Stop");
                }
                if (task2 != null){
                    task2.end();
                    //Task2.setText("Stop");
                }
                if (task3 != null){
                    task3.end();
                   // Task3.setText("Stop");
                }
            }
        });
    }
    
    @FXML
    public void startTask1(ActionEvent event) {
        System.out.println("start task 1");
        if (Task1.getText() == "Stop"){
            endTask1();
        }
        else{
            if (task1 == null) {
                task1 = new Task1(2147483647, 1000000);
                task1.setNotificationTarget(this);
                task1.start();
            }
            
        }
        if (task1 == null){
            Task1.setText("Task 1");
        }
        else if (task1 != null){
            Task1.setText("Stop");
        }
        
        
    }
    
    @Override
    public void notify(String message) {
        if (message.equals("Task1 done.")) {
            task1 = null;
        }
        textArea.appendText(message + "\n");
    }
    
    @FXML
    public void startTask2(ActionEvent event) {
        System.out.println("start task 2");
        
        
        if(Task2.getText() == "Stop"){
            endTask2();
            
        } else if (task2 == null) {
            task2 = new Task2(2147483647, 1000000);
            task2.setOnNotification((String message) -> {
                textArea.appendText(message + "\n");
            });

            task2.start();
            Task2.setText("Negative");
        }
        
        if(task2 != null){
            Task2.setText("Stop");
        }
        else if (task2 == null){
            Task2.setText("Task 2");
        }
    }
    
   
        
    
    @FXML
    public void startTask3(ActionEvent event) {
        System.out.println("start task 3");
        if(Task3.getText() == "Stop"){
            endTask3();
            
        } else if (task3 == null) {
            task3 = new Task3(2147483647, 1000000);

            task3.addPropertyChangeListener((PropertyChangeEvent evt) -> {
                textArea.appendText((String) evt.getNewValue() + "\n");
            });
            task3.start();
            Task3.setText("Negative");
        }
        
        if(task3 != null){
            Task3.setText("Stop");
        }
        else if (task3 == null){
            Task3.setText("Task 3");
        }
    }
    
    @FXML
    public void endTask1(){
        task1.end();
        task1 = null;
        textArea.appendText("Task1 stopped\n");
        
    }
    @FXML
    public void endTask2(){
        task2.end();
        task2 = null;
        textArea.appendText("Task2 stopped\n");
    }
    @FXML
    public void endTask3(){
        task3.end();
        task3 = null;
        textArea.appendText("Task3 stopped\n");
    }
}
