/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_9_Tuttoring.PaneOrganizer;

//App class imports
import javafx.scene.Scene;
import javafx.application.*;
// package includes Pane class and its subclasses
import javafx.scene.layout.*; 
//package includes Label, Button classes
import javafx.scene.control.*;
//package includes ActionEvent, EventHandler classes
import javafx.event.*;
import javafx.geometry.Pos;


public class Tablero {
    private Pane paneTablero;
    private Label labelAviso;
    
    public Tablero(){       
        paneTablero=new Pane();     
        labelAviso=new Label("this is a pane from a new PaneOrg");        
        paneTablero.getChildren().add(labelAviso);
        paneTablero.setMaxSize(310, 310);
        paneTablero.setStyle("-fx-background-color:#aaaeff");
    }

    public Pane getPane() {
        return paneTablero;
    }
   
}
