package Unidad_9_Tuttoring.PaneOrganizer;


import javafx.application.Application;
import javafx.event.EventType;

import javafx.stage.Stage;

import javafx.scene.layout.VBox;

import javafx.scene.control.Button;

import javafx.scene.Scene;


public class PaneOrganizerTest extends Application{
    
    public static void main(String[] args){        
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        PaneOrganizer organizer=new PaneOrganizer();                        
     
        Scene scene=new Scene(organizer.getRoot(),500,500);
        
        primaryStage.setTitle("Pane Organizer !!!");
        primaryStage.setScene(scene);
	primaryStage.show();
    }

}
