/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_9_Tuttoring.PacmanJavaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {                
        PaneOrg game=new PaneOrg();
        Scene scene=new Scene(game.getRoot(),400,400);            
        /*
          for keyboard events the node which has the key handler
          should have the focus, use requestFocus()
        */
        game.getContainer().requestFocus();
        //System.out.println(scene.getFocusOwner().toString());               
        primaryStage.setTitle("Pacman con hambre!");
        primaryStage.setScene(scene);        
        primaryStage.show();        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
