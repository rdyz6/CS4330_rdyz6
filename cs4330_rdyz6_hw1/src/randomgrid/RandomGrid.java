/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *CS4330 lesson2, Random Grid
 * JavaFXML different with JavaFX?
 */
package randomgrid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Toothless521
 */
public class RandomGrid extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = Loader.load();
     // FXMLDocumentController controller = Loader.getController();
        Startable controller = (Startable) Loader.getController();
        
        //Object oc=(Object)controller;
        //Initializable ic = (Initializable) controller;
        
        
        
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //getclass return class metadata
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        controller.start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
