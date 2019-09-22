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
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Group;


public class PaneOrganizer {
    private BorderPane root;
    private HBox buttonsContainer;
    private Pane board1,board2;   
    private Label label1;
    private Button b1,b2,b3,b4,b5;
    
    private Tablero t=new Tablero();
    
    public PaneOrganizer(){       
        root=new BorderPane();
        buttonsContainer=new HBox();                
        
        board1=new Pane();
        board2=t.getPane();           
        
        label1=new Label("Come on, try it!");
        b1=new Button("Ding");
        b2=new Button("Dong");               
        
        b3=new Button("Pane from another paneOrg");
        b4=new Button("return to initial Pane");
        
        b1.setOnAction(new DingDongHandler());                  
        b2.setOnAction(new DingDongHandler());
         
        b3.setOnAction(e->{
            root.getChildren().remove(root.getCenter());
            root.setCenter(board2);
            System.out.println(root.getChildren().toString());
        });
        b4.setOnAction(e->{
            root.getChildren().remove(root.getCenter());
            root.setCenter(board1);
            System.out.println(root.getChildren().toString());       
        });
        
        b5=new Button("third Pane!!");
        b5.setOnAction(e->{
            Pane pi=new Pane();
            root.getChildren().remove(root.getCenter());
            root.setCenter(pi);
            System.out.println(root.getChildren().toString());              
        });
        /* it works but show fix initial size
        Group g=new Group(board2,board1);
        board2.setVisible(false);
        b3.setOnAction(e->{        
            //root.getCenter();               
            board1.toBack();        
            board1.setVisible(false);
            board2.setVisible(true);
        });
        b4.setOnAction(e->{            
            board1.toFront();
            board1.setVisible(true);
            board2.setVisible(false);
        });
        */
        
              
        buttonsContainer.getChildren().addAll(b1,b2,b3,b4);
        buttonsContainer.setAlignment(Pos.CENTER);
        
        board1.setMaxSize(200,200);
        board1.getChildren().add(label1);
        board1.setStyle("-fx-background-color:#de4918");              
               
        root.setCenter(board1);
        root.setBottom(buttonsContainer);                
    }

    public BorderPane getRoot() {
        return root;
    }
   
    private class DingDongHandler implements EventHandler<ActionEvent>{        
        @Override
        public void handle(ActionEvent e){
            if(e.getSource()==b1){
                label1.setText("Button: "+b1.getText());
            }
            if(e.getSource()==b2){
                label1.setText("Button: "+b2.getText());
            }
        }
    }     
}
